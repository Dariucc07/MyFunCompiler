import java_cup.runtime.ComplexSymbolFactory;
import lexical.ArrayStringTable;
import lexical.StringTable;
import org.w3c.dom.Document;
import syntax.Program;
import template.XMLTemplate;
import visitor.ConcreteXMLVisitor;

/**
 * XMLVisit
 */
public class XMLVisit {

    static Lexer lexer;
    static Parser parser;

    public static void main(String[] args) throws Exception {
        StringTable st = new ArrayStringTable();
        ComplexSymbolFactory csf = new ComplexSymbolFactory();
        lexer = new Lexer(st, csf);

        if(lexer.initialize(args[0])) {
            System.out.println(args[0]);
            String XMLFileName = args[0].replace(".txt", ".xml");
            parser = new Parser(lexer);

            Program program = (Program) parser.parse().value;

            XMLTemplate xmlTemplate = new XMLTemplate();

            Document xmlDocument = xmlTemplate.create().get();

            ConcreteXMLVisitor xmlVisitor = new ConcreteXMLVisitor();

            program.accept(xmlVisitor, xmlDocument);

            xmlTemplate.write(XMLFileName, xmlDocument);

        } else {
            System.out.println("File not found!");
        }
    }
}