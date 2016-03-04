package compiler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import grammar.*;

public class StampTree extends GrammarBaseListener {

	static void stampTree(ParserRuleContext tree) {
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new StampTree(), tree);
	}

	private int indent = 0;

	private void stampIndent() {
		for (int i = 0; i < indent; ++i)
			System.out.print("|\t");
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		stampIndent();
		System.out.println(node.getText() + "\t[" + node.getSymbol().getType() + "]");

	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {

		stampIndent();
		System.out.println("Enter\t(" + ctx.getRuleIndex() + ")");
		indent++;
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		indent--;

		stampIndent();
		System.out.println("Exit (" + ctx.getRuleIndex() + ")");
	}
}