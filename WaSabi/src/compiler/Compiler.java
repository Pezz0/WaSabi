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

public class Compiler extends GrammarBaseListener {

	private CommonTokenStream tokens;
	private ParserRuleContext syntaxTree;

	public void stampTokens() {
		List<Token> ts = tokens.getTokens();
		for (int i = 0; i < ts.size(); ++i)
			System.out.println(ts.get(i).getText() + "\t[" + ts.get(i).getType() + "]");
	}

	public void stampSintaxTree() {
		StampTree.stampTree(syntaxTree);
	}

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
	private Vector<SemanticException> exceptions;
	boolean comp;

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
	private boolean isTit;
	private String title;

	@Override
	public void exitTitle(grammar.GrammarParser.TitleContext ctx) {
		isTit = true;
		title = ctx.ID().getText();
	}

	public void stampTitle() {
		if (isTit)
			System.out.println(title);
		else
			System.out.println("Unnamed circuit");
	}

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
	private Vector<String> librarys;

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

	public void stampLib() {
		for (String s : librarys)
			System.out.println("\t" + s);
	}

	private void stampLib(FileWriter writer) throws IOException {
		for (String s : librarys) {
			writer.write(".lib " + s);
			writer.write("\r\n");
		}

	}

	// Model type
	private ModelType lastModelType;

	private void resetLastModelType() {
		lastModelType = null;
	}

	@Override
	public void exitNewmod(grammar.GrammarParser.NewmodContext ctx) {
		lastModelType = new ModelType(ctx.MODTYPE().getText());
	}

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
	private Value lastValue;
	private String lastValueID1;
	private String lastValueID2;

	private void resetLastValue() {
		lastValue = null;
		lastValueID1 = null;
		lastValueID2 = null;

	}

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
	private Waveform lastWaveform;

	private void resetLastWaveform() {
		lastWaveform = null;
	}

	@Override
	public void exitNewwaveDC(grammar.GrammarParser.NewwaveDCContext ctx) {
		lastWaveform = new Waveform(lastValueID1);
		resetLastValue();
	}

	@Override
	public void exitNewwaveAC(grammar.GrammarParser.NewwaveACContext ctx) {

		lastWaveform = new Waveform(lastValueID2, lastValueID1);
		resetLastValue();
	}

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
	private Vector<Constant> constants = new Vector<Constant>();

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
	private Vector<String> nodes;
	private Vector<Integer> nodeCount;
	private Vector<Integer> newNodes;
	boolean gnd;
	boolean gnd2;

	private void resetNewNodes() {
		newNodes.clear();
	}

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
	private Vector<PassiveBipole> resistances;

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

	public void stampRes() {
		int i = 1;
		for (PassiveBipole b : resistances) {
			System.out.println("\t" + b.toConsole("Resistance"));
			i = i + 1;
		}
	}

