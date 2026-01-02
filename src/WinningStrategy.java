import entities.Board;
import entities.CellValue;

public interface WinningStrategy {
    CellValue decideWinner(Board board);
}
