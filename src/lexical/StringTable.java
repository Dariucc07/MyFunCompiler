package lexical;

public interface StringTable {
    boolean install(String lexeme);

    int getAddress(String lexeme);

    String getLexeme(int address);
}
