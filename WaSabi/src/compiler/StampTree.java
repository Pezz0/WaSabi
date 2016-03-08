package compiler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import grammar.*;
/**
 * Covers and prints the syntax tree.
 *
 */
public class StampTree extends GrammarBaseListener {

	/**
	 * Prints the syntax tree.
	 * @param tree The syntax tree
	 */
	static void stampTree(ParserRuleContext tree) {
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new StampTree(), tree);
	}

	/**
	 * Internal variable; stores the current level of indentation, 
	 * used to print the tree in a more ordinate manner in the console.
	 */
	private int indent = 0;

	/**
	 * Prints the indentation. It is called every time a new line is printed, to pre-append the indentation.
	 */
	private void stampIndent() {
		for (int i = 0; i < indent; ++i)
			System.out.print("|\t");
	}

	/**
	 * Prints the information of the current node to the console.
	 * @param node The node that is currently being visited in the tree
	 */
	@Override
	public void visitTerminal(TerminalNode node) {
		stampIndent();
		System.out.println(node.getText() + "\t[" + node.getSymbol().getType() + "]");

	}

	/**
	 * Prints in the console information about entering a context.
	 * @param ctx The context that has just begun.
	 */
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {

		stampIndent();
		System.out.println("Enter\t(" + ctx.getRuleIndex() + ")");
		indent++;
	}

	/**
	 * Prints in the console information about exiting a context.
	 * @param ctx The context that has just finished.
	 */
	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		indent--;

		stampIndent();
		System.out.println("Exit (" + ctx.getRuleIndex() + ")");
	}
}