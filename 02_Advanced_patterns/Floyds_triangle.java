public class Floyds_triangle {
    public static void main(String[] args) {
        int N = 5;
        int counter = 1;
        for (int line = 1; line <= N; line++) {
            for (int num = 1; num <= line; num++) {
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }
}
