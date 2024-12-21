public class Serach_In_Sorted_Matrix {
    public static boolean stairCaseSearch(int[][] matrix, int key) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Element found at: (" + row + "," + col + ")");
                return true;
            }

            if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        int key = 29;
        if (stairCaseSearch(matrix, key)) {
            System.out.println("Key found");
        } else {
            System.out.println("Key not found");
        }
    }
}
