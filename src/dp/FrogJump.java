package dp;

import java.util.Arrays;

public class FrogJump {
    public static int frogJumpHelper(int n, int heights[]) {
        if(n == 0) return 0;
        int right = frogJumpHelper(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int left = Integer.MAX_VALUE;
        if(n > 1){
            left = frogJumpHelper(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        }
        return Math.min(right, left);
    }
    public static int frogJump(int n, int[] heights){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return frogJumpOpt(n, heights);
    }
    // memoization
    public static int frogJumpMem(int n, int[] heights, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int left = frogJumpMem(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = frogJumpMem(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
        dp[n] = Math.min(left, right);
        return dp[n];
    }
    // tabulation
    public static int frogJumpTab(int n, int[] heights, int[] dp){
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }
    // space optimization
    public static int frogJumpOpt(int n, int[] heights){
        int prev = 0;
        int prev2 = 0;
        for(int i = 1; i < n; i++){
            int left = prev + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = prev2 + Math.abs(heights[i] - heights[i-2]);
            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
