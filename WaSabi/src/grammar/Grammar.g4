grammar Grammar;
options{language = Java;}

//lexer
COMMENT:		'-' '-' ~('\n'|'-' )* ('-' '-' |'\n') {skip();};
WS:				('\t'|'\r'|'\n'|' ') {skip();};

fragment A:'A'|'a';
fragment B:'B'|'b';
fragment C:'C'|'c';
fragment D:'D'|'d';
fragment E:'E'|'e';
fragment F:'F'|'f';
fragment G:'G'|'g';
fragment I:'I'|'i';
fragment J:'J'|'j';
fragment K:'K'|'k';
fragment L:'L'|'l';
fragment M:'M'|'m';
fragment N:'N'|'n';
fragment O:'O'|'o';
fragment P:'P'|'p';
fragment R:'R'|'r';
fragment S:'S'|'s';
fragment T:'T'|'t';
fragment U:'U'|'u';
fragment V:'V'|'v';
fragment NUMBER: (('1'..'9') ('0'..'9')* ('.'('0'..'9')*) ? );

/*03*/OPENBRACKET:	'(' | '[' | '{';
/*04*/CLOSEBRACKET: ')' | ']' | '}';
/*05*/SEPARATOR:	',' | ';';

/*06*/CIRCUIT:	C I R C U I T          ':'?;
/*07*/LIBRARY:	L I B (R A R I E S)?   ':'?;
/*08*/CONST:	C O N S T (A N T S)?   ':'?;
/*09*/COMPONENT:C O M P (O N E N T S)? ':'?;
/*10*/SIMULATE:	S I M (U L A T E )?    ':'?;
/*11*/AT:		A T;

/*12*/MODEL:M O D (E L)?;
/*13*/GND:	G N D;
/*14*/DC:	D C;
/*15*/AC:	A C;
/*16*/PI:	NUMBER? P I;
/*17*/EQUAL:'=';

/*18*/RES: 	R (E S (I S T A N C E)?)?;
/*19*/CAP: 	C (A P (A C I T A N C E )?)?;
/*20*/IND: 	L | (I N D (U C T A N C E)?);
/*21*/VOL: 	V (O L (T A G E)?)?;
/*22*/CUR: 	I | (C U R (R E N T)?);
/*23*/DIO:	D (I O (D E)?)?;
/*24*/BJT:	B (J T )?;
/*25*/MOS:	M (O S (F E T)?)?;
/*26*/JFET:	J (F E T)?;

/*27*/UNIT: F |
			P | 
			N | 
			U | 
			M I L L | 
			K |
			M E G |
			G |
			T;
			
fragment FILENAME: (~('/'|'\\'|':'|'*'|'?'|'<'|'>'|'|'|'\r'|'\t'|'\n')+);


/*28*/PATH: (('A'..'Z' ':')?)
			(('\\')? FILENAME )+
			'.' ('A'..'Z'|'a'..'z')+
			;

/*29*/VALUE: 	NUMBER | '0';
/*30*/MODTYPE:	'<' ('A'..'Z'|'a'..'z'|'0'..'9'|'-')+ '>';
/*31*/ID: 		('A'..'Z'|'a'..'z'|'_') ('0'..'9'|'a'..'z'|'A'..'Z'|'_')*;

/*32*/DIRECTIVE:'.' (~('\n'|'\r'))+;

//parser
/*00*/axiom:		title? pr;
/*01*/pr:			( ( library | constants | components | sim ) pr)?;

/*02*/title:		CIRCUIT ID;

/*03*/library:		LIBRARY listlib;
/*04*/listlib: 		(newlib listlib)?;
/*05*/newlib:		PATH;

/*06*/constants: 	CONST listconst;
/*07*/listconst:	(newconst listconst)?;
/*08*/newconst:		ID EQUAL newconst2;
/*09*/newconst2:	newvalue|newwave|newmod;

/*10*/newvalue:		VALUE units | PI;
/*11*/units:		UNIT?;

/*11*/newwave:		newwaveDC|newwaveAC;
/*12*/newwaveDC:	DC OPENBRACKET valueID CLOSEBRACKET;
/*13*/newwaveAC:	AC OPENBRACKET valueID SEPARATOR valueID CLOSEBRACKET;

/*14*/newmod:		MODTYPE;

/*15*/components:	COMPONENT listcomp;
/*16*/listcomp: 	(newcomp listcomp)?;
/*17*/newcomp:		resistance	|
					capacitance	|
					inductance	|
					voltage		|
					current		|
					diode		|
					bjt			|
					mosfet		|
					jfet		|
					model		;
			
/*18*/resistance:	RES   valueID   AT OPENBRACKET node SEPARATOR node 			      CLOSEBRACKET;
/*19*/capacitance: 	CAP   valueID   AT OPENBRACKET node SEPARATOR node 				  CLOSEBRACKET;
/*20*/inductance:	IND   valueID   AT OPENBRACKET node SEPARATOR node 				  CLOSEBRACKET;
/*21*/voltage:	 	VOL   waveID    AT OPENBRACKET node SEPARATOR node 				  CLOSEBRACKET;
/*22*/current:	 	CUR   waveID    AT OPENBRACKET node SEPARATOR node 				  CLOSEBRACKET;
/*23*/diode:		DIO   modtypeID AT OPENBRACKET node SEPARATOR node 				  CLOSEBRACKET;
/*24*/bjt:			BJT   modtypeID AT OPENBRACKET node SEPARATOR node SEPARATOR node CLOSEBRACKET;
/*25*/mosfet:		MOS   modtypeID AT OPENBRACKET node SEPARATOR node SEPARATOR node CLOSEBRACKET;
/*26*/jfet:			JFET  modtypeID AT OPENBRACKET node SEPARATOR node SEPARATOR node CLOSEBRACKET;
/*27*/model:		MODEL modtypeID AT OPENBRACKET listnodes CLOSEBRACKET;
			
/*28*/node: 		GND		 | ID;
/*29*/valueID: 		newvalue | ID;
/*30*/waveID:		newwave  | ID;	
/*31*/modtypeID:	newmod   | ID;	

/*32*/listnodes:	node listnodes2;
/*33*/listnodes2:	(SEPARATOR node listnodes2)?;

/*34*/sim: 			SIMULATE dirsim;
/*35*/dirsim: 		(newdir dirsim)?;
/*36*/newdir:		DIRECTIVE;
