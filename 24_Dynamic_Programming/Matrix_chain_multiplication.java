public class Matrix_chain_multiplication {
    // Recursion - O(2^(n^2))
    public static int mcm(int arr[], int i, int j) {
        if(i >= j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    // Memoization - O(n^3)
    public static int mcm(int arr[], int i, int j, int dp[][]) {
        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = mcm(arr, i, k, dp);
            int cost2 = mcm(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;  
    }

    // Tabulation - O(n^3)
    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = 0;
        }

        for(int len = 2; len <= n-1; len++){
            for(int i=1; i<=n-len; i++){
                int j = i + len - 1;
                int ans = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    ans = Math.min(ans, finalCost);
                }
                dp[i][j] = ans;
            }   
        }
        
        return dp[1][n-1];
    } 

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int dp[][] = new int[arr.length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(mcm(arr, 1, arr.length-1, dp));
        System.out.println(mcmTab(arr));
    }
}
