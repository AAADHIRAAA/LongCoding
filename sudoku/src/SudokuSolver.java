public class SudokuSolver {

        public boolean solveSudoku(int[][] board) {
            int[] emptyCell = findEmptyCell(board);
            if (emptyCell == null) {
                return true; // Puzzle solved
            }

            int row = emptyCell[0];
            int col = emptyCell[1];

            for (int num = 1; num <= 9; num++) {
                if (isValid(board, row, col, num)) {
                    board[row][col] = num;

                    if (solveSudoku(board)) {
                        return true; // Puzzle solved
                    }

                    // Backtrack
                    board[row][col] = 0;
                }
            }

            return false; // No solution found
        }

        private int[] findEmptyCell(int[][] board) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == 0) {
                        return new int[]{row, col};
                    }
                }
            }
            return null; // No empty cell found
        }

        private boolean isValid(int[][] board, int row, int col, int num) {
            // Check row and column
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == num || board[i][col] == num) {
                    return false;
                }
            }

            // Check 3x3 subgrid
            int startRow = row - row % 3;
            int startCol = col - col % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[startRow + i][startCol + j] == num) {
                        return false;
                    }
                }
            }

            return true;
        }
    }


