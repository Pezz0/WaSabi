// Generated from Grammar.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WS=2, OPENBRACKET=3, CLOSEBRACKET=4, SEPARATOR=5, CIRCUIT=6, 
		LIBRARY=7, CONST=8, COMPONENT=9, SIMULATE=10, AT=11, MODEL=12, GND=13, 
		DC=14, AC=15, PI=16, EQUAL=17, RES=18, CAP=19, IND=20, VOL=21, CUR=22, 
		DIO=23, BJT=24, MOS=25, JFET=26, UNIT=27, PATH=28, VALUE=29, MODTYPE=30, 
		ID=31, DIRECTIVE=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '"
	};
	public static final String[] ruleNames = {
		"COMMENT", "WS", "A", "B", "C", "D", "E", "F", "G", "I", "J", "K", "L", 
		"M", "N", "O", "P", "R", "S", "T", "U", "V", "NUMBER", "OPENBRACKET", 
		"CLOSEBRACKET", "SEPARATOR", "CIRCUIT", "LIBRARY", "CONST", "COMPONENT", 
		"SIMULATE", "AT", "MODEL", "GND", "DC", "AC", "PI", "EQUAL", "RES", "CAP", 
		"IND", "VOL", "CUR", "DIO", "BJT", "MOS", "JFET", "UNIT", "FILENAME", 
		"PATH", "VALUE", "MODTYPE", "ID", "DIRECTIVE"
	};


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		case 1: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u01d2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\7\2s\n\2\f\2\16\2v\13\2"+
		"\3\2\3\2\3\2\5\2{\n\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u00ae\n\30\f\30\16\30\u00b1\13"+
		"\30\3\30\5\30\u00b4\n\30\5\30\u00b6\n\30\3\30\7\30\u00b9\n\30\f\30\16"+
		"\30\u00bc\13\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u00cc\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u00d8\n\35\3\35\5\35\u00db\n\35\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\5\36\u00e7\n\36\3\36\5\36\u00ea\n\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00f7\n\37\3\37"+
		"\5\37\u00fa\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0105\n \3 \5 \u0108\n"+
		" \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0113\n\"\3#\3#\3#\3#\3$\3$\3$"+
		"\3%\3%\3%\3&\5&\u0120\n&\3&\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\5(\u0132\n(\5(\u0134\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0142"+
		"\n)\5)\u0144\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0152\n*\5*\u0154"+
		"\n*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u015e\n+\5+\u0160\n+\3,\3,\3,\3,\3,\3,"+
		"\3,\3,\3,\5,\u016b\n,\5,\u016d\n,\3-\3-\3-\3-\3-\3-\5-\u0175\n-\5-\u0177"+
		"\n-\3.\3.\3.\3.\5.\u017d\n.\3/\3/\3/\3/\3/\3/\3/\5/\u0186\n/\5/\u0188"+
		"\n/\3\60\3\60\3\60\3\60\3\60\5\60\u018f\n\60\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u01a1\n\61"+
		"\3\62\6\62\u01a4\n\62\r\62\16\62\u01a5\3\63\3\63\5\63\u01aa\n\63\3\63"+
		"\5\63\u01ad\n\63\3\63\6\63\u01b0\n\63\r\63\16\63\u01b1\3\63\3\63\6\63"+
		"\u01b6\n\63\r\63\16\63\u01b7\3\64\3\64\5\64\u01bc\n\64\3\65\3\65\6\65"+
		"\u01c0\n\65\r\65\16\65\u01c1\3\65\3\65\3\66\3\66\7\66\u01c8\n\66\f\66"+
		"\16\66\u01cb\13\66\3\67\3\67\6\67\u01cf\n\67\r\67\16\67\u01d0\2\28\3\3"+
		"\5\4\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2"+
		"#\2%\2\'\2)\2+\2-\2/\2\61\5\63\6\65\7\67\b9\t;\n=\13?\fA\rC\16E\17G\20"+
		"I\21K\22M\23O\24Q\25S\26U\27W\30Y\31[\32]\33_\34a\35c\2e\36g\37i k!m\""+
		"\3\2!\4\2\f\f//\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2"+
		"GGgg\4\2HHhh\4\2IIii\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4"+
		"\2QQqq\4\2RRrr\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\5\2**]]}}\5\2+"+
		"+__\177\177\4\2..==\13\2\13\f\17\17,,\61\61<<>>@A^^~~\4\2C\\c|\6\2//\62"+
		";C\\c|\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\u01ed\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G"+
		"\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2"+
		"\2a\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o"+
		"\3\2\2\2\5~\3\2\2\2\7\u0081\3\2\2\2\t\u0083\3\2\2\2\13\u0085\3\2\2\2\r"+
		"\u0087\3\2\2\2\17\u0089\3\2\2\2\21\u008b\3\2\2\2\23\u008d\3\2\2\2\25\u008f"+
		"\3\2\2\2\27\u0091\3\2\2\2\31\u0093\3\2\2\2\33\u0095\3\2\2\2\35\u0097\3"+
		"\2\2\2\37\u0099\3\2\2\2!\u009b\3\2\2\2#\u009d\3\2\2\2%\u009f\3\2\2\2\'"+
		"\u00a1\3\2\2\2)\u00a3\3\2\2\2+\u00a5\3\2\2\2-\u00a7\3\2\2\2/\u00b5\3\2"+
		"\2\2\61\u00bd\3\2\2\2\63\u00bf\3\2\2\2\65\u00c1\3\2\2\2\67\u00c3\3\2\2"+
		"\29\u00cd\3\2\2\2;\u00dc\3\2\2\2=\u00eb\3\2\2\2?\u00fb\3\2\2\2A\u0109"+
		"\3\2\2\2C\u010c\3\2\2\2E\u0114\3\2\2\2G\u0118\3\2\2\2I\u011b\3\2\2\2K"+
		"\u011f\3\2\2\2M\u0124\3\2\2\2O\u0126\3\2\2\2Q\u0135\3\2\2\2S\u0153\3\2"+
		"\2\2U\u0155\3\2\2\2W\u016c\3\2\2\2Y\u016e\3\2\2\2[\u0178\3\2\2\2]\u017e"+
		"\3\2\2\2_\u0189\3\2\2\2a\u01a0\3\2\2\2c\u01a3\3\2\2\2e\u01a9\3\2\2\2g"+
		"\u01bb\3\2\2\2i\u01bd\3\2\2\2k\u01c5\3\2\2\2m\u01cc\3\2\2\2op\7/\2\2p"+
		"t\7/\2\2qs\n\2\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uz\3\2\2\2v"+
		"t\3\2\2\2wx\7/\2\2x{\7/\2\2y{\7\f\2\2zw\3\2\2\2zy\3\2\2\2{|\3\2\2\2|}"+
		"\b\2\2\2}\4\3\2\2\2~\177\t\3\2\2\177\u0080\b\3\3\2\u0080\6\3\2\2\2\u0081"+
		"\u0082\t\4\2\2\u0082\b\3\2\2\2\u0083\u0084\t\5\2\2\u0084\n\3\2\2\2\u0085"+
		"\u0086\t\6\2\2\u0086\f\3\2\2\2\u0087\u0088\t\7\2\2\u0088\16\3\2\2\2\u0089"+
		"\u008a\t\b\2\2\u008a\20\3\2\2\2\u008b\u008c\t\t\2\2\u008c\22\3\2\2\2\u008d"+
		"\u008e\t\n\2\2\u008e\24\3\2\2\2\u008f\u0090\t\13\2\2\u0090\26\3\2\2\2"+
		"\u0091\u0092\t\f\2\2\u0092\30\3\2\2\2\u0093\u0094\t\r\2\2\u0094\32\3\2"+
		"\2\2\u0095\u0096\t\16\2\2\u0096\34\3\2\2\2\u0097\u0098\t\17\2\2\u0098"+
		"\36\3\2\2\2\u0099\u009a\t\20\2\2\u009a \3\2\2\2\u009b\u009c\t\21\2\2\u009c"+
		"\"\3\2\2\2\u009d\u009e\t\22\2\2\u009e$\3\2\2\2\u009f\u00a0\t\23\2\2\u00a0"+
		"&\3\2\2\2\u00a1\u00a2\t\24\2\2\u00a2(\3\2\2\2\u00a3\u00a4\t\25\2\2\u00a4"+
		"*\3\2\2\2\u00a5\u00a6\t\26\2\2\u00a6,\3\2\2\2\u00a7\u00a8\t\27\2\2\u00a8"+
		".\3\2\2\2\u00a9\u00aa\7\62\2\2\u00aa\u00b6\7\60\2\2\u00ab\u00af\4\63;"+
		"\2\u00ac\u00ae\4\62;\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00b4\7\60\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3"+
		"\2\2\2\u00b5\u00a9\3\2\2\2\u00b5\u00ab\3\2\2\2\u00b6\u00ba\3\2\2\2\u00b7"+
		"\u00b9\4\62;\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\60\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be"+
		"\t\30\2\2\u00be\62\3\2\2\2\u00bf\u00c0\t\31\2\2\u00c0\64\3\2\2\2\u00c1"+
		"\u00c2\t\32\2\2\u00c2\66\3\2\2\2\u00c3\u00c4\5\13\6\2\u00c4\u00c5\5\25"+
		"\13\2\u00c5\u00c6\5%\23\2\u00c6\u00c7\5\13\6\2\u00c7\u00c8\5+\26\2\u00c8"+
		"\u00c9\5\25\13\2\u00c9\u00cb\5)\25\2\u00ca\u00cc\7<\2\2\u00cb\u00ca\3"+
		"\2\2\2\u00cb\u00cc\3\2\2\2\u00cc8\3\2\2\2\u00cd\u00ce\5\33\16\2\u00ce"+
		"\u00cf\5\25\13\2\u00cf\u00d7\5\t\5\2\u00d0\u00d1\5%\23\2\u00d1\u00d2\5"+
		"\7\4\2\u00d2\u00d3\5%\23\2\u00d3\u00d4\5\25\13\2\u00d4\u00d5\5\17\b\2"+
		"\u00d5\u00d6\5\'\24\2\u00d6\u00d8\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00db\7<\2\2\u00da\u00d9\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db:\3\2\2\2\u00dc\u00dd\5\13\6\2\u00dd\u00de\5!\21\2"+
		"\u00de\u00df\5\37\20\2\u00df\u00e0\5\'\24\2\u00e0\u00e6\5)\25\2\u00e1"+
		"\u00e2\5\7\4\2\u00e2\u00e3\5\37\20\2\u00e3\u00e4\5)\25\2\u00e4\u00e5\5"+
		"\'\24\2\u00e5\u00e7\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e9\3\2\2\2\u00e8\u00ea\7<\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea<\3\2\2\2\u00eb\u00ec\5\13\6\2\u00ec\u00ed\5!\21\2\u00ed\u00ee"+
		"\5\35\17\2\u00ee\u00f6\5#\22\2\u00ef\u00f0\5!\21\2\u00f0\u00f1\5\37\20"+
		"\2\u00f1\u00f2\5\17\b\2\u00f2\u00f3\5\37\20\2\u00f3\u00f4\5)\25\2\u00f4"+
		"\u00f5\5\'\24\2\u00f5\u00f7\3\2\2\2\u00f6\u00ef\3\2\2\2\u00f6\u00f7\3"+
		"\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00fa\7<\2\2\u00f9\u00f8\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa>\3\2\2\2\u00fb\u00fc\5\'\24\2\u00fc\u00fd\5\25\13"+
		"\2\u00fd\u0104\5\35\17\2\u00fe\u00ff\5+\26\2\u00ff\u0100\5\33\16\2\u0100"+
		"\u0101\5\7\4\2\u0101\u0102\5)\25\2\u0102\u0103\5\17\b\2\u0103\u0105\3"+
		"\2\2\2\u0104\u00fe\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106"+
		"\u0108\7<\2\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2\2\u0108@\3\2\2\2\u0109"+
		"\u010a\5\7\4\2\u010a\u010b\5)\25\2\u010bB\3\2\2\2\u010c\u010d\5\35\17"+
		"\2\u010d\u010e\5!\21\2\u010e\u0112\5\r\7\2\u010f\u0110\5\17\b\2\u0110"+
		"\u0111\5\33\16\2\u0111\u0113\3\2\2\2\u0112\u010f\3\2\2\2\u0112\u0113\3"+
		"\2\2\2\u0113D\3\2\2\2\u0114\u0115\5\23\n\2\u0115\u0116\5\37\20\2\u0116"+
		"\u0117\5\r\7\2\u0117F\3\2\2\2\u0118\u0119\5\r\7\2\u0119\u011a\5\13\6\2"+
		"\u011aH\3\2\2\2\u011b\u011c\5\7\4\2\u011c\u011d\5\13\6\2\u011dJ\3\2\2"+
		"\2\u011e\u0120\5/\30\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u0122\5#\22\2\u0122\u0123\5\25\13\2\u0123L\3\2\2\2\u0124"+
		"\u0125\7?\2\2\u0125N\3\2\2\2\u0126\u0133\5%\23\2\u0127\u0128\5\17\b\2"+
		"\u0128\u0131\5\'\24\2\u0129\u012a\5\25\13\2\u012a\u012b\5\'\24\2\u012b"+
		"\u012c\5)\25\2\u012c\u012d\5\7\4\2\u012d\u012e\5\37\20\2\u012e\u012f\5"+
		"\13\6\2\u012f\u0130\5\17\b\2\u0130\u0132\3\2\2\2\u0131\u0129\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0127\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134P\3\2\2\2\u0135\u0143\5\13\6\2\u0136\u0137\5\7\4\2\u0137\u0141"+
		"\5#\22\2\u0138\u0139\5\7\4\2\u0139\u013a\5\13\6\2\u013a\u013b\5\25\13"+
		"\2\u013b\u013c\5)\25\2\u013c\u013d\5\7\4\2\u013d\u013e\5\37\20\2\u013e"+
		"\u013f\5\13\6\2\u013f\u0140\5\17\b\2\u0140\u0142\3\2\2\2\u0141\u0138\3"+
		"\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144\3\2\2\2\u0143\u0136\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144R\3\2\2\2\u0145\u0154\5\33\16\2\u0146\u0147\5\25\13"+
		"\2\u0147\u0148\5\37\20\2\u0148\u0151\5\r\7\2\u0149\u014a\5+\26\2\u014a"+
		"\u014b\5\13\6\2\u014b\u014c\5)\25\2\u014c\u014d\5\7\4\2\u014d\u014e\5"+
		"\37\20\2\u014e\u014f\5\13\6\2\u014f\u0150\5\17\b\2\u0150\u0152\3\2\2\2"+
		"\u0151\u0149\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0145"+
		"\3\2\2\2\u0153\u0146\3\2\2\2\u0154T\3\2\2\2\u0155\u015f\5-\27\2\u0156"+
		"\u0157\5!\21\2\u0157\u015d\5\33\16\2\u0158\u0159\5)\25\2\u0159\u015a\5"+
		"\7\4\2\u015a\u015b\5\23\n\2\u015b\u015c\5\17\b\2\u015c\u015e\3\2\2\2\u015d"+
		"\u0158\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0156\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160V\3\2\2\2\u0161\u016d\5\25\13\2\u0162\u0163"+
		"\5\13\6\2\u0163\u0164\5+\26\2\u0164\u016a\5%\23\2\u0165\u0166\5%\23\2"+
		"\u0166\u0167\5\17\b\2\u0167\u0168\5\37\20\2\u0168\u0169\5)\25\2\u0169"+
		"\u016b\3\2\2\2\u016a\u0165\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2"+
		"\2\2\u016c\u0161\3\2\2\2\u016c\u0162\3\2\2\2\u016dX\3\2\2\2\u016e\u0176"+
		"\5\r\7\2\u016f\u0170\5\25\13\2\u0170\u0174\5!\21\2\u0171\u0172\5\r\7\2"+
		"\u0172\u0173\5\17\b\2\u0173\u0175\3\2\2\2\u0174\u0171\3\2\2\2\u0174\u0175"+
		"\3\2\2\2\u0175\u0177\3\2\2\2\u0176\u016f\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"Z\3\2\2\2\u0178\u017c\5\t\5\2\u0179\u017a\5\27\f\2\u017a\u017b\5)\25\2"+
		"\u017b\u017d\3\2\2\2\u017c\u0179\3\2\2\2\u017c\u017d\3\2\2\2\u017d\\\3"+
		"\2\2\2\u017e\u0187\5\35\17\2\u017f\u0180\5!\21\2\u0180\u0185\5\'\24\2"+
		"\u0181\u0182\5\21\t\2\u0182\u0183\5\17\b\2\u0183\u0184\5)\25\2\u0184\u0186"+
		"\3\2\2\2\u0185\u0181\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187"+
		"\u017f\3\2\2\2\u0187\u0188\3\2\2\2\u0188^\3\2\2\2\u0189\u018e\5\27\f\2"+
		"\u018a\u018b\5\21\t\2\u018b\u018c\5\17\b\2\u018c\u018d\5)\25\2\u018d\u018f"+
		"\3\2\2\2\u018e\u018a\3\2\2\2\u018e\u018f\3\2\2\2\u018f`\3\2\2\2\u0190"+
		"\u01a1\5\21\t\2\u0191\u01a1\5#\22\2\u0192\u01a1\5\37\20\2\u0193\u01a1"+
		"\5+\26\2\u0194\u0195\5\35\17\2\u0195\u0196\5\25\13\2\u0196\u0197\5\33"+
		"\16\2\u0197\u0198\5\33\16\2\u0198\u01a1\3\2\2\2\u0199\u01a1\5\31\r\2\u019a"+
		"\u019b\5\35\17\2\u019b\u019c\5\17\b\2\u019c\u019d\5\23\n\2\u019d\u01a1"+
		"\3\2\2\2\u019e\u01a1\5\23\n\2\u019f\u01a1\5)\25\2\u01a0\u0190\3\2\2\2"+
		"\u01a0\u0191\3\2\2\2\u01a0\u0192\3\2\2\2\u01a0\u0193\3\2\2\2\u01a0\u0194"+
		"\3\2\2\2\u01a0\u0199\3\2\2\2\u01a0\u019a\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0"+
		"\u019f\3\2\2\2\u01a1b\3\2\2\2\u01a2\u01a4\n\33\2\2\u01a3\u01a2\3\2\2\2"+
		"\u01a4\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6d\3"+
		"\2\2\2\u01a7\u01a8\4C\\\2\u01a8\u01aa\7<\2\2\u01a9\u01a7\3\2\2\2\u01a9"+
		"\u01aa\3\2\2\2\u01aa\u01af\3\2\2\2\u01ab\u01ad\7^\2\2\u01ac\u01ab\3\2"+
		"\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\5c\62\2\u01af"+
		"\u01ac\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2"+
		"\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\7\60\2\2\u01b4\u01b6\t\34\2\2\u01b5"+
		"\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2"+
		"\2\2\u01b8f\3\2\2\2\u01b9\u01bc\5/\30\2\u01ba\u01bc\7\62\2\2\u01bb\u01b9"+
		"\3\2\2\2\u01bb\u01ba\3\2\2\2\u01bch\3\2\2\2\u01bd\u01bf\7>\2\2\u01be\u01c0"+
		"\t\35\2\2\u01bf\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01bf\3\2\2\2"+
		"\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\7@\2\2\u01c4j\3\2"+
		"\2\2\u01c5\u01c9\t\36\2\2\u01c6\u01c8\t\37\2\2\u01c7\u01c6\3\2\2\2\u01c8"+
		"\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01cal\3\2\2\2"+
		"\u01cb\u01c9\3\2\2\2\u01cc\u01ce\7\60\2\2\u01cd\u01cf\n \2\2\u01ce\u01cd"+
		"\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"n\3\2\2\2.\2tz\u00af\u00b3\u00b5\u00ba\u00cb\u00d7\u00da\u00e6\u00e9\u00f6"+
		"\u00f9\u0104\u0107\u0112\u011f\u0131\u0133\u0141\u0143\u0151\u0153\u015d"+
		"\u015f\u016a\u016c\u0174\u0176\u017c\u0185\u0187\u018e\u01a0\u01a5\u01a9"+
		"\u01ac\u01b1\u01b7\u01bb\u01c1\u01c9\u01d0\4\3\2\2\3\3\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}