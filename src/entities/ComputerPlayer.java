package entities;

import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    private final CellValue cellValue;
    private final String name;
    private final Random random = new Random();

    public ComputerPlayer(CellValue cellValue, String name) {
        this.cellValue = cellValue;
        this.name = name;
    }

    @Override
    public CellValue getSymbol() {
        return null;
    }

    @Override
    public Move makeMove(Board board) {
        List<Move> availableMoves = board.getAvailableMoves();
        return availableMoves.get(random.nextInt(availableMoves.size()));
    }
}