	private void stampRes(FileWriter writer) throws IOException {
		int i = 1;
		for (PassiveBipole b : resistances) {
			writer.write(b.toSPICE("R", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// Capacitor
	private Vector<PassiveBipole> capacitors;

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

	public void stampCap() {
		int i = 1;
		for (PassiveBipole b : capacitors) {
			System.out.println("\t" + b.toConsole("Capacitance"));
			i = i + 1;
		}
	}

	private void stampCap(FileWriter writer) throws IOException {
		int i = 1;
		for (PassiveBipole b : capacitors) {
			writer.write(b.toSPICE("C", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// Inductances
	private Vector<PassiveBipole> inductances;

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

	public void stampInd() {
		int i = 1;
		for (PassiveBipole b : inductances) {
			System.out.println("\t" + b.toConsole("Inductance"));
			i = i + 1;
		}
	}

	private void stampInd(FileWriter writer) throws IOException {
		int i = 1;
		for (PassiveBipole b : inductances) {
			writer.write(b.toSPICE("L", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// Voltage source
	private Vector<ActiveBipole> voltages;

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

	public void stampVol() {
		int i = 1;
		for (ActiveBipole b : voltages) {
			System.out.println("\t" + b.toConsole("Voltage generator"));
			i = i + 1;
		}
	}

	private void stampVol(FileWriter writer) throws IOException {
		int i = 1;
		for (ActiveBipole b : voltages) {
			writer.write(b.toSPICE("V", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// current source
	private Vector<ActiveBipole> currents;

	@Override
	public void exitCurrent(grammar.GrammarParser.CurrentContext ctx) {
		if (newNodes.get(0) == newNodes.get(1))
			exceptions.add(new SameNodeException(ctx.CUR().getSymbol()));

		currents.addElement(new ActiveBipole(lastWaveform, newNodes.get(0), newNodes.get(1)));

		comp = true;

		resetLastWaveform();
		resetNewNodes();
	}

	public void stampCur() {
		int i = 1;
		for (ActiveBipole b : currents) {
			System.out.println("\t" + b.toConsole("Current generator"));
			i = i + 1;
		}
	}

	private void stampCur(FileWriter writer) throws IOException {
		int i = 1;
		for (ActiveBipole b : currents) {
			writer.write(b.toSPICE("I", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// diode
	private Vector<Diode> diodes;

	@Override
	public void exitDiode(grammar.GrammarParser.DiodeContext ctx) {
		if (newNodes.get(0) == newNodes.get(1))
			exceptions.add(new SameNodeException(ctx.DIO().getSymbol()));

		diodes.addElement(new Diode(lastModelType, newNodes.get(0), newNodes.get(1)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	public void stampDio() {
		int i = 1;
		for (Diode d : diodes) {
			System.out.println("\t" + d.toConsole());
			i = i + 1;
		}
	}

	private void stampDio(FileWriter writer) throws IOException {
		int i = 1;
		for (Diode d : diodes) {
			writer.write(d.toSPICE(i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// bjt
	private Vector<Transistor> bjts;

	@Override
	public void exitBjt(grammar.GrammarParser.BjtContext ctx) {
		bjts.add(new Transistor(lastModelType, newNodes.get(0), newNodes.get(1), newNodes.get(2)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	public void stampBjt() {
		int i = 1;
		for (Transistor b : bjts) {
			System.out.println("\t" + b.toConsole("BJT"));
			i = i + 1;
		}
	}

	private void stampBjt(FileWriter writer) throws IOException {
		int i = 1;
		for (Transistor b : bjts) {
			writer.write(b.toSPICE("Q", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// mosfets
	private Vector<Transistor> mosfets;

	@Override
	public void exitMosfet(grammar.GrammarParser.MosfetContext ctx) {
		mosfets.add(new Transistor(lastModelType, newNodes.get(0), newNodes.get(1), newNodes.get(2)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	public void stampMos() {
		int i = 1;
		for (Transistor b : mosfets) {
			System.out.println("\t" + b.toConsole("MosFet"));
			i = i + 1;
		}
	}

	private void stampMos(FileWriter writer) throws IOException {
		int i = 1;
		for (Transistor b : mosfets) {
			writer.write(b.toSPICE("M", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// jfests
	private Vector<Transistor> jfets;

	@Override
	public void exitJfet(grammar.GrammarParser.JfetContext ctx) {
		jfets.add(new Transistor(lastModelType, newNodes.get(0), newNodes.get(1), newNodes.get(2)));

		comp = true;

		resetLastModelType();
		resetNewNodes();
	}

	public void stampJfet() {
		int i = 1;
		for (Transistor b : jfets) {
			System.out.println("\t" + b.toConsole("JFET"));
			i = i + 1;
		}
	}

	private void stampJfet(FileWriter writer) throws IOException {
		int i = 1;
		for (Transistor b : jfets) {
			writer.write(b.toSPICE("J", i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// generic model
	private Vector<GenericModel> models;

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

	public void stampMod() {
		int i = 1;
		for (GenericModel b : models) {
			System.out.println("\t" + b.toConsole());
			i = i + 1;
		}

	}

	private void stampMod(FileWriter writer) throws IOException {
		int i = 1;
		for (GenericModel b : models) {
			writer.write(b.toSPICE(i));
			writer.write("\r\n");
			i = i + 1;
		}
	}

	// directives
	private Vector<String> directives;

	@Override
	public void enterNewdir(grammar.GrammarParser.NewdirContext ctx) {
		directives.addElement(ctx.DIRECTIVE().getText());
	}

	public void stampDir() {
		for (String s : directives)
			System.out.println("\t" + s);
	}

	private void stampDir(FileWriter writer) throws IOException {
		for (String s : directives) {
			writer.write(s);
			writer.write("\r\n");
		}
	}

	// Stamp all

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
