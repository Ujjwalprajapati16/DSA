public class Mountain_ranges {
    public static int mountains(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                int upstroks = dp[j];
                int downstroks = dp[i-j-1];
                dp[i] += upstroks * downstroks;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(mountains(n));
    }
}
