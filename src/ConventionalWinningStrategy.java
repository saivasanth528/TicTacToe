
import entities.Board;
import entities.CellValue;

public class ConventionalWinningStrategy implements WinningStrategy {
    @Override
    public CellValue decideWinner(Board board) {
            int n = board.getSize();

            CellValue cellValue = checkHorizontal(board, n);
            if (cellValue != null) {
                return cellValue;
            }

            cellValue = checkVertical(board, n);
            if (cellValue != null) {
                return cellValue;
            }

            cellValue = checkDiagonal(board, n);
            if (cellValue != null) {
                return cellValue;
            }

            cellValue = checkAntiDiagonal(board, n);
        return cellValue;
    }

    private CellValue checkHorizontal(Board board, int n) {
        CellValue cellValue;

        for (int i = 0; i < n; i++) {
            CellValue firstCell = board.getCellValue(i, 0);
            if (firstCell == CellValue.EMPTY) {
                return null;
            }
            boolean allCellSame = true;
            for (int j = 1; j < n; j++) {
                cellValue = board.getCellValue(i, j);
                if (cellValue != firstCell) {
                    allCellSame = false;
                }
            }

            if (allCellSame) {
                // all values are same
                return firstCell;
            }
        }
        return null;
    }

    private CellValue checkVertical(Board board, int n) {
        CellValue cellValue;
        for (int j = 0; j < n; j++) {
            CellValue firstCell = board.getCellValue(0, j);
            if (firstCell == CellValue.EMPTY) {
                return null;
            }
            boolean allCellSame = true;
            for (int i = 1; i < n; i++) {
                cellValue = board.getCellValue(i, j);
                if (firstCell != cellValue) {
                    allCellSame = false;
                }
            }

            if (allCellSame) {
                return firstCell;
            }
        }
        return null;
    }

    private CellValue checkDiagonal(Board board, int  n) {
        CellValue firstCell = board.getCellValue(0, 0);
        CellValue cellValue;
        boolean allCellSame = true;
        if (firstCell == CellValue.EMPTY) {
            return null;
        }
        for (int i = 1; i < n; i++) {
            cellValue = board.getCellValue(i, i);
            if (cellValue != firstCell) {
                allCellSame = false;
                break;
            }
        }

        return allCellSame ? firstCell : null;
    }

    private CellValue checkAntiDiagonal(Board board, int n) {
        CellValue lastColFirstVal = board.getCellValue(0, n - 1);
        boolean allCellSame = true;
        CellValue cellValue;
        if (lastColFirstVal == CellValue.EMPTY) {
            return null;
        }
        int i = n - 2;
        for (int j = n - 2; j >= 0; j--) {
            cellValue = board.getCellValue(i, j);
            if (cellValue != lastColFirstVal) {
                allCellSame = false;
                break;
            }
            i++;
        }
        return allCellSame ? lastColFirstVal : null;
    }



}
