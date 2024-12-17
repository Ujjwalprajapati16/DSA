public class Inverted_rotated_half_pyramid {
    public static void main(String[] args) {
        int N = 4;
        for (int line = 1; line <= N; line++) {
            // spaces
            for (int space = 1; space <= N - line; space++) {
                System.out.print(" ");
            }
            // stars
            for (int star = 1; star <= line; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/*
        *
       **
      ***
     ****
 */