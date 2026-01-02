package entities;

public enum CellValue {
    EMPTY(' '),
    X('X'),
    O('O');

    private final char symbol;

    CellValue(char symbol) {
        this.symbol = symbol;
    }

    public char toChar() {
        return this.symbol;
    }
}
