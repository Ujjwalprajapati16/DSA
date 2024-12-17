public class Butterfly_pattern {
    public static void main(String[] args) {
        int N = 4;

        // 1st half
        for (int i = 1; i <= N; i++) {
            // stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces - 2 * (n - i)
            for (int j = 1; j <= 2 * (N - i); j++) {
                System.out.print(" ");
            }

            // stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2nd half
        for (int i = N; i >= 1; i--) {
            // stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces - 2 * (n - i)
            for (int j = 1; j <= 2 * (N - i); j++) {
                System.out.print(" ");
            }

            // stars - i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/*
*      *
**    **
***  ***
********
********
***  ***
**    **
*      *
 */