package semantic;

import nodekind.NodeKind;
import nodetype.NodeType;

import java.util.Optional;

/**
 * SymbolTable
 */
public interface SymbolTable {

    void enterScope();

    void exitScope();

    int getScopeLevel();

    boolean probe(String lexeme);

    Optional<SymbolTableRecord> lookup(String lexeme);

    Optional<SymbolTableRecord> lookupForMoreElement(String lexeme);

    Optional<SymbolTableRecord> lookupKind(String lexeme, NodeKind kind);

    Optional<SymbolTableRecord> lookupWithSetType(String lexeme, NodeType type);

    void addEntry(String lexeme, SymbolTableRecord str);

}