public class Power_of_x {
    // Brute force -> O(n)
    public static int power(int x, int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        // recursive call
        return x * power(x, n - 1);
    }

    // OPTIMISED -> O(log n)
    public static int powerOp(int x, int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        // recursive call
        int halfPower = power(x, n / 2);
        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return x * halfPower * halfPower;
        }
    }

    public static void main(String[] args) {
        int x = 2, n = 10;
        System.out.println(power(x, n));
        System.out.println(powerOp(x, n));
    }
}
