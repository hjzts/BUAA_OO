import expr.Expr;
import poly.Poly;

public class Main {
    public static void main(String[] args) {
        Processer processer = new Processer();
        Definer definer = new Definer(processer.funcMap());

        Lexer lexer = new Lexer(processer.processExpr());
        Parser parser = new Parser(lexer, definer);

        Expr expr = parser.parseExpr(1);
        Poly poly = expr.toPoly();

        Optimizer optimizer = new Optimizer(poly);
        System.out.println(optimizer.toString());
    }
}
