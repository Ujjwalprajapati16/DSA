public class Max_Subarray_Sum {
    //Brute Force O(n^3)
    public static void maxSubarraySum(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                if (max < currSum) {
                    max = currSum;
                }
            }
        }
        System.out.println("Max subarray sum is " + max);
    }

    // Prefix sum approach - O(n^2)
    public static void maxSubarraySumUsingPrefixSum(int arr[]) {
        int max = Integer.MIN_VALUE;
        int prefixSum[] = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
                if (max < currSum) {
                    max = currSum;
                }
            }
        }
        System.out.println("Max subarray sum using prefixSum is " + max);
    }

    public static void main(String[] args) {
        int arr[] = { 1, -2, 6, -1, 3 };
        maxSubarraySum(arr);
        maxSubarraySumUsingPrefixSum(arr);
    }
}
