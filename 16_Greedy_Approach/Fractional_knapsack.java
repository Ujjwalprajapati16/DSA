import java.util.Arrays;
import java.util.Comparator;

public class Fractional_knapsack {
    public static double fractionalKnapsack(int W, int wt[], int val[], int n) {
        double ratio[][] = new double[n][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) wt[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;

        for (int i = n - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (wt[idx] <= capacity) {
                capacity -= wt[idx];
                finalVal += val[idx];
            } else {
                finalVal += (val[idx] * capacity) / (double) wt[idx];
                capacity = 0;
                break;
            }
        }

        return finalVal;
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 }; // profit
        int wt[] = { 10, 20, 30 }; // weight
        int W = 50; // capacity of knapsack

        double ans = fractionalKnapsack(W, wt, val, wt.length);
        System.out.println(ans);
    }
}
