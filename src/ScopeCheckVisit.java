import java_cup.runtime.ComplexSymbolFactory;
import lexical.ArrayStringTable;
import lexical.StringTable;
import org.w3c.dom.Document;
import semantic.StackSymbolTable;
import syntax.Program;
import template.XMLTemplate;
import visitor.ConcreteXMLVisitor;
import visitor.ScopeCheckerVisitor;

/**
 * XMLVisit
 */
public class ScopeCheckVisit {

    static Lexer lexer;
    static Parser parser;



    public static void main(String[] args) throws Exception {
        StringTable stringTable = new ArrayStringTable();
        StackSymbolTable symbolTable = new StackSymbolTable(stringTable);
        ComplexSymbolFactory complexSymbolFactory = new ComplexSymbolFactory();
        lexer = new Lexer(stringTable,complexSymbolFactory);

        if(lexer.initialize(args[0])) {
            System.out.println(args[0]);
            parser = new Parser(lexer);

            Program program = (Program) parser.parse().value;

            XMLTemplate xmlTemplate = new XMLTemplate();

            Document xmlDocument = xmlTemplate.create().get();

            ConcreteXMLVisitor xmlVisitor = new ConcreteXMLVisitor();

            program.accept(xmlVisitor, xmlDocument);

            xmlTemplate.write(args[0] + ".xml", xmlDocument);

            ScopeCheckerVisitor scopeVisitor = new ScopeCheckerVisitor();

            program.accept(scopeVisitor,symbolTable);
            System.out.println("Symbol table: \n" + symbolTable);
            System.out.println("Scope check Complete!");
            symbolTable.resetLevel();

        } else {
            System.out.println("File not found!");
        }
    }
}