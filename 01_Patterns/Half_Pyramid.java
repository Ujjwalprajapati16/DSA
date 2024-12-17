public class Half_Pyramid {
    public static void main(String[] args) {
        int N = 4;
        for (int line = 1; line <= N; line++) {
            for (int number = 1; number <= line; number++) {
                System.out.print(number);
            }
            System.out.println();
        }
    }
}
