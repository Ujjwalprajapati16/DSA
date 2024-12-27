public class Increasing_Order {
    public static void printIncreasing(int n) {
        // base case
        if (n == 0) {
            return;
        }

        // inner call
        printIncreasing(n - 1);

        // work
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        printIncreasing(n);
    }
}
