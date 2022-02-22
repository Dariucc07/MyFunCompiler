import java_cup.runtime.ComplexSymbolFactory;
import lexical.ArrayStringTable;
import lexical.StringTable;
import org.w3c.dom.Document;
import semantic.StackSymbolTable;
import syntax.Program;
import template.CTemplate;
import template.XMLTemplate;
import visitor.CodeCGeneratorVisitor;
import visitor.ConcreteXMLVisitor;
import visitor.ScopeCheckerVisitor;
import visitor.TypeCheckerVisitor;

public class CGeneratorTester {
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
            CTemplate cTemplate = new CTemplate();
            Document xmlDocument = xmlTemplate.create().get();
            String model = cTemplate.create().get();
            ConcreteXMLVisitor xmlVisitor = new ConcreteXMLVisitor();

            program.accept(xmlVisitor, xmlDocument);

            xmlTemplate.write(args[0] + ".xml", xmlDocument);

            ScopeCheckerVisitor scopeVisitor = new ScopeCheckerVisitor();
            TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor();
            CodeCGeneratorVisitor codeCGeneratorVisitor = new CodeCGeneratorVisitor(model);
            program.accept(scopeVisitor,symbolTable);
            System.out.println("Symbol table: \n" + symbolTable);
            System.out.println("Scope check Complete!");
            symbolTable.resetLevel();
            program.accept(typeCheckerVisitor,symbolTable);
            System.out.println("Symbol table: \n" + symbolTable);
            System.out.println("Type check Complete!");

            symbolTable.resetLevel();
            model = program.accept(codeCGeneratorVisitor, symbolTable);
            System.out.println("\nCode generation");
            System.out.println("Code Generation Symbol table: \n" + symbolTable);
            cTemplate.write(args[0], model.toString());
            System.out.println("C program created successfully!");
            symbolTable.resetLevel();
        } else {
            System.out.println("File not found!");
        }
    }
}
