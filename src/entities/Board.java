package entities;

import java.util.Stack;

public class Board {
    private final int n;
    private final CellValue[][] cells;
    private Stack<HistoryEntry> history = new Stack<>();

    public Board(int n) {
        if (n < 3) {
            throw new IllegalArgumentException("Board size must be at least 3");
        }
        this.n = n;
        this.cells = new CellValue[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = CellValue.EMPTY;
            }
        }
    }

    private void checkRange(int row, int col) {
        // TODO: Instead of throwing exception, we should inform to USER
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IndexOutOfBoundsException("Row and column must be in range 0 to " + (n - 1));
        }
    }

    private void applyMove(int row , int col, CellValue value) {
        checkRange(row, col);
        if (!isCellEmpty(row, col)) {
            throw new IllegalArgumentException("Cell is already occupied");
        }
        cells[row][col] = value;
        history.push(new HistoryEntry(row, col, value));
    }

    private void undo() {
        if (history.isEmpty()) {
            throw new IllegalStateException("No moves to undo");
        }
        HistoryEntry lastMove = history.pop();
        cells[lastMove.row()][lastMove.col()] = CellValue.EMPTY;
    }

    boolean isFull() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public CellValue getCellValue(int row, int col) {
        checkRange(row, col);
        return cells[row][col];
    }

    public int getSize() {
        return n;
    }


    private boolean isCellEmpty(int row, int col) {
        return cells[row][col] == CellValue.EMPTY;
    }
}
