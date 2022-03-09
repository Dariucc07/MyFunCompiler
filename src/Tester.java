import java.io.IOException;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import lexical.ArrayStringTable;
import lexical.StringTable;

public class Tester {
    public static void main(String[] args) throws IOException {


        StringTable st = new ArrayStringTable();
        ComplexSymbolFactory csf = new ComplexSymbolFactory();

        Lexer lexicalAnalyzer = new Lexer(st, csf);
        String filePath = args[0];

        if (lexicalAnalyzer.initialize(filePath)) {
            Symbol token;
            try {
                while ((token = lexicalAnalyzer.next_token()) != null) {
                    if(token.sym == ParserSym.EOF) {
                        break;
                    }
                    String toRet = "<" +
                            ParserSym.terminalNames[token.sym] +
                            (token.value == null ? ">" : (", "+token.value+">"));
                    System.out.println(toRet);
                }
            } catch (Exception e) {
                System.out.println("File parsing ended!!");
            }

        } else {
            System.out.println("File not found!!");
        }
    }
}

