package toxide.the.code;

public class Main {
    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] solvedTable = sudokuSolver.solveSudoku(new int[][] {
                new int[] {3, 0, 0,   0, 0, 0,   0, 0, 9},
                new int[] {0, 7, 0,   0, 4, 0,   0, 3, 0},
                new int[] {0, 0, 6,   1, 0, 3,   5, 0, 0},

                new int[] {0, 0, 7,   0, 3, 0,   8, 0, 0},
                new int[] {0, 8, 0,   2, 0, 4,   0, 1, 0},
                new int[] {0, 0, 5,   0, 7, 0,   6, 0, 0},

                new int[] {0, 0, 2,   3, 0, 7,   4, 0, 0},
                new int[] {0, 1, 0,   0, 6, 0,   0, 2, 0},
                new int[] {8, 0, 0,   0, 0, 0,   0, 0, 7},
        });

        // printing result to console
        for (int rowIndex = 0; rowIndex < solvedTable.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < solvedTable[0].length; columnIndex++) {
                if (columnIndex % 3 == 0) System.out.print("  ");
                System.out.print(solvedTable[rowIndex][columnIndex] + " ");
            }
            if ((rowIndex - 2) % 3 == 0) System.out.println();
            System.out.println();
        }
    }
}
