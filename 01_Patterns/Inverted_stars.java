public class Inverted_stars {
    public static void main(String[] args) {
        int N = 4;
        for (int line = 1; line <= N; line++) {
            for (int star = 1; star <= N - line + 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
