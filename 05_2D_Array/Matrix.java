public class Matrix {
    public static boolean search(int[][] matrix, int key) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                if (matrix1[j] == key) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }

        int key = 5;
        if (search(matrix, key)) {
            System.out.println("Key found");
        } else {
            System.out.println("Key not found");
        }
    }

}
