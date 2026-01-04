package view;

import entities.Board;
import entities.Move;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void renderBoard(Board board) {
        int n = board.getSize();
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board.getCellValue(i, j).toChar() + "|");
            }
            System.out.println();
        }
    }

    public Move askInput(int n) {

        while (true) {
            System.out.println("Enter the row value");
            int row = scanner.nextInt();
            System.out.println("Enter the column value");
            int col = scanner.nextInt();

            if (row < n || col < n) {
                return new Move(row, col);
            } else {
                System.out.println("Entered the invalid input, please check");
            }
        }

    }

    public void printText(String text) {
        System.out.println(text);
    }

    public int askInt(String prompt) {
        printText(prompt);
        return scanner.nextInt();
    }



}
