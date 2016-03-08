package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import exceptions.*;
import grammar.GrammarBaseListener;
import grammar.GrammarLexer;
import grammar.GrammarParser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import components.ActiveBipole;
import components.Diode;
import components.GenericModel;
import components.PassiveBipole;
import components.Transistor;
import constants.Constant;
import constants.ModelType;
import constants.Value;
import constants.Waveform;


/**
 *Parses a WaSabi file.
 */
public class Compiler extends GrammarBaseListener {

	/**
	 * Tokens detected in the parsed file.
	 */
	private CommonTokenStream tokens;
	
	/**
	 * Syntax tree of the parsed file.
	 */
	private ParserRuleContext syntaxTree;

	/**
	 * Prints a list of all the tokens in the console.
	 */
	public void stampTokens() {
		List<Token> ts = tokens.getTokens();
		for (int i = 0; i < ts.size(); ++i)
			System.out.println(ts.get(i).getText() + "\t[" + ts.get(i).getType() + "]");
	}

	
	/**
	 * Prints the syntax tree in the console.
	 */
	public void stampSintaxTree() {
		StampTree.stampTree(syntaxTree);
	}

	/**
	 * Initializes a new compiler instance.
	 * @param path <String> The path of the file that will be parsed
	 * @throws IOException Throws an {@link IOException} if error are encountered opening/reading the file.
	 * @throws SemanticException Throws a {@link SemanticException} if semantic errors are found in the file.
	 */
	public Compiler(String path) throws IOException, SemanticException {
		// Lexer
		ANTLRFileStream input = new ANTLRFileStream(path);

		this.tokens = new CommonTokenStream(new GrammarLexer(input));
		tokens.getText();

		// Parser
		GrammarParser parser = new GrammarParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		syntaxTree = parser.axiom();

		exceptions = new Vector<SemanticException>();

		isTit = false;
		title = "";

		librarys = new Vector<String>();

		resetLastModelType();
		resetLastValue();
		resetLastWaveform();
		constants = new Vector<Constant>();

		nodes = new Vector<String>();
		nodeCount = new Vector<Integer>();
		newNodes = new Vector<Integer>();
		gnd = false;
		gnd2 = false;

		comp = false;

		resistances = new Vector<PassiveBipole>();
		capacitors = new Vector<PassiveBipole>();
		inductances = new Vector<PassiveBipole>();
		voltages = new Vector<ActiveBipole>();
		currents = new Vector<ActiveBipole>();
		diodes = new Vector<Diode>();
		bjts = new Vector<Transistor>();
		mosfets = new Vector<Transistor>();
		jfets = new Vector<Transistor>();
		models = new Vector<GenericModel>();

		directives = new Vector<String>();

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, syntaxTree);
		throwException();
	}

	// Error handling
	/**
	 * List of exception raised during the parsing.
	 */
	private Vector<SemanticException> exceptions;
	/**
	 * Internal variable; true if the circuit has at least a component.
	 */
	boolean comp;

	/**
	 * Throws all the exceptions raised during the parsing process
	 * @throws SemanticException This method can throw a SemanticException if semantic errors are found in the file
	 */
	public void throwException() throws SemanticException {
		for (SemanticException se : exceptions)
			throw se;

		if (!comp)
			throw new NoComponentException();

		if (!gnd)
			throw new NoGNDException();
		else if (!gnd2)
			throw new FloatingNodeException("GND");

		for (int i = 0; i < nodeCount.size(); ++i)
			if (nodeCount.get(i) == 1)
				throw new FloatingNodeException(nodes.get(i));
	}

	
	// Title
	/**
	 * Internal variable; true if the circuit has a title.
	 */
	private boolean isTit;
	/**
	 * Stores the circuit's title.
	 */
	private String title;

	/**
	 * Executes at the end of a Title context; extracts the title from the context. 
	 * @param ctx Context of a title (a sub syntax tree with title as root).
	 */
	@Override
	public void exitTitle(grammar.GrammarParser.TitleContext ctx) {
		isTit = true;
		title = ctx.ID().getText();
	}

	/**
	 * Prints the title in the console.
	 */
	public void stampTitle() {
		if (isTit)
			System.out.println(title);
		else
			System.out.println("Unnamed circuit");
	}

	/**
	 * Prints the title to file. Used to generate the SPICE .cir file.
	 * @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampTitle(FileWriter writer) throws IOException {
		if (isTit)
			if (title.length() < 80)
				writer.write(title);
			else
				writer.write(title.substring(0, 79));
		else
			writer.write("Circuit");
		writer.write("\r\n");
	}

	// Library
	/**
	 * Stores the circuit's libraries.
	 */
	private Vector<String> librarys;

	/**
	 * Executes at the start of a libraries context; extracts the libraries paths from the context.
	 * @param ctx Context of a libraries (a sub syntax tree with libraries as root).
	 */
	@Override
	public void enterNewlib(grammar.GrammarParser.NewlibContext ctx) {
		String ns = ctx.PATH().getText();
		Boolean err = false;
		for (String c : librarys)
			if (c.equalsIgnoreCase(ns))
				err = true;

		if (err)
			exceptions.add(new DuplicateLibraryException(ctx.PATH().getSymbol(), ns));
		else
			librarys.add(ns);

	}

	/**
	 * Prints the libraries in the console.
	 */
	public void stampLib() {
		for (String s : librarys)
			System.out.println("\t" + s);
	}

	/**
	 * Prints the libraries to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampLib(FileWriter writer) throws IOException {
		for (String s : librarys) {
			writer.write(".lib " + s);
			writer.write("\r\n");
		}

	}

	// Model type
	/**
	 * Internal variable; stores the last declared model.
	 */
	private ModelType lastModelType;

	/**
	 * Resets the last declared model.
	 * @see lastModelType
	 */
	private void resetLastModelType() {
		lastModelType = null;
	}

	/**
	 * Executes at the end of a model declaration context; extracts the model type from the context.
	 * @param ctx Context of a model declaration (a sub syntax tree with model declaration as root).
	 */
	@Override
	public void exitNewmod(grammar.GrammarParser.NewmodContext ctx) {
		lastModelType = new ModelType(ctx.MODTYPE().getText());
	}

	/**
	 * Executes at the end of a model usage context; extracts the name and model type from the context.
	 * @param ctx Context of a model usage (a sub syntax tree with model usage as root).
	 */
	@Override
	public void exitModtypeID(grammar.GrammarParser.ModtypeIDContext ctx) {
		if (ctx.ID() != null) {
			String name = ctx.ID().getText();

			Constant c = null;
			for (Constant co : constants)
				if (co.equals(name)) {
					c = co;
					break;
				}

			if (c == null)
				exceptions.add(new ConstantNotDefineException(ctx.ID().getSymbol()));
			else {
				if (c.isModelType())
					lastModelType = c.getModelType();
				else if (c.isValue())
					exceptions.add(new WrongTypeConstantException(ctx.ID().getSymbol(), 0, 1));
				else
					exceptions.add(new WrongTypeConstantException(ctx.ID().getSymbol(), 0, 2));
			}
		}
	}

	// Value
	/**
	 * Internal variable; stores the last declared value.
	 */
	private Value lastValue;
	/**
	 * Internal variable; stores the last used value.
	 */
	private String lastValueID1;
	/**
	 * Internal variable; stores the last used value.
	 * There are cases where 2 values are used at the same time; this variable is used in those cases.
	 * @see lastValueID1
	 */
	private String lastValueID2;

	/**
	 * Resets the last declared/used value.
	 * @see lastValue
	 * @see lastValueID1
	 * @see lastValueID2
	 */
	private void resetLastValue() {
		lastValue = null;
		lastValueID1 = null;
		lastValueID2 = null;

	}

	/**
	 * Executes at the end of a value declaration context; extracts the numeric value from the context.
	 * @param ctx Context of a value declaration (a sub syntax tree with value declaration as root).
	 */
	@Override
	public void exitNewvalue(grammar.GrammarParser.NewvalueContext ctx) {
		if (ctx.PI() != null) {
			String pi = ctx.getText().substring(0, ctx.getText().length() - 2);
			if (pi.length() == 0)
				lastValue = new Value(Math.PI, "");
			else
				lastValue = new Value(Math.PI * Float.parseFloat(pi), "");
		}
		else {
			String exp = "";
			if (ctx.UNIT() != null)
				exp = ctx.UNIT().getText();

			lastValue = new Value(Float.parseFloat(ctx.VALUE().getText()), exp);
		}
	}

	/**
	 * Executes at the end of a value usage context; extracts the name and value from the context.
	 * @param ctx Context of a value usage (a sub syntax tree with value usage as root).
	 */
	@Override
	public void exitValueID(grammar.GrammarParser.ValueIDContext ctx) {
		lastValueID2 = lastValueID1;
		if (ctx.ID() != null) {
			String name = ctx.ID().getText();

			Constant c = null;
			for (Constant co : constants)
				if (co.equals(name)) {
					c = co;
					break;
				}

			if (c == null) {
				exceptions.add(new ConstantNotDefineException(ctx.ID().getSymbol()));
			} else {
				if (c.isModelType())
					exceptions.add(new WrongTypeConstantException(ctx.ID().getSymbol(), 1, 0));
				else if (c.isValue())
					lastValueID1 = c.getValue().toSPICE();
				else
					exceptions.add(new WrongTypeConstantException(ctx.ID().getSymbol(), 1, 2));
			}
		}
		else
			lastValueID1 = lastValue.toSPICE();
	}

	// Waveform
	/**
	 * Internal variable; stores the last declared waveform.
	 */
	private Waveform lastWaveform;

	/**
	 * Resets the last declared waveform.
	 * @see lastWaveform
	 */
	private void resetLastWaveform() {
		lastWaveform = null;
	}

	/**
	 * Executes at the end of a DC waveform declaration context; extracts the magnitude from the context.
	 * @param ctx Context of the waveform declaration (a sub syntax tree with waveform declaration as root).
	 */
	@Override
	public void exitNewwaveDC(grammar.GrammarParser.NewwaveDCContext ctx) {
		lastWaveform = new Waveform(lastValueID1);
		resetLastValue();
	}

	/**
	 * Executes at the end of an AC waveform declaration context; extracts the magnitude and phase from the context.
	 * @param ctx Context of the waveform declaration (a sub syntax tree with waveform declaration as root).
	 */
	@Override
	public void exitNewwaveAC(grammar.GrammarParser.NewwaveACContext ctx) {

		lastWaveform = new Waveform(lastValueID2, lastValueID1);
		resetLastValue();
	}

	/**
	 * Executes at the end of a waveform usage context; extracts the name and magnitude (and phase, if present) from the context.
	 * @param ctx Context of the waveform usage (a sub syntax tree with waveform usage as root).
	 */
	@Override
	public void exitWaveID(grammar.GrammarParser.WaveIDContext ctx) {
		if (ctx.ID() != null) {
			String name = ctx.ID().getText();

			Constant c = null;
			for (Constant co : constants)
				if (co.equals(name)) {
					c = co;
					break;
				}

			if (c == null)
				exceptions.add(new ConstantNotDefineException(ctx.ID().getSymbol()));
			else {

				if (c.isModelType())
					exceptions.add(new WrongTypeConstantException(ctx.ID().getSymbol(), 2, 0));
				else if (c.isValue())
					exceptions.add(new WrongTypeConstantException(ctx.ID().getSymbol(), 2, 1));
				else
					lastWaveform = c.getWaveform();
			}
		}
	}

	// Constants
	/**
	 * Internal variable; stores the list of constants.
	 */
	private Vector<Constant> constants = new Vector<Constant>();

	/**
	 * Executes at the end of a constant declaration context; extracts the name and the value (or model, or Waveform) from the context.
	 * @param ctx Context of the constant declaration (a sub syntax tree with constant declaration as root).
	 */
	@Override
	public void exitNewconst(grammar.GrammarParser.NewconstContext ctx) {
		String name = ctx.ID().getText();

		Constant c = null;
		for (Constant co : constants)
			if (co.equals(name)) {
				c = co;
				break;
			}

		if (c == null) {
			Constant nc = null;
			if (lastModelType != null)
				nc = new Constant(name, lastModelType);
			else if (lastValue != null)
				nc = new Constant(name, lastValue);
			else if (lastWaveform != null)
				nc = new Constant(name, lastWaveform);

			resetLastModelType();
			resetLastValue();
			resetLastWaveform();

			constants.add(nc);
		} else
			exceptions.add(new ConstSameNameException(ctx.ID().getSymbol()));

	}

	/**
	 * Prints the constants in the console.
	 */
	public void stampConst() {
		for (Constant c : constants) {
			String s = "\t" + c.getName() + "\t\t= ";
			if (c.isModelType())
				s = s + c.getModelType().getType();
			else if (c.isValue())
				s = s + c.getValue().toSPICE();
			else if (c.isWaveform())
				s = s + c.getWaveform().toSPICE();

			System.out.println(s);
		}
	}

	// nodes
	/**
	 * Internal variable; stores the list of the nodes names.
	 */
	private Vector<String> nodes;
	/**
	 * Internal variable; stores the count of the times each node has been used.
	 * nodeCount[i] contains how many times the node in nodes[i] has been used.
	 * This variable is used in the {@link FloatingNodeException} exception.
	 */
	private Vector<Integer> nodeCount;
	/**
	 * Internal variable; stores the list of the last encountered nodes.
	 */
	private Vector<Integer> newNodes;
	/**
	 * Internal variable; is true if a ground node is present.
	 */
	boolean gnd;
	/**
	 * Internal variable; used to check if two ground nodes are declared.
	 */
	boolean gnd2;

	/**
	 * Resets the list of the encountered nodes.
	 * @see newNodes
	 */
	private void resetNewNodes() {
		newNodes.clear();
	}

	/**
	 * Executes at the end of a node context; extracts the number of the node (and eventually if the node is GND) from the context.
	 * @param ctx Context of the node (a sub syntax tree with node as root).
	 */
	@Override
	public void exitNode(grammar.GrammarParser.NodeContext ctx) {
		int n;
		if (ctx.GND() != null) {
			n = -1;
			if (gnd)
				gnd2 = true;
			else
				gnd = true;
		}
		else {
			n = nodes.indexOf(ctx.ID().getText().toLowerCase());
			if (n == -1) {
				nodes.add(ctx.ID().getText().toLowerCase());
				n = nodes.size() - 1;
				nodeCount.add(1);
			} else
				nodeCount.set(n, nodeCount.get(n) + 1);
		}
		newNodes.add(n);
	}

	// resistances
	/**
	 * Stores the list of resistances.
	 */
	private Vector<PassiveBipole> resistances;

	/**
	 * Executes at the end of a resistance context; extracts the value and connected nodes from the context.
	 * @param ctx Context of the resistance (a sub syntax tree with resistance as root).
	 */
	@Override
	public void exitResistance(grammar.GrammarParser.ResistanceContext ctx) {
		if (newNodes.get(0) == newNodes.get(1))
			exceptions.add(new SameNodeException(ctx.RES().getSymbol()));

		if (lastValueID1.equals("0"))
			exceptions.add(new ZeroValueException(ctx.RES().getSymbol()));

		resistances.add(new PassiveBipole(lastValueID1, newNodes.get(0), newNodes.get(1)));

		comp = true;

		resetLastValue();
		resetNewNodes();
	}

	/**
	 * Prints the list of resistances in the console.
	 */
	public void stampRes() {
		int i = 1;
		for (PassiveBipole b : resistances) {
			System.out.println("\t" + b.toConsole("Resistance"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of resistances to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampRes(FileWriter writer) throws IOException {
		int i = 1;
		for (PassiveBipole b : resistances) {
			writer.write(b.toSPICE("R", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// Capacitor
	/**
	 * Stores the list of capacitors.
	 */
	private Vector<PassiveBipole> capacitors;

	/**
	 * Executes at the end of a capacitor context; extracts the value and connected nodes from the context.
	 * @param ctx Context of the capacitor (a sub syntax tree with capacitor as root).
	 */
	@Override
	public void exitCapaticance(grammar.GrammarParser.CapaticanceContext ctx) {
		if (newNodes.get(0) == newNodes.get(1))
			exceptions.add(new SameNodeException(ctx.CAP().getSymbol()));

		if (lastValueID1.equals("0"))
			exceptions.add(new ZeroValueException(ctx.CAP().getSymbol()));

		capacitors.add(new PassiveBipole(lastValueID1, newNodes.get(0), newNodes.get(1)));

		comp = true;

		resetLastValue();
		resetNewNodes();
	}

	/**
	 * Prints the list of capacitors in the console.
	 */
	public void stampCap() {
		int i = 1;
		for (PassiveBipole b : capacitors) {
			System.out.println("\t" + b.toConsole("Capacitance"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of capacitors to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampCap(FileWriter writer) throws IOException {
		int i = 1;
		for (PassiveBipole b : capacitors) {
			writer.write(b.toSPICE("C", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// Inductances
	/**
	 * Stores the list of inductances.
	 */
	private Vector<PassiveBipole> inductances;

	/**
	 * Executes at the end of a inductance context; extracts the value and connected nodes from the context.
	 * @param ctx Context of the inductance (a sub syntax tree with inductance as root).
	 */
	@Override
	public void exitInductance(grammar.GrammarParser.InductanceContext ctx) {
		if (newNodes.get(0) == newNodes.get(1))
			exceptions.add(new SameNodeException(ctx.IND().getSymbol()));

		if (lastValueID1.equals("0"))
			exceptions.add(new ZeroValueException(ctx.IND().getSymbol()));

		inductances.add(new PassiveBipole(lastValueID1, newNodes.get(0), newNodes.get(1)));

		comp = true;

		resetLastValue();
		resetNewNodes();
	}

	/**
	 * Prints the list of inductances in the console.
	 */
	public void stampInd() {
		int i = 1;
		for (PassiveBipole b : inductances) {
			System.out.println("\t" + b.toConsole("Inductance"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of inductances to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampInd(FileWriter writer) throws IOException {
		int i = 1;
		for (PassiveBipole b : inductances) {
			writer.write(b.toSPICE("L", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// Voltage source
	/**
	 * Stores the list of voltage sources.
	 */
	private Vector<ActiveBipole> voltages;

	/**
	 * Executes at the end of a voltage source context; extracts the waveform and connected nodes from the context.
	 * @param ctx Context of the voltage source (a sub syntax tree with voltage source as root).
	 */
	@Override
	public void exitVoltage(grammar.GrammarParser.VoltageContext ctx) {

		int n1 = newNodes.get(0);
		int n2 = newNodes.get(1);

		if (n1 == n2)
			exceptions.add(new SameNodeException(ctx.VOL().getSymbol()));

		for (ActiveBipole v : voltages)
			if (v.isParallel(n1, n2))
				exceptions.add(new ParallelVoltageException(ctx.VOL().getSymbol()));

		voltages.addElement(new ActiveBipole(lastWaveform, n1, n2));

		comp = true;

		resetLastWaveform();
		resetNewNodes();
	}

	/**
	 * Prints the list of voltage sources to the console.
	 */
	public void stampVol() {
		int i = 1;
		for (ActiveBipole b : voltages) {
			System.out.println("\t" + b.toConsole("Voltage generator"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of voltage sources to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampVol(FileWriter writer) throws IOException {
		int i = 1;
		for (ActiveBipole b : voltages) {
			writer.write(b.toSPICE("V", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// current source
	/**
	 * Stores the list of current sources.
	 */
	private Vector<ActiveBipole> currents;

	/**
	 * Executes at the end of a current source context; extracts the waveform and connected nodes from the context.
	 * @param ctx Context of the current source (a sub syntax tree with current source as root).
	 */
	@Override
	public void exitCurrent(grammar.GrammarParser.CurrentContext ctx) {
		if (newNodes.get(0) == newNodes.get(1))
			exceptions.add(new SameNodeException(ctx.CUR().getSymbol()));

		currents.addElement(new ActiveBipole(lastWaveform, newNodes.get(0), newNodes.get(1)));

		comp = true;

		resetLastWaveform();
		resetNewNodes();
	}

	/**
	 * Prints the list of current sources in the console.
	 */
	public void stampCur() {
		int i = 1;
		for (ActiveBipole b : currents) {
			System.out.println("\t" + b.toConsole("Current generator"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of current sources to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampCur(FileWriter writer) throws IOException {
		int i = 1;
		for (ActiveBipole b : currents) {
			writer.write(b.toSPICE("I", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// diode
	/**
	 * Stores the list of diodes.
	 */
	private Vector<Diode> diodes;

	/**
	 * Executes at the end of a diode context; extracts model and connected nodes from the context.
	 * @param ctx Context of the diode (a sub syntax tree with diode as root).
	 */
	@Override
	public void exitDiode(grammar.GrammarParser.DiodeContext ctx) {
		if (newNodes.get(0) == newNodes.get(1))
			exceptions.add(new SameNodeException(ctx.DIO().getSymbol()));

		diodes.addElement(new Diode(lastModelType, newNodes.get(0), newNodes.get(1)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	/**
	 * Prints the list of diodes in the console.
	 */
	public void stampDio() {
		int i = 1;
		for (Diode d : diodes) {
			System.out.println("\t" + d.toConsole());
			i = i + 1;
		}
	}

	/**
	 * Prints the list of diodes to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampDio(FileWriter writer) throws IOException {
		int i = 1;
		for (Diode d : diodes) {
			writer.write(d.toSPICE(i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// bjt
	/**
	 * Stores the list of BJTs.
	 */
	private Vector<Transistor> bjts;

	/**
	 * Executes at the end of a BJT context; extracts model and connected nodes from the context.
	 * @param ctx Context of the BJT (a sub syntax tree with BJT as root).
	 */
	@Override
	public void exitBjt(grammar.GrammarParser.BjtContext ctx) {
		bjts.add(new Transistor(lastModelType, newNodes.get(0), newNodes.get(1), newNodes.get(2)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	/**
	 * Prints the list of BJTs in the console.
	 */
	public void stampBjt() {
		int i = 1;
		for (Transistor b : bjts) {
			System.out.println("\t" + b.toConsole("BJT"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of BJTs to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampBjt(FileWriter writer) throws IOException {
		int i = 1;
		for (Transistor b : bjts) {
			writer.write(b.toSPICE("Q", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// mosfets
	/**
	 * Stores the list of MOSFETs.
	 */
	private Vector<Transistor> mosfets;

	/**
	 * Executes at the end of a MOSFET context; extracts model and connected nodes from the context.
	 * @param ctx Context of the MOSFET (a sub syntax tree with MOSFET as root).
	 */
	@Override
	public void exitMosfet(grammar.GrammarParser.MosfetContext ctx) {
		mosfets.add(new Transistor(lastModelType, newNodes.get(0), newNodes.get(1), newNodes.get(2)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	/**
	 * Prints the list of MOSFETs in the console.
	 */
	public void stampMos() {
		int i = 1;
		for (Transistor b : mosfets) {
			System.out.println("\t" + b.toConsole("MosFet"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of MOSFETs to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampMos(FileWriter writer) throws IOException {
		int i = 1;
		for (Transistor b : mosfets) {
			writer.write(b.toSPICE("M", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// jfests
	/**
	 * Stores the list of JFETs.
	 */
	private Vector<Transistor> jfets;

	/**
	 * Executes at the end of a JFET context; extracts model and connected nodes from the context.
	 * @param ctx Context of the JFET (a sub syntax tree with JFET as root).
	 */
	@Override
	public void exitJfet(grammar.GrammarParser.JfetContext ctx) {
		jfets.add(new Transistor(lastModelType, newNodes.get(0), newNodes.get(1), newNodes.get(2)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	/**
	 * Prints the list of JFETs in the console.
	 */
	public void stampJfet() {
		int i = 1;
		for (Transistor b : jfets) {
			System.out.println("\t" + b.toConsole("JFET"));
			i = i + 1;
		}
	}

	/**
	 * Prints the list of JFETs to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampJfet(FileWriter writer) throws IOException {
		int i = 1;
		for (Transistor b : jfets) {
			writer.write(b.toSPICE("J", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// generic model
	/**
	 * Stores the list of generic models.
	 */
	private Vector<GenericModel> models;

	/**
	 * Executes at the end of a generic model context; extracts model and connected nodes from the context.
	 * @param ctx Context of the generic model (a sub syntax tree with generic model as root).
	 */
	@Override
	public void exitModel(grammar.GrammarParser.ModelContext ctx) {
		GenericModel m = new GenericModel(lastModelType);
		for (Integer n : newNodes)
			m.addNode(n);

		models.add(m);

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	/**
	 * Prints the list of generic models in the console.
	 */
	public void stampMod() {
		int i = 1;
		for (GenericModel b : models) {
			System.out.println("\t" + b.toConsole());
			i = i + 1;
		}

	}

	/**
	 * Prints the list of generic models to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampMod(FileWriter writer) throws IOException {
		int i = 1;
		for (GenericModel b : models) {
			writer.write(b.toSPICE(i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// directives
	/**
	 * Stores the list of SPICE analysis directives.
	 */
	private Vector<String> directives;

	/**
	 * Executes at the end of a directive context; extracts the directive from the context.
	 * @param ctx Context of the directive (a sub syntax tree with directive as root).
	 */
	@Override
	public void enterNewdir(grammar.GrammarParser.NewdirContext ctx) {
		directives.addElement(ctx.DIRECTIVE().getText());
	}

	/**
	 * Prints the list of directives in the console.
	 */
	public void stampDir() {
		for (String s : directives)
			System.out.println("\t" + s);
	}

	/**
	 * Prints the list of directives to file. Used to generate the SPICE .cir file.
	 *  @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	private void stampDir(FileWriter writer) throws IOException {
		for (String s : directives) {
			writer.write(s);
			writer.write("\r\n");
		}
	}

	// Stamp all

	/**
	 * Prints all the components in the console.
	 */
	public void stampComp() {
		stampRes();
		stampCap();
		stampInd();
		stampVol();
		stampCur();
		stampDio();
		stampBjt();
		stampMos();
		stampJfet();
		stampMod();
	}

	/**
	 * Prints all the circuit information in the console.
	 */
	public void stampAll() {
		System.out.print("Title: ");
		stampTitle();

		System.out.println("\nLibraries:");
		stampLib();

		System.out.println("\nConstansts:");
		stampConst();

		System.out.println("\nComponents:");
		stampComp();

		System.out.println("\nSPICE directive:");
		stampDir();
	}

	/**
	 * Prints all the circuit information to file. Used to generate the SPICE .cir file.
	 * @param writer A {@link FileWriter} instance used to write on file.
	 * @throws IOException Throws an {@link IOException} if errors are encountered writing on file.
	 */
	public void writeOnFile(File path) throws IOException {
		FileWriter writer = new FileWriter(path);
		
		

		stampTitle(writer);
		stampLib(writer);
		stampRes(writer);
		stampCap(writer);
		stampInd(writer);
		stampVol(writer);
		stampCur(writer);
		stampDio(writer);
		stampBjt(writer);
		stampMos(writer);
		stampJfet(writer);
		stampMod(writer);
		stampDir(writer);

		writer.close();

	}

}
