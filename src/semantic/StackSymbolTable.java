package semantic;

import lexical.StringTable;
import nodekind.NodeKind;
import visitor.TypeCheckerVisitor;
import nodetype.NodeType;

import javax.swing.text.html.Option;
import java.util.*;

public class StackSymbolTable extends LinkedHashMap<Integer, HashMap<Integer, SymbolTableRecord>> implements SymbolTable {

    private final Stack<Integer> scopeLevel;
    private final StringTable table;
    private static final int START = -1;
    private int currentLevel;

    public StackSymbolTable(StringTable table) {
        this.table = table;
        this.scopeLevel = new Stack();
        this.currentLevel = START;
    }

    @Override
    public void enterScope() {
        this.currentLevel++;
        this.scopeLevel.push(this.currentLevel);
        if(!this.containsKey(this.scopeLevel.peek())) {
            this.put(this.scopeLevel.peek(), new HashMap<>());
        }
    }

    @Override
    public void exitScope() {
        this.scopeLevel.pop();
    }

    @Override
    public int getScopeLevel() {
        return this.currentLevel;
    }

    @Override
    public boolean probe(String lexeme) {
        int address = this.table.getAddress(lexeme);
        return this.get(this.scopeLevel.peek()).containsKey(address);
    }

    @Override
    public Optional<SymbolTableRecord> lookup(String lexeme) {
        int address = this.table.getAddress(lexeme);
        int size = (this.scopeLevel.size() - 1);
        for (int i = size; i >= 0; i--) {
            int level = this.scopeLevel.elementAt(i);
            if (this.get(level).containsKey(address)) {
                return Optional.of(this.get(level).get(address));
            }
        }
        return Optional.empty();
    }
    public Optional<SymbolTableRecord> lookupForMoreElement(String lexeme) {
            int address = this.table.getAddress(lexeme);
            int size = (this.scopeLevel.size() -1);
            int duplicates = 0;
            for(int i = size; i >= 0; i--) {
                int level = this.scopeLevel.elementAt(i);
                if (this.get(level).containsKey(address)) {
                    duplicates++;
                }
                if(duplicates>1){
                    return Optional.of(this.get(level).get(address));
                }
            }
            return Optional.empty();
    }

    @Override
    public Optional<SymbolTableRecord> lookupKind(String lexeme, NodeKind kind) {
        int address = this.table.getAddress(lexeme);
        int size = (this.scopeLevel.size() - 1);
        for (int i = size; i >= 0; i--) {
            int level = this.scopeLevel.elementAt(i);
            if (this.get(level).containsKey(address)) {
                NodeKind nk_symbol_table = this.get(level).get(address).getKind();
                if(nk_symbol_table.equals(kind))
                    return Optional.of(this.get(level).get(address));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<SymbolTableRecord> lookupWithSetType(String lexeme, NodeType type) {
        int address = this.table.getAddress(lexeme);
        int size = (this.scopeLevel.size() - 1);
        for (int i = size; i >= 0; i--) {
            int level = this.scopeLevel.elementAt(i);
            if (this.get(level).containsKey(address)) {
                this.get(level).get(address).setNodeType(type);

                    return Optional.of(this.get(level).get(address));
            }
        }
        return Optional.empty();
    }

    @Override
    public void addEntry(String lexeme, SymbolTableRecord str) {
        int address = this.table.getAddress(lexeme);
        this.get(this.scopeLevel.peek()).put(address, str);
    }

    @Override
    public String toString() {
        StringBuilder dump = new StringBuilder();
        this.entrySet().forEach(entry -> {
            Integer level = entry.getKey();
            dump.append("Level: ").append(level).append('\n');
            Map<Integer, SymbolTableRecord> record = entry.getValue();
            record.entrySet().forEach(en -> {
                dump.append("==> ");
                dump.append("Address: ").append(en.getKey());
                dump.append("|");
                dump.append("Records(");
                dump.append(en.getValue().toString());
                dump.append(")");
                dump.append("\n");
            });
        });
        return dump.toString();
    }

    public void resetLevel () {
        this.currentLevel = START;
    }
}