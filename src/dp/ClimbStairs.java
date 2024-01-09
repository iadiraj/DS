package dp;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
        return climbStairsOpt(n);
    }
    // memoization
    public static int climbStairsMem(int n, int[] dp){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        dp[n] = climbStairsMem(n-1, dp) + climbStairsMem(n-2, dp);
        return dp[n];
    }
    // tabulation
    public static int climbStairsTab(int n, int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    // space optimization
    public static int climbStairsOpt(int n){
        int prev = 1;
        int prev2 = 1;
        for(int i = 2; i <= n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
