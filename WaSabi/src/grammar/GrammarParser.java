// Generated from Grammar.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "COMMENT", "WS", "OPENBRACKET", "CLOSEBRACKET", "SEPARATOR", 
		"CIRCUIT", "LIBRARY", "CONST", "COMPONENT", "SIMULATE", "AT", "MODEL", 
		"GND", "DC", "AC", "PI", "'='", "RES", "CAP", "IND", "VOL", "CUR", "DIO", 
		"BJT", "MOS", "JFET", "UNIT", "PATH", "VALUE", "MODTYPE", "ID", "DIRECTIVE"
	};
	public static final int
		RULE_axiom = 0, RULE_pr = 1, RULE_title = 2, RULE_library = 3, RULE_listlib = 4, 
		RULE_newlib = 5, RULE_constants = 6, RULE_listconst = 7, RULE_newconst = 8, 
		RULE_newconst2 = 9, RULE_newvalue = 10, RULE_units = 11, RULE_newwave = 12, 
		RULE_newwaveDC = 13, RULE_newwaveAC = 14, RULE_newmod = 15, RULE_components = 16, 
		RULE_listcomp = 17, RULE_newcomp = 18, RULE_resistance = 19, RULE_capacitance = 20, 
		RULE_inductance = 21, RULE_voltage = 22, RULE_current = 23, RULE_diode = 24, 
		RULE_bjt = 25, RULE_mosfet = 26, RULE_jfet = 27, RULE_model = 28, RULE_node = 29, 
		RULE_valueID = 30, RULE_waveID = 31, RULE_modtypeID = 32, RULE_listnodes = 33, 
		RULE_listnodes2 = 34, RULE_sim = 35, RULE_dirsim = 36, RULE_newdir = 37;
	public static final String[] ruleNames = {
		"axiom", "pr", "title", "library", "listlib", "newlib", "constants", "listconst", 
		"newconst", "newconst2", "newvalue", "units", "newwave", "newwaveDC", 
		"newwaveAC", "newmod", "components", "listcomp", "newcomp", "resistance", 
		"capacitance", "inductance", "voltage", "current", "diode", "bjt", "mosfet", 
		"jfet", "model", "node", "valueID", "waveID", "modtypeID", "listnodes", 
		"listnodes2", "sim", "dirsim", "newdir"
	};

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AxiomContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public PrContext pr() {
			return getRuleContext(PrContext.class,0);
		}
		public AxiomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axiom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAxiom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAxiom(this);
		}
	}

	public final AxiomContext axiom() throws RecognitionException {
		AxiomContext _localctx = new AxiomContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_axiom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if (_la==CIRCUIT) {
				{
				setState(76); title();
				}
			}

			setState(79); pr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrContext extends ParserRuleContext {
		public ComponentsContext components() {
			return getRuleContext(ComponentsContext.class,0);
		}
		public SimContext sim() {
			return getRuleContext(SimContext.class,0);
		}
		public PrContext pr() {
			return getRuleContext(PrContext.class,0);
		}
		public ConstantsContext constants() {
			return getRuleContext(ConstantsContext.class,0);
		}
		public LibraryContext library() {
			return getRuleContext(LibraryContext.class,0);
		}
		public PrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPr(this);
		}
	}

	public final PrContext pr() throws RecognitionException {
		PrContext _localctx = new PrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LIBRARY) | (1L << CONST) | (1L << COMPONENT) | (1L << SIMULATE))) != 0)) {
				{
				setState(85);
				switch (_input.LA(1)) {
				case LIBRARY:
					{
					setState(81); library();
					}
					break;
				case CONST:
					{
					setState(82); constants();
					}
					break;
				case COMPONENT:
					{
					setState(83); components();
					}
					break;
				case SIMULATE:
					{
					setState(84); sim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(87); pr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode CIRCUIT() { return getToken(GrammarParser.CIRCUIT, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); match(CIRCUIT);
			setState(92); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LibraryContext extends ParserRuleContext {
		public TerminalNode LIBRARY() { return getToken(GrammarParser.LIBRARY, 0); }
		public ListlibContext listlib() {
			return getRuleContext(ListlibContext.class,0);
		}
		public LibraryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_library; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLibrary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLibrary(this);
		}
	}

	public final LibraryContext library() throws RecognitionException {
		LibraryContext _localctx = new LibraryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_library);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(LIBRARY);
			setState(95); listlib();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListlibContext extends ParserRuleContext {
		public NewlibContext newlib() {
			return getRuleContext(NewlibContext.class,0);
		}
		public ListlibContext listlib() {
			return getRuleContext(ListlibContext.class,0);
		}
		public ListlibContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listlib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterListlib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitListlib(this);
		}
	}

	public final ListlibContext listlib() throws RecognitionException {
		ListlibContext _localctx = new ListlibContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listlib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if (_la==PATH) {
				{
				setState(97); newlib();
				setState(98); listlib();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewlibContext extends ParserRuleContext {
		public TerminalNode PATH() { return getToken(GrammarParser.PATH, 0); }
		public NewlibContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newlib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewlib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewlib(this);
		}
	}

	public final NewlibContext newlib() throws RecognitionException {
		NewlibContext _localctx = new NewlibContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_newlib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(PATH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantsContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GrammarParser.CONST, 0); }
		public ListconstContext listconst() {
			return getRuleContext(ListconstContext.class,0);
		}
		public ConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitConstants(this);
		}
	}

	public final ConstantsContext constants() throws RecognitionException {
		ConstantsContext _localctx = new ConstantsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constants);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(CONST);
			setState(105); listconst();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListconstContext extends ParserRuleContext {
		public NewconstContext newconst() {
			return getRuleContext(NewconstContext.class,0);
		}
		public ListconstContext listconst() {
			return getRuleContext(ListconstContext.class,0);
		}
		public ListconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterListconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitListconst(this);
		}
	}

	public final ListconstContext listconst() throws RecognitionException {
		ListconstContext _localctx = new ListconstContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listconst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(107); newconst();
				setState(108); listconst();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewconstContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(GrammarParser.EQUAL, 0); }
		public Newconst2Context newconst2() {
			return getRuleContext(Newconst2Context.class,0);
		}
		public NewconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewconst(this);
		}
	}

	public final NewconstContext newconst() throws RecognitionException {
		NewconstContext _localctx = new NewconstContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_newconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(ID);
			setState(113); match(EQUAL);
			setState(114); newconst2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Newconst2Context extends ParserRuleContext {
		public NewvalueContext newvalue() {
			return getRuleContext(NewvalueContext.class,0);
		}
		public NewwaveContext newwave() {
			return getRuleContext(NewwaveContext.class,0);
		}
		public NewmodContext newmod() {
			return getRuleContext(NewmodContext.class,0);
		}
		public Newconst2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newconst2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewconst2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewconst2(this);
		}
	}

	public final Newconst2Context newconst2() throws RecognitionException {
		Newconst2Context _localctx = new Newconst2Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_newconst2);
		try {
			setState(119);
			switch (_input.LA(1)) {
			case PI:
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); newvalue();
				}
				break;
			case DC:
			case AC:
				enterOuterAlt(_localctx, 2);
				{
				setState(117); newwave();
				}
				break;
			case MODTYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(118); newmod();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewvalueContext extends ParserRuleContext {
		public TerminalNode PI() { return getToken(GrammarParser.PI, 0); }
		public UnitsContext units() {
			return getRuleContext(UnitsContext.class,0);
		}
		public TerminalNode VALUE() { return getToken(GrammarParser.VALUE, 0); }
		public NewvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewvalue(this);
		}
	}

	public final NewvalueContext newvalue() throws RecognitionException {
		NewvalueContext _localctx = new NewvalueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_newvalue);
		try {
			setState(124);
			switch (_input.LA(1)) {
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(121); match(VALUE);
				setState(122); units();
				}
				break;
			case PI:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); match(PI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitsContext extends ParserRuleContext {
		public TerminalNode UNIT() { return getToken(GrammarParser.UNIT, 0); }
		public UnitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_units; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterUnits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitUnits(this);
		}
	}

	public final UnitsContext units() throws RecognitionException {
		UnitsContext _localctx = new UnitsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_units);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if (_la==UNIT) {
				{
				setState(126); match(UNIT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewwaveContext extends ParserRuleContext {
		public NewwaveDCContext newwaveDC() {
			return getRuleContext(NewwaveDCContext.class,0);
		}
		public NewwaveACContext newwaveAC() {
			return getRuleContext(NewwaveACContext.class,0);
		}
		public NewwaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newwave; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewwave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewwave(this);
		}
	}

	public final NewwaveContext newwave() throws RecognitionException {
		NewwaveContext _localctx = new NewwaveContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_newwave);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case DC:
				enterOuterAlt(_localctx, 1);
				{
				setState(129); newwaveDC();
				}
				break;
			case AC:
				enterOuterAlt(_localctx, 2);
				{
				setState(130); newwaveAC();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewwaveDCContext extends ParserRuleContext {
		public ValueIDContext valueID() {
			return getRuleContext(ValueIDContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public TerminalNode DC() { return getToken(GrammarParser.DC, 0); }
		public NewwaveDCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newwaveDC; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewwaveDC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewwaveDC(this);
		}
	}

	public final NewwaveDCContext newwaveDC() throws RecognitionException {
		NewwaveDCContext _localctx = new NewwaveDCContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_newwaveDC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(DC);
			setState(134); match(OPENBRACKET);
			setState(135); valueID();
			setState(136); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewwaveACContext extends ParserRuleContext {
		public List<ValueIDContext> valueID() {
			return getRuleContexts(ValueIDContext.class);
		}
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public TerminalNode AC() { return getToken(GrammarParser.AC, 0); }
		public ValueIDContext valueID(int i) {
			return getRuleContext(ValueIDContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public NewwaveACContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newwaveAC; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewwaveAC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewwaveAC(this);
		}
	}

	public final NewwaveACContext newwaveAC() throws RecognitionException {
		NewwaveACContext _localctx = new NewwaveACContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_newwaveAC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(AC);
			setState(139); match(OPENBRACKET);
			setState(140); valueID();
			setState(141); match(SEPARATOR);
			setState(142); valueID();
			setState(143); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewmodContext extends ParserRuleContext {
		public TerminalNode MODTYPE() { return getToken(GrammarParser.MODTYPE, 0); }
		public NewmodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newmod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewmod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewmod(this);
		}
	}

	public final NewmodContext newmod() throws RecognitionException {
		NewmodContext _localctx = new NewmodContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_newmod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(MODTYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentsContext extends ParserRuleContext {
		public ListcompContext listcomp() {
			return getRuleContext(ListcompContext.class,0);
		}
		public TerminalNode COMPONENT() { return getToken(GrammarParser.COMPONENT, 0); }
		public ComponentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_components; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterComponents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitComponents(this);
		}
	}

	public final ComponentsContext components() throws RecognitionException {
		ComponentsContext _localctx = new ComponentsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_components);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(COMPONENT);
			setState(148); listcomp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListcompContext extends ParserRuleContext {
		public ListcompContext listcomp() {
			return getRuleContext(ListcompContext.class,0);
		}
		public NewcompContext newcomp() {
			return getRuleContext(NewcompContext.class,0);
		}
		public ListcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterListcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitListcomp(this);
		}
	}

	public final ListcompContext listcomp() throws RecognitionException {
		ListcompContext _localctx = new ListcompContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listcomp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODEL) | (1L << RES) | (1L << CAP) | (1L << IND) | (1L << VOL) | (1L << CUR) | (1L << DIO) | (1L << BJT) | (1L << MOS) | (1L << JFET))) != 0)) {
				{
				setState(150); newcomp();
				setState(151); listcomp();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewcompContext extends ParserRuleContext {
		public InductanceContext inductance() {
			return getRuleContext(InductanceContext.class,0);
		}
		public ResistanceContext resistance() {
			return getRuleContext(ResistanceContext.class,0);
		}
		public VoltageContext voltage() {
			return getRuleContext(VoltageContext.class,0);
		}
		public CapacitanceContext capacitance() {
			return getRuleContext(CapacitanceContext.class,0);
		}
		public JfetContext jfet() {
			return getRuleContext(JfetContext.class,0);
		}
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public CurrentContext current() {
			return getRuleContext(CurrentContext.class,0);
		}
		public BjtContext bjt() {
			return getRuleContext(BjtContext.class,0);
		}
		public MosfetContext mosfet() {
			return getRuleContext(MosfetContext.class,0);
		}
		public DiodeContext diode() {
			return getRuleContext(DiodeContext.class,0);
		}
		public NewcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewcomp(this);
		}
	}

	public final NewcompContext newcomp() throws RecognitionException {
		NewcompContext _localctx = new NewcompContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_newcomp);
		try {
			setState(165);
			switch (_input.LA(1)) {
			case RES:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); resistance();
				}
				break;
			case CAP:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); capacitance();
				}
				break;
			case IND:
				enterOuterAlt(_localctx, 3);
				{
				setState(157); inductance();
				}
				break;
			case VOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(158); voltage();
				}
				break;
			case CUR:
				enterOuterAlt(_localctx, 5);
				{
				setState(159); current();
				}
				break;
			case DIO:
				enterOuterAlt(_localctx, 6);
				{
				setState(160); diode();
				}
				break;
			case BJT:
				enterOuterAlt(_localctx, 7);
				{
				setState(161); bjt();
				}
				break;
			case MOS:
				enterOuterAlt(_localctx, 8);
				{
				setState(162); mosfet();
				}
				break;
			case JFET:
				enterOuterAlt(_localctx, 9);
				{
				setState(163); jfet();
				}
				break;
			case MODEL:
				enterOuterAlt(_localctx, 10);
				{
				setState(164); model();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResistanceContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public ValueIDContext valueID() {
			return getRuleContext(ValueIDContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public TerminalNode RES() { return getToken(GrammarParser.RES, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public ResistanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resistance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterResistance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitResistance(this);
		}
	}

	public final ResistanceContext resistance() throws RecognitionException {
		ResistanceContext _localctx = new ResistanceContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_resistance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(RES);
			setState(168); valueID();
			setState(169); match(AT);
			setState(170); match(OPENBRACKET);
			setState(171); node();
			setState(172); match(SEPARATOR);
			setState(173); node();
			setState(174); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CapacitanceContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public ValueIDContext valueID() {
			return getRuleContext(ValueIDContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public TerminalNode CAP() { return getToken(GrammarParser.CAP, 0); }
		public CapacitanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capacitance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCapacitance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCapacitance(this);
		}
	}

	public final CapacitanceContext capacitance() throws RecognitionException {
		CapacitanceContext _localctx = new CapacitanceContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_capacitance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(CAP);
			setState(177); valueID();
			setState(178); match(AT);
			setState(179); match(OPENBRACKET);
			setState(180); node();
			setState(181); match(SEPARATOR);
			setState(182); node();
			setState(183); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InductanceContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public ValueIDContext valueID() {
			return getRuleContext(ValueIDContext.class,0);
		}
		public TerminalNode IND() { return getToken(GrammarParser.IND, 0); }
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public InductanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inductance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInductance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInductance(this);
		}
	}

	public final InductanceContext inductance() throws RecognitionException {
		InductanceContext _localctx = new InductanceContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_inductance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(IND);
			setState(186); valueID();
			setState(187); match(AT);
			setState(188); match(OPENBRACKET);
			setState(189); node();
			setState(190); match(SEPARATOR);
			setState(191); node();
			setState(192); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoltageContext extends ParserRuleContext {
		public TerminalNode VOL() { return getToken(GrammarParser.VOL, 0); }
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public WaveIDContext waveID() {
			return getRuleContext(WaveIDContext.class,0);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public VoltageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voltage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVoltage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVoltage(this);
		}
	}

	public final VoltageContext voltage() throws RecognitionException {
		VoltageContext _localctx = new VoltageContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_voltage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(VOL);
			setState(195); waveID();
			setState(196); match(AT);
			setState(197); match(OPENBRACKET);
			setState(198); node();
			setState(199); match(SEPARATOR);
			setState(200); node();
			setState(201); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CurrentContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public WaveIDContext waveID() {
			return getRuleContext(WaveIDContext.class,0);
		}
		public TerminalNode CUR() { return getToken(GrammarParser.CUR, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public CurrentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_current; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCurrent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCurrent(this);
		}
	}

	public final CurrentContext current() throws RecognitionException {
		CurrentContext _localctx = new CurrentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_current);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(CUR);
			setState(204); waveID();
			setState(205); match(AT);
			setState(206); match(OPENBRACKET);
			setState(207); node();
			setState(208); match(SEPARATOR);
			setState(209); node();
			setState(210); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DiodeContext extends ParserRuleContext {
		public ModtypeIDContext modtypeID() {
			return getRuleContext(ModtypeIDContext.class,0);
		}
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public TerminalNode DIO() { return getToken(GrammarParser.DIO, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public DiodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDiode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDiode(this);
		}
	}

	public final DiodeContext diode() throws RecognitionException {
		DiodeContext _localctx = new DiodeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_diode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); match(DIO);
			setState(213); modtypeID();
			setState(214); match(AT);
			setState(215); match(OPENBRACKET);
			setState(216); node();
			setState(217); match(SEPARATOR);
			setState(218); node();
			setState(219); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BjtContext extends ParserRuleContext {
		public ModtypeIDContext modtypeID() {
			return getRuleContext(ModtypeIDContext.class,0);
		}
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(GrammarParser.SEPARATOR, i);
		}
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public List<TerminalNode> SEPARATOR() { return getTokens(GrammarParser.SEPARATOR); }
		public TerminalNode BJT() { return getToken(GrammarParser.BJT, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public BjtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bjt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBjt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBjt(this);
		}
	}

	public final BjtContext bjt() throws RecognitionException {
		BjtContext _localctx = new BjtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_bjt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); match(BJT);
			setState(222); modtypeID();
			setState(223); match(AT);
			setState(224); match(OPENBRACKET);
			setState(225); node();
			setState(226); match(SEPARATOR);
			setState(227); node();
			setState(228); match(SEPARATOR);
			setState(229); node();
			setState(230); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MosfetContext extends ParserRuleContext {
		public ModtypeIDContext modtypeID() {
			return getRuleContext(ModtypeIDContext.class,0);
		}
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(GrammarParser.SEPARATOR, i);
		}
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public List<TerminalNode> SEPARATOR() { return getTokens(GrammarParser.SEPARATOR); }
		public TerminalNode MOS() { return getToken(GrammarParser.MOS, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public MosfetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mosfet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMosfet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMosfet(this);
		}
	}

	public final MosfetContext mosfet() throws RecognitionException {
		MosfetContext _localctx = new MosfetContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mosfet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(MOS);
			setState(233); modtypeID();
			setState(234); match(AT);
			setState(235); match(OPENBRACKET);
			setState(236); node();
			setState(237); match(SEPARATOR);
			setState(238); node();
			setState(239); match(SEPARATOR);
			setState(240); node();
			setState(241); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JfetContext extends ParserRuleContext {
		public ModtypeIDContext modtypeID() {
			return getRuleContext(ModtypeIDContext.class,0);
		}
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(GrammarParser.SEPARATOR, i);
		}
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public List<TerminalNode> SEPARATOR() { return getTokens(GrammarParser.SEPARATOR); }
		public TerminalNode JFET() { return getToken(GrammarParser.JFET, 0); }
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public JfetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jfet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterJfet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitJfet(this);
		}
	}

	public final JfetContext jfet() throws RecognitionException {
		JfetContext _localctx = new JfetContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_jfet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(JFET);
			setState(244); modtypeID();
			setState(245); match(AT);
			setState(246); match(OPENBRACKET);
			setState(247); node();
			setState(248); match(SEPARATOR);
			setState(249); node();
			setState(250); match(SEPARATOR);
			setState(251); node();
			setState(252); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelContext extends ParserRuleContext {
		public ModtypeIDContext modtypeID() {
			return getRuleContext(ModtypeIDContext.class,0);
		}
		public TerminalNode AT() { return getToken(GrammarParser.AT, 0); }
		public TerminalNode OPENBRACKET() { return getToken(GrammarParser.OPENBRACKET, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(GrammarParser.CLOSEBRACKET, 0); }
		public TerminalNode MODEL() { return getToken(GrammarParser.MODEL, 0); }
		public ListnodesContext listnodes() {
			return getRuleContext(ListnodesContext.class,0);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitModel(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_model);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(MODEL);
			setState(255); modtypeID();
			setState(256); match(AT);
			setState(257); match(OPENBRACKET);
			setState(258); listnodes();
			setState(259); match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeContext extends ParserRuleContext {
		public TerminalNode GND() { return getToken(GrammarParser.GND, 0); }
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNode(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_node);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==GND || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueIDContext extends ParserRuleContext {
		public NewvalueContext newvalue() {
			return getRuleContext(NewvalueContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public ValueIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterValueID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitValueID(this);
		}
	}

	public final ValueIDContext valueID() throws RecognitionException {
		ValueIDContext _localctx = new ValueIDContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_valueID);
		try {
			setState(265);
			switch (_input.LA(1)) {
			case PI:
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(263); newvalue();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(264); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WaveIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public NewwaveContext newwave() {
			return getRuleContext(NewwaveContext.class,0);
		}
		public WaveIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waveID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWaveID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWaveID(this);
		}
	}

	public final WaveIDContext waveID() throws RecognitionException {
		WaveIDContext _localctx = new WaveIDContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_waveID);
		try {
			setState(269);
			switch (_input.LA(1)) {
			case DC:
			case AC:
				enterOuterAlt(_localctx, 1);
				{
				setState(267); newwave();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(268); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModtypeIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public NewmodContext newmod() {
			return getRuleContext(NewmodContext.class,0);
		}
		public ModtypeIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modtypeID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterModtypeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitModtypeID(this);
		}
	}

	public final ModtypeIDContext modtypeID() throws RecognitionException {
		ModtypeIDContext _localctx = new ModtypeIDContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_modtypeID);
		try {
			setState(273);
			switch (_input.LA(1)) {
			case MODTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(271); newmod();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(272); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListnodesContext extends ParserRuleContext {
		public Listnodes2Context listnodes2() {
			return getRuleContext(Listnodes2Context.class,0);
		}
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public ListnodesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listnodes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterListnodes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitListnodes(this);
		}
	}

	public final ListnodesContext listnodes() throws RecognitionException {
		ListnodesContext _localctx = new ListnodesContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_listnodes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); node();
			setState(276); listnodes2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Listnodes2Context extends ParserRuleContext {
		public Listnodes2Context listnodes2() {
			return getRuleContext(Listnodes2Context.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(GrammarParser.SEPARATOR, 0); }
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public Listnodes2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listnodes2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterListnodes2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitListnodes2(this);
		}
	}

	public final Listnodes2Context listnodes2() throws RecognitionException {
		Listnodes2Context _localctx = new Listnodes2Context(_ctx, getState());
		enterRule(_localctx, 68, RULE_listnodes2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if (_la==SEPARATOR) {
				{
				setState(278); match(SEPARATOR);
				setState(279); node();
				setState(280); listnodes2();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimContext extends ParserRuleContext {
		public DirsimContext dirsim() {
			return getRuleContext(DirsimContext.class,0);
		}
		public TerminalNode SIMULATE() { return getToken(GrammarParser.SIMULATE, 0); }
		public SimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSim(this);
		}
	}

	public final SimContext sim() throws RecognitionException {
		SimContext _localctx = new SimContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_sim);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(SIMULATE);
			setState(285); dirsim();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirsimContext extends ParserRuleContext {
		public NewdirContext newdir() {
			return getRuleContext(NewdirContext.class,0);
		}
		public DirsimContext dirsim() {
			return getRuleContext(DirsimContext.class,0);
		}
		public DirsimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dirsim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDirsim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDirsim(this);
		}
	}

	public final DirsimContext dirsim() throws RecognitionException {
		DirsimContext _localctx = new DirsimContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_dirsim);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			_la = _input.LA(1);
			if (_la==DIRECTIVE) {
				{
				setState(287); newdir();
				setState(288); dirsim();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewdirContext extends ParserRuleContext {
		public TerminalNode DIRECTIVE() { return getToken(GrammarParser.DIRECTIVE, 0); }
		public NewdirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newdir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewdir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewdir(this);
		}
	}

	public final NewdirContext newdir() throws RecognitionException {
		NewdirContext _localctx = new NewdirContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_newdir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292); match(DIRECTIVE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u0129\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\5\2P\n\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\5\3X\n\3\3\3\3\3\5\3\\\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\5\6g\n\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\5\tq\n\t\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\5\13z\n\13\3\f\3\f\3\f\5\f\177\n\f\3\r\5\r\u0082\n\r\3"+
		"\16\3\16\5\16\u0086\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u009c\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00a8\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \5 \u010c"+
		"\n \3!\3!\5!\u0110\n!\3\"\3\"\5\"\u0114\n\"\3#\3#\3#\3$\3$\3$\3$\5$\u011d"+
		"\n$\3%\3%\3%\3&\3&\3&\5&\u0125\n&\3\'\3\'\3\'\2\2(\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL\2\3\4\2\17\17!!\u011d"+
		"\2O\3\2\2\2\4[\3\2\2\2\6]\3\2\2\2\b`\3\2\2\2\nf\3\2\2\2\fh\3\2\2\2\16"+
		"j\3\2\2\2\20p\3\2\2\2\22r\3\2\2\2\24y\3\2\2\2\26~\3\2\2\2\30\u0081\3\2"+
		"\2\2\32\u0085\3\2\2\2\34\u0087\3\2\2\2\36\u008c\3\2\2\2 \u0093\3\2\2\2"+
		"\"\u0095\3\2\2\2$\u009b\3\2\2\2&\u00a7\3\2\2\2(\u00a9\3\2\2\2*\u00b2\3"+
		"\2\2\2,\u00bb\3\2\2\2.\u00c4\3\2\2\2\60\u00cd\3\2\2\2\62\u00d6\3\2\2\2"+
		"\64\u00df\3\2\2\2\66\u00ea\3\2\2\28\u00f5\3\2\2\2:\u0100\3\2\2\2<\u0107"+
		"\3\2\2\2>\u010b\3\2\2\2@\u010f\3\2\2\2B\u0113\3\2\2\2D\u0115\3\2\2\2F"+
		"\u011c\3\2\2\2H\u011e\3\2\2\2J\u0124\3\2\2\2L\u0126\3\2\2\2NP\5\6\4\2"+
		"ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\5\4\3\2R\3\3\2\2\2SX\5\b\5\2TX\5\16\b"+
		"\2UX\5\"\22\2VX\5H%\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2XY\3\2\2"+
		"\2YZ\5\4\3\2Z\\\3\2\2\2[W\3\2\2\2[\\\3\2\2\2\\\5\3\2\2\2]^\7\b\2\2^_\7"+
		"!\2\2_\7\3\2\2\2`a\7\t\2\2ab\5\n\6\2b\t\3\2\2\2cd\5\f\7\2de\5\n\6\2eg"+
		"\3\2\2\2fc\3\2\2\2fg\3\2\2\2g\13\3\2\2\2hi\7\36\2\2i\r\3\2\2\2jk\7\n\2"+
		"\2kl\5\20\t\2l\17\3\2\2\2mn\5\22\n\2no\5\20\t\2oq\3\2\2\2pm\3\2\2\2pq"+
		"\3\2\2\2q\21\3\2\2\2rs\7!\2\2st\7\23\2\2tu\5\24\13\2u\23\3\2\2\2vz\5\26"+
		"\f\2wz\5\32\16\2xz\5 \21\2yv\3\2\2\2yw\3\2\2\2yx\3\2\2\2z\25\3\2\2\2{"+
		"|\7\37\2\2|\177\5\30\r\2}\177\7\22\2\2~{\3\2\2\2~}\3\2\2\2\177\27\3\2"+
		"\2\2\u0080\u0082\7\35\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\31\3\2\2\2\u0083\u0086\5\34\17\2\u0084\u0086\5\36\20\2\u0085\u0083\3"+
		"\2\2\2\u0085\u0084\3\2\2\2\u0086\33\3\2\2\2\u0087\u0088\7\20\2\2\u0088"+
		"\u0089\7\5\2\2\u0089\u008a\5> \2\u008a\u008b\7\6\2\2\u008b\35\3\2\2\2"+
		"\u008c\u008d\7\21\2\2\u008d\u008e\7\5\2\2\u008e\u008f\5> \2\u008f\u0090"+
		"\7\7\2\2\u0090\u0091\5> \2\u0091\u0092\7\6\2\2\u0092\37\3\2\2\2\u0093"+
		"\u0094\7 \2\2\u0094!\3\2\2\2\u0095\u0096\7\13\2\2\u0096\u0097\5$\23\2"+
		"\u0097#\3\2\2\2\u0098\u0099\5&\24\2\u0099\u009a\5$\23\2\u009a\u009c\3"+
		"\2\2\2\u009b\u0098\3\2\2\2\u009b\u009c\3\2\2\2\u009c%\3\2\2\2\u009d\u00a8"+
		"\5(\25\2\u009e\u00a8\5*\26\2\u009f\u00a8\5,\27\2\u00a0\u00a8\5.\30\2\u00a1"+
		"\u00a8\5\60\31\2\u00a2\u00a8\5\62\32\2\u00a3\u00a8\5\64\33\2\u00a4\u00a8"+
		"\5\66\34\2\u00a5\u00a8\58\35\2\u00a6\u00a8\5:\36\2\u00a7\u009d\3\2\2\2"+
		"\u00a7\u009e\3\2\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a0\3\2\2\2\u00a7\u00a1"+
		"\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\'\3\2\2\2\u00a9\u00aa\7\24\2"+
		"\2\u00aa\u00ab\5> \2\u00ab\u00ac\7\r\2\2\u00ac\u00ad\7\5\2\2\u00ad\u00ae"+
		"\5<\37\2\u00ae\u00af\7\7\2\2\u00af\u00b0\5<\37\2\u00b0\u00b1\7\6\2\2\u00b1"+
		")\3\2\2\2\u00b2\u00b3\7\25\2\2\u00b3\u00b4\5> \2\u00b4\u00b5\7\r\2\2\u00b5"+
		"\u00b6\7\5\2\2\u00b6\u00b7\5<\37\2\u00b7\u00b8\7\7\2\2\u00b8\u00b9\5<"+
		"\37\2\u00b9\u00ba\7\6\2\2\u00ba+\3\2\2\2\u00bb\u00bc\7\26\2\2\u00bc\u00bd"+
		"\5> \2\u00bd\u00be\7\r\2\2\u00be\u00bf\7\5\2\2\u00bf\u00c0\5<\37\2\u00c0"+
		"\u00c1\7\7\2\2\u00c1\u00c2\5<\37\2\u00c2\u00c3\7\6\2\2\u00c3-\3\2\2\2"+
		"\u00c4\u00c5\7\27\2\2\u00c5\u00c6\5@!\2\u00c6\u00c7\7\r\2\2\u00c7\u00c8"+
		"\7\5\2\2\u00c8\u00c9\5<\37\2\u00c9\u00ca\7\7\2\2\u00ca\u00cb\5<\37\2\u00cb"+
		"\u00cc\7\6\2\2\u00cc/\3\2\2\2\u00cd\u00ce\7\30\2\2\u00ce\u00cf\5@!\2\u00cf"+
		"\u00d0\7\r\2\2\u00d0\u00d1\7\5\2\2\u00d1\u00d2\5<\37\2\u00d2\u00d3\7\7"+
		"\2\2\u00d3\u00d4\5<\37\2\u00d4\u00d5\7\6\2\2\u00d5\61\3\2\2\2\u00d6\u00d7"+
		"\7\31\2\2\u00d7\u00d8\5B\"\2\u00d8\u00d9\7\r\2\2\u00d9\u00da\7\5\2\2\u00da"+
		"\u00db\5<\37\2\u00db\u00dc\7\7\2\2\u00dc\u00dd\5<\37\2\u00dd\u00de\7\6"+
		"\2\2\u00de\63\3\2\2\2\u00df\u00e0\7\32\2\2\u00e0\u00e1\5B\"\2\u00e1\u00e2"+
		"\7\r\2\2\u00e2\u00e3\7\5\2\2\u00e3\u00e4\5<\37\2\u00e4\u00e5\7\7\2\2\u00e5"+
		"\u00e6\5<\37\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\5<\37\2\u00e8\u00e9\7\6"+
		"\2\2\u00e9\65\3\2\2\2\u00ea\u00eb\7\33\2\2\u00eb\u00ec\5B\"\2\u00ec\u00ed"+
		"\7\r\2\2\u00ed\u00ee\7\5\2\2\u00ee\u00ef\5<\37\2\u00ef\u00f0\7\7\2\2\u00f0"+
		"\u00f1\5<\37\2\u00f1\u00f2\7\7\2\2\u00f2\u00f3\5<\37\2\u00f3\u00f4\7\6"+
		"\2\2\u00f4\67\3\2\2\2\u00f5\u00f6\7\34\2\2\u00f6\u00f7\5B\"\2\u00f7\u00f8"+
		"\7\r\2\2\u00f8\u00f9\7\5\2\2\u00f9\u00fa\5<\37\2\u00fa\u00fb\7\7\2\2\u00fb"+
		"\u00fc\5<\37\2\u00fc\u00fd\7\7\2\2\u00fd\u00fe\5<\37\2\u00fe\u00ff\7\6"+
		"\2\2\u00ff9\3\2\2\2\u0100\u0101\7\16\2\2\u0101\u0102\5B\"\2\u0102\u0103"+
		"\7\r\2\2\u0103\u0104\7\5\2\2\u0104\u0105\5D#\2\u0105\u0106\7\6\2\2\u0106"+
		";\3\2\2\2\u0107\u0108\t\2\2\2\u0108=\3\2\2\2\u0109\u010c\5\26\f\2\u010a"+
		"\u010c\7!\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c?\3\2\2\2\u010d"+
		"\u0110\5\32\16\2\u010e\u0110\7!\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3"+
		"\2\2\2\u0110A\3\2\2\2\u0111\u0114\5 \21\2\u0112\u0114\7!\2\2\u0113\u0111"+
		"\3\2\2\2\u0113\u0112\3\2\2\2\u0114C\3\2\2\2\u0115\u0116\5<\37\2\u0116"+
		"\u0117\5F$\2\u0117E\3\2\2\2\u0118\u0119\7\7\2\2\u0119\u011a\5<\37\2\u011a"+
		"\u011b\5F$\2\u011b\u011d\3\2\2\2\u011c\u0118\3\2\2\2\u011c\u011d\3\2\2"+
		"\2\u011dG\3\2\2\2\u011e\u011f\7\f\2\2\u011f\u0120\5J&\2\u0120I\3\2\2\2"+
		"\u0121\u0122\5L\'\2\u0122\u0123\5J&\2\u0123\u0125\3\2\2\2\u0124\u0121"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125K\3\2\2\2\u0126\u0127\7\"\2\2\u0127"+
		"M\3\2\2\2\22OW[fpy~\u0081\u0085\u009b\u00a7\u010b\u010f\u0113\u011c\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}