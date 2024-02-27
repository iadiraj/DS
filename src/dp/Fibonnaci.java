package dp;

public class Fibonnaci {
    // memoization
    public static int fibonacciMem(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = fibonacciTab(n-1, dp) + fibonacciTab(n-2, dp);
        return dp[n];
    }
    // tabulation
    public static int fibonacciTab(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            i++;
        }
        return dp[n];
    }
    // space optimization
    public static int fibonacciOpt(int n){
        int prev = 1;
        int prev2 = 0;
        for(int i = 2; i <= n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
