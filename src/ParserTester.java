import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import lexical.ArrayStringTable;
import lexical.StringTable;

public class ParserTester {

    static Lexer lexer;
    static Parser parser;

    public static void main(String[] args) throws Exception {

        StringTable st = new ArrayStringTable();
        ComplexSymbolFactory csf = new ComplexSymbolFactory();

        lexer = new Lexer(st, csf);
        if(lexer.initialize(args[0])) {
            parser = new Parser(lexer);
            System.out.println("PARSING - " + args[0] );
            if(parser.parse() != null){
                System.out.println("Starting creation XML tree " + args[0] + ".xml");
                try{
                    XMLVisit.main(args);
                    System.out.println("XML SUCCESS");
                }catch(Exception e){
                    System.out.println("FAILED - Cannot create the XML tree");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("File not found!");
        }
    }
}