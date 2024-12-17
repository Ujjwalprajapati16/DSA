public class Character {
    public static void main(String[] args) {
        int N = 4;
        char ch = 'A';

        for (int line = 1; line <= N; line++) {
            for (int chars = 1; chars <= line; chars++) {
                System.out.print(ch++);
            }
            System.out.println();
        }
    }
}
