public class Friends_Pairing_Problem {
    public static int friendsPairing(int n) {
        // base case
        if (n == 1 || n == 2) {
            return n;
        }

        // recursive call
        int singlePair = friendsPairing(n - 1);

        int pair = (n-1) * friendsPairing(n - 2);
        int totalPair = singlePair + pair;
        return totalPair;

        // single return statement
        // return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(friendsPairing(n));

        n = 2;
        System.out.println(friendsPairing(n));

        n = 3;
        System.err.println(friendsPairing(n));
    }
}
