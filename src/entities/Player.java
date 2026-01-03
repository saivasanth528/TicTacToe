package entities;

public interface Player {
    CellValue getSymbol();
    Move makeMove(Board board);
}
