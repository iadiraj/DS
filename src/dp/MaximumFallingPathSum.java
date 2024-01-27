package dp;

import java.util.Arrays;

public class MaximumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int m = matrix.length;
        int[][] dp = new int[m][m];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        // for(int i = 0; i < matrix.length; i++) {
        //     ans = Math.min(ans, minFallingPathSumMem(matrix.length-1, i, matrix, dp));
        // }
        // return ans;
        return minFallingPathSumTab(matrix, dp);
    }
    // Recursion
    public int minFallingPathSumRec(int i, int j, int[][] matrix) {
        if(j < 0 || j >= matrix.length ) return Integer.MAX_VALUE;
        if(i == 0) return matrix[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = -1; k < 2; k++){
            ans = Math.min(ans, minFallingPathSumRec(i-1, j+k, matrix));
        }
        return matrix[i][j] + ans;
    }
    // Memoization
    public int minFallingPathSumMem(int i, int j, int[][] matrix, int[][] dp) {
        if(j < 0 || j >= matrix.length) return Integer.MAX_VALUE;
        if(i == 0) return matrix[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = -1; k < 2; k++){
            ans = Math.min(ans, minFallingPathSumMem(i-1, j+k, matrix, dp));
        }
        return dp[i][j] = matrix[i][j] + ans;
    }
    // Tabulation
    public int minFallingPathSumTab(int[][] matrix, int[][] dp) {
        int m = matrix.length;
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int up = dp[i-1][j];
                if(j > 0) {
                    left = dp[i-1][j-1];
                }
                if(j < m-1) {
                    right = dp[i-1][j+1];
                }
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            min = Math.min(min, dp[m-1][i]);
        }
        return min;
    }
}
