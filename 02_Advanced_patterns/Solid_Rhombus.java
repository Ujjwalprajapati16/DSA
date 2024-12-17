public class Solid_Rhombus {
    public static void main(String[] args) {
        int N = 5;

        for (int i = 1; i <= N; i++) {
            // spaces
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/*
    *****
   *****
  *****
 *****
*****                       
 */