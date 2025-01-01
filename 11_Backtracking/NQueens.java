
public class NQueens {
    public static void printBoard(char board[][]) {
        System.out.println("-----------Chess board-----------");
        for (char[] board1 : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board1[j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        if (row >= board.length) {
            printBoard(board);
            count++;
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        int N = 4;
        char board[][] = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 'X';
            }
        }
        // printBoard(board);
        nQueens(board, 0);

        if (count == 0) {
            System.out.println("Solution does not exist");
        } else {
            System.out.println("Total number of solutions: " + count);
        }
    }
}

/*
 * -----------Chess board-----------
 * X Q X X
 * X X X Q
 * Q X X X
 * X X Q X
 * -----------Chess board-----------
 * X X Q X
 * Q X X X
 * X X X Q
 * X Q X X
 * Total number of solutions: 2
 */