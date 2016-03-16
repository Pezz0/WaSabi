// Generated from Grammar.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#pr}.
	 * @param ctx the parse tree
	 */
	void enterPr(@NotNull GrammarParser.PrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#pr}.
	 * @param ctx the parse tree
	 */
	void exitPr(@NotNull GrammarParser.PrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newvalue}.
	 * @param ctx the parse tree
	 */
	void enterNewvalue(@NotNull GrammarParser.NewvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newvalue}.
	 * @param ctx the parse tree
	 */
	void exitNewvalue(@NotNull GrammarParser.NewvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#components}.
	 * @param ctx the parse tree
	 */
	void enterComponents(@NotNull GrammarParser.ComponentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#components}.
	 * @param ctx the parse tree
	 */
	void exitComponents(@NotNull GrammarParser.ComponentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#valueID}.
	 * @param ctx the parse tree
	 */
	void enterValueID(@NotNull GrammarParser.ValueIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#valueID}.
	 * @param ctx the parse tree
	 */
	void exitValueID(@NotNull GrammarParser.ValueIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#inductance}.
	 * @param ctx the parse tree
	 */
	void enterInductance(@NotNull GrammarParser.InductanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#inductance}.
	 * @param ctx the parse tree
	 */
	void exitInductance(@NotNull GrammarParser.InductanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#listconst}.
	 * @param ctx the parse tree
	 */
	void enterListconst(@NotNull GrammarParser.ListconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#listconst}.
	 * @param ctx the parse tree
	 */
	void exitListconst(@NotNull GrammarParser.ListconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#listnodes}.
	 * @param ctx the parse tree
	 */
	void enterListnodes(@NotNull GrammarParser.ListnodesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#listnodes}.
	 * @param ctx the parse tree
	 */
	void exitListnodes(@NotNull GrammarParser.ListnodesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#waveID}.
	 * @param ctx the parse tree
	 */
	void enterWaveID(@NotNull GrammarParser.WaveIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#waveID}.
	 * @param ctx the parse tree
	 */
	void exitWaveID(@NotNull GrammarParser.WaveIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#units}.
	 * @param ctx the parse tree
	 */
	void enterUnits(@NotNull GrammarParser.UnitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#units}.
	 * @param ctx the parse tree
	 */
	void exitUnits(@NotNull GrammarParser.UnitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#dirsim}.
	 * @param ctx the parse tree
	 */
	void enterDirsim(@NotNull GrammarParser.DirsimContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#dirsim}.
	 * @param ctx the parse tree
	 */
	void exitDirsim(@NotNull GrammarParser.DirsimContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(@NotNull GrammarParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(@NotNull GrammarParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newconst2}.
	 * @param ctx the parse tree
	 */
	void enterNewconst2(@NotNull GrammarParser.Newconst2Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newconst2}.
	 * @param ctx the parse tree
	 */
	void exitNewconst2(@NotNull GrammarParser.Newconst2Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newconst}.
	 * @param ctx the parse tree
	 */
	void enterNewconst(@NotNull GrammarParser.NewconstContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newconst}.
	 * @param ctx the parse tree
	 */
	void exitNewconst(@NotNull GrammarParser.NewconstContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newwave}.
	 * @param ctx the parse tree
	 */
	void enterNewwave(@NotNull GrammarParser.NewwaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newwave}.
	 * @param ctx the parse tree
	 */
	void exitNewwave(@NotNull GrammarParser.NewwaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#current}.
	 * @param ctx the parse tree
	 */
	void enterCurrent(@NotNull GrammarParser.CurrentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#current}.
	 * @param ctx the parse tree
	 */
	void exitCurrent(@NotNull GrammarParser.CurrentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#library}.
	 * @param ctx the parse tree
	 */
	void enterLibrary(@NotNull GrammarParser.LibraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#library}.
	 * @param ctx the parse tree
	 */
	void exitLibrary(@NotNull GrammarParser.LibraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#modtypeID}.
	 * @param ctx the parse tree
	 */
	void enterModtypeID(@NotNull GrammarParser.ModtypeIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#modtypeID}.
	 * @param ctx the parse tree
	 */
	void exitModtypeID(@NotNull GrammarParser.ModtypeIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#listcomp}.
	 * @param ctx the parse tree
	 */
	void enterListcomp(@NotNull GrammarParser.ListcompContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#listcomp}.
	 * @param ctx the parse tree
	 */
	void exitListcomp(@NotNull GrammarParser.ListcompContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#sim}.
	 * @param ctx the parse tree
	 */
	void enterSim(@NotNull GrammarParser.SimContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#sim}.
	 * @param ctx the parse tree
	 */
	void exitSim(@NotNull GrammarParser.SimContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newdir}.
	 * @param ctx the parse tree
	 */
	void enterNewdir(@NotNull GrammarParser.NewdirContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newdir}.
	 * @param ctx the parse tree
	 */
	void exitNewdir(@NotNull GrammarParser.NewdirContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newlib}.
	 * @param ctx the parse tree
	 */
	void enterNewlib(@NotNull GrammarParser.NewlibContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newlib}.
	 * @param ctx the parse tree
	 */
	void exitNewlib(@NotNull GrammarParser.NewlibContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newwaveAC}.
	 * @param ctx the parse tree
	 */
	void enterNewwaveAC(@NotNull GrammarParser.NewwaveACContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newwaveAC}.
	 * @param ctx the parse tree
	 */
	void exitNewwaveAC(@NotNull GrammarParser.NewwaveACContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#jfet}.
	 * @param ctx the parse tree
	 */
	void enterJfet(@NotNull GrammarParser.JfetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#jfet}.
	 * @param ctx the parse tree
	 */
	void exitJfet(@NotNull GrammarParser.JfetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(@NotNull GrammarParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(@NotNull GrammarParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#constants}.
	 * @param ctx the parse tree
	 */
	void enterConstants(@NotNull GrammarParser.ConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#constants}.
	 * @param ctx the parse tree
	 */
	void exitConstants(@NotNull GrammarParser.ConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newmod}.
	 * @param ctx the parse tree
	 */
	void enterNewmod(@NotNull GrammarParser.NewmodContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newmod}.
	 * @param ctx the parse tree
	 */
	void exitNewmod(@NotNull GrammarParser.NewmodContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#capacitance}.
	 * @param ctx the parse tree
	 */
	void enterCapacitance(@NotNull GrammarParser.CapacitanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#capacitance}.
	 * @param ctx the parse tree
	 */
	void exitCapacitance(@NotNull GrammarParser.CapacitanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newcomp}.
	 * @param ctx the parse tree
	 */
	void enterNewcomp(@NotNull GrammarParser.NewcompContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newcomp}.
	 * @param ctx the parse tree
	 */
	void exitNewcomp(@NotNull GrammarParser.NewcompContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#bjt}.
	 * @param ctx the parse tree
	 */
	void enterBjt(@NotNull GrammarParser.BjtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#bjt}.
	 * @param ctx the parse tree
	 */
	void exitBjt(@NotNull GrammarParser.BjtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#resistance}.
	 * @param ctx the parse tree
	 */
	void enterResistance(@NotNull GrammarParser.ResistanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#resistance}.
	 * @param ctx the parse tree
	 */
	void exitResistance(@NotNull GrammarParser.ResistanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#voltage}.
	 * @param ctx the parse tree
	 */
	void enterVoltage(@NotNull GrammarParser.VoltageContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#voltage}.
	 * @param ctx the parse tree
	 */
	void exitVoltage(@NotNull GrammarParser.VoltageContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNode(@NotNull GrammarParser.NodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNode(@NotNull GrammarParser.NodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#mosfet}.
	 * @param ctx the parse tree
	 */
	void enterMosfet(@NotNull GrammarParser.MosfetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#mosfet}.
	 * @param ctx the parse tree
	 */
	void exitMosfet(@NotNull GrammarParser.MosfetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#listnodes2}.
	 * @param ctx the parse tree
	 */
	void enterListnodes2(@NotNull GrammarParser.Listnodes2Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#listnodes2}.
	 * @param ctx the parse tree
	 */
	void exitListnodes2(@NotNull GrammarParser.Listnodes2Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#diode}.
	 * @param ctx the parse tree
	 */
	void enterDiode(@NotNull GrammarParser.DiodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#diode}.
	 * @param ctx the parse tree
	 */
	void exitDiode(@NotNull GrammarParser.DiodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newwaveDC}.
	 * @param ctx the parse tree
	 */
	void enterNewwaveDC(@NotNull GrammarParser.NewwaveDCContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newwaveDC}.
	 * @param ctx the parse tree
	 */
	void exitNewwaveDC(@NotNull GrammarParser.NewwaveDCContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#axiom}.
	 * @param ctx the parse tree
	 */
	void enterAxiom(@NotNull GrammarParser.AxiomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#axiom}.
	 * @param ctx the parse tree
	 */
	void exitAxiom(@NotNull GrammarParser.AxiomContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#listlib}.
	 * @param ctx the parse tree
	 */
	void enterListlib(@NotNull GrammarParser.ListlibContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#listlib}.
	 * @param ctx the parse tree
	 */
	void exitListlib(@NotNull GrammarParser.ListlibContext ctx);
}