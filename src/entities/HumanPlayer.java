package entities;

import view.ConsoleView;

public class HumanPlayer implements Player{

    private final String name;
    private final CellValue cellValue;
    private final ConsoleView view;
    HumanPlayer(String name, CellValue cellValue, ConsoleView view) {
        this.name = name;
        this.cellValue = cellValue;
        this.view = view;
    }
    @Override
    public CellValue getSymbol() {
        return cellValue;
    }

    @Override
    public Move makeMove(Board board) {
        return view.askInput(board.getSize());
    }
}
