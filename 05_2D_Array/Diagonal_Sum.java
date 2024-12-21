public class Diagonal_Sum {
    public static int diagonalSum(int[][] matrix) { //  Brute force O(n^2)
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                // primary diagonal
                if(i == j) {
                    sum += matrix[i][j];
                }

                // secondary diagonal
                if(i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int DiagonalSum(int[][] matrix) { // O(n)
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            // primary daigonal
            sum += matrix[i][i];

            // secondary diagonal
            if(i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        int result = diagonalSum(matrix);
        System.out.println("Diagonal sum: " + result);

        result = DiagonalSum(matrix);
        System.out.println("Diagonal sum: " + result);

        matrix = new int[][] { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        result = DiagonalSum(matrix);
        System.out.println("Diagonal sum: " + result);
    }
}
