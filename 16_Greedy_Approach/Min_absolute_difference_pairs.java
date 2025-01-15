import java.util.Arrays;

public class Min_absolute_difference_pairs {
    public static int minAbsoluteMinDiff(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int minDiff = 0;

        for (int i = 0; i < arr1.length; i++) {
            minDiff += Math.abs(arr1[i] - arr2[i]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3 };
        int[] arr2 = new int[] { 2, 1, 3 };

        System.out.println(minAbsoluteMinDiff(arr1, arr2));

        arr1 = new int[] { 4, 1, 8, 7 };
        arr2 = new int[] { 2, 3, 6, 5 };

        System.out.println(minAbsoluteMinDiff(arr1, arr2));
    }
}
