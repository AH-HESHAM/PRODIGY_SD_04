package Solver;

public class Solver {
    private int[][] board;
    private long startTime = System.currentTimeMillis();

    public Solver(int[][] board) {
        this.board = board;
    }

    public boolean solveSudoku() {
        if(System.currentTimeMillis() - startTime > 2*60*1000)
            return false;
        int[] dimentions = getNext();
        int row = dimentions[0];
        int col = dimentions[1];
        if (row == -1) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solveSudoku())
                    return true;
                else
                    board[row][col] = 0;
            }
        }

        return false;
    }

    public int[][] getAns() {
        return board;
    }

    private int[] getNext() {
        int[] ans = {-1,-1};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    int[] newAns = {i,j};
                    return newAns;
                }
            }
        }
        return ans;
    }

    private boolean isValid(int row, int col, int val) {
        for (int i = 0; i < 9; i++)
            if (i != row && board[i][col] == val)
                return false;
        for (int i = 0; i < 9; i++)
            if (i != col && board[row][i] == val)
                return false;

        int subRowStart = (row / 3) * 3;
        int subColStart = (col / 3) * 3;
        for (int i = subRowStart; i < subRowStart + 3; i++) {
            for (int j = subColStart; j < subColStart + 3; j++) {
                if (board[i][j] == val && (i != row || j != col)) {
                    return false;
                }
            }
        }
        return true;
    }

}
