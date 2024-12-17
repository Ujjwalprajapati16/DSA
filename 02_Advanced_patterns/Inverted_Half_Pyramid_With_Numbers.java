public class Inverted_Half_Pyramid_With_Numbers {
    public static void main(String[] args) {
        int N = 5;

        for (int line = 1; line <= N; line++) {
            for (int num = 1; num <= N - line + 1; num++) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
