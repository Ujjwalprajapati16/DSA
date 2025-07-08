import java.util.Arrays;
import java.util.HashSet;

public class Longest_Increasing_Subsequence {
    public static int lis(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        int[] sortedArray = new int[set.size()];
        int i = 0;
        for(int num : set) {
            sortedArray[i] = num;
            i++;
        }

        Arrays.sort(sortedArray);
        return lcs(arr, sortedArray);
    }

    public static int lcs(int arr1[], int arr2[]) {
        int dp[][] = new int[arr1.length + 1][arr2.length + 1];
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(arr));
    }
}
