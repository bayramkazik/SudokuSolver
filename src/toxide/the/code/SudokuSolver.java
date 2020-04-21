package toxide.the.code;


public class SudokuSolver {
    int boardWidth;
    int boardHeight;
    int matrixWidth;
    int matrixHeight;

    SudokuSolver(int boardWidthValue, int boardHeightValue, int matrixWidthValue, int matrixHeightValue) {
        if (boardWidthValue % matrixWidthValue != 0 || boardHeightValue % matrixHeightValue != 0) {
            throw new ArithmeticException("width and height of matrix must be multiple of width and height of board");
        }

        boardWidth = boardWidthValue;
        boardHeight = boardHeightValue;
        matrixWidth = matrixWidthValue;
        matrixHeight = matrixHeightValue;
    }

    SudokuSolver() {
        boardWidth = 9;
        boardHeight = 9;
        matrixWidth = 3;
        matrixHeight =3;
    }

    public int[][] solveSudoku(int[][] board) {
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++) {
                if (board[rowIndex][columnIndex] == 0) {
                    for (int number = 1; number < 10; number++) {
                        int[][] boardWithNewNumber = copyBoard(board);
                        boardWithNewNumber[rowIndex][columnIndex] = number;
                        if (isBoardCorrect(boardWithNewNumber, rowIndex, columnIndex)) {
                            int[][] nextBoard = solveSudoku(boardWithNewNumber);
                            if (nextBoard != null) {
                                return nextBoard;
                            }
                        }
                    }
                    return null;
                }
            }
        }
        return board;
    }

    public int[][] solveSudoku() {
        return solveSudoku(new int[boardHeight][boardWidth]);
    }

    public boolean isBoardCorrect(int[][] board, int updatedRowIndex, int updatedColumnIndex) {
        if (board == null) throw new NullPointerException();

        // checking vertically
        for (int i = 0; i < board.length; i++) {
            for (int otherI = 0; otherI < i; otherI++) {
                if (board[i][updatedColumnIndex] != 0 && board[i][updatedColumnIndex] == board[otherI][updatedColumnIndex]) {
                    return false;
                }
            }
        }
        // checking horizontally
        for (int j = 0; j < board[0].length; j++) {
            for (int otherJ = 0; otherJ < j; otherJ++) {
                if (board[updatedRowIndex][j] != 0 && board[updatedRowIndex][j] == board[updatedRowIndex][otherJ]) {
                    return false;
                }
            }
        }
        // checking matrix (default 3x3)
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                for (int otherI = 0; otherI < matrixHeight; otherI++) {
                    for (int otherJ = 0; otherJ < matrixWidth; otherJ++) {
                        if (i != otherI && j != otherJ &&
                                board[(updatedRowIndex / matrixHeight) * matrixHeight + i]
                                        [(updatedColumnIndex / matrixWidth) * matrixWidth + j] != 0 &&
                                board[(updatedRowIndex / matrixHeight) * matrixHeight + i]
                                        [(updatedColumnIndex / matrixWidth) * matrixWidth + j] ==
                                        board[(updatedRowIndex / matrixHeight) * matrixHeight + otherI]
                                                [(updatedColumnIndex / matrixWidth) * matrixWidth + otherJ]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static int[][] copyBoard(int[][] board) {
        int[][] copiedBoard = new int[board.length][board[0].length];
        for (int copiedRowIndex = 0; copiedRowIndex < copiedBoard.length; copiedRowIndex++) {
            for (int copiedColumnIndex = 0; copiedColumnIndex < copiedBoard[copiedRowIndex].length; copiedColumnIndex++) {
                copiedBoard[copiedRowIndex][copiedColumnIndex] = board[copiedRowIndex][copiedColumnIndex];
            }
        }
        return copiedBoard;
    }
}
