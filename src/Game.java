import entities.Board;
import entities.CellValue;
import entities.Move;
import entities.Player;
import view.ConsoleView;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final ConsoleView consoleView;
    private final WinningStrategy winningStrategy;


    public Game(int boardSize, Player player1, Player player2, ConsoleView consoleView, WinningStrategy winningStrategy) {
        this.board = new Board(boardSize);
        this.player1 = player1;
        this.player2 = player2;
        this.consoleView = consoleView;
        this.winningStrategy = winningStrategy;
    }

    public void start() {
        Player currentPlayer = player1;
        this.consoleView.printText("Game Started");
        this.consoleView.renderBoard(board);

        while (true) {
            this.consoleView.printText("Current Player turn " + currentPlayer.getSymbol());
            Move move = currentPlayer.makeMove(board);
            try {
                board.applyMove(move.row(), move.col(), currentPlayer.getSymbol());
            } catch (IllegalArgumentException e) {
                this.consoleView.printText("Invalid move " + e.getMessage());
                continue;
            }
            this.consoleView.renderBoard(board);
            CellValue winner = winningStrategy.decideWinner(board);

            if (winner != null) {
                consoleView.printText(winner + " has won the game !!");
                break;
            }

            if (board.isFull()) {
                consoleView.printText("Its a draw");
                break;
            }
            currentPlayer = currentPlayer == player1 ? player2 : player1;

        }

        this.consoleView.printText("Game Over");



    }


}
