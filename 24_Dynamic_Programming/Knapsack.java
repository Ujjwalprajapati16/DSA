import java.util.Arrays;

public class Knapsack {
    private static int knapsack(int[] val, int[] wt, int w, int n) { // O(2^n)
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] <= w) { // valid
            // include
            int include = val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1);
            // exclude
            int exclude = knapsack(val, wt, w, n - 1);
            return Math.max(include, exclude);
        } else {
            return knapsack(val, wt, w, n - 1);
        }
    }

    private static int knapsackMemo(int[] val, int[] wt, int w, int n, int[][] dp) { // O(n * w)
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] <= w) {
            // include
            int include = val[n - 1] + knapsackMemo(val, wt, w - wt[n - 1], n - 1, dp);
            // exclude
            int exclude = knapsackMemo(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(include, exclude);
            return dp[n][w];
        } else {
            dp[n][w] = knapsackMemo(val, wt, w, n - 1, dp);
            return dp[n][w];
        }
    }

    private static int knapsackTab(int[] val, int[] wt, int w, int n) { // O(n * w)
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][w];
    }

    private static void print(int dp[][]) {
        System.out.println("DP Array:");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(knapsack(val, wt, W, val.length));
        System.out.println(knapsackMemo(val, wt, W, val.length, dp));
        System.out.println(knapsackTab(val, wt, W, val.length));
    }

}
