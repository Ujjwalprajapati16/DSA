public class Zero_One_Triangle {
    public static void main(String[] args) {
        int N = 5;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= row; col++) {
                if ((row + col) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.err.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}

/*
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
 */
