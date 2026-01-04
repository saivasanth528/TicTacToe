import entities.CellValue;
import entities.ComputerPlayer;
import entities.HumanPlayer;
import entities.Player;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {

        ConsoleView consoleView = new ConsoleView();
        int boardSize = consoleView.askInt("Enter the size of the board");
        Player player1 = new HumanPlayer("Vasanth", CellValue.X, consoleView);
        Player player2 = new ComputerPlayer(CellValue.O, "computer");

        Game game = new Game(boardSize, player1, player2, consoleView, new ConventionalWinningStrategy());
        game.start();
    }
}