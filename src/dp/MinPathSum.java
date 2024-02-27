package dp;

import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return minPathSumTab(m, n, grid, dp);
    }
    public int minPathSumRec(int i, int j, int[][] grid) {
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        int left = minPathSumRec(i-1, j, grid);
        int right = minPathSumRec(i, j-1, grid);
        return grid[i][j] + Math.min(left, right);
    }
    public int minPathSumMem(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        int left = minPathSumRec(i-1, j, grid);
        int right = minPathSumRec(i, j-1, grid);
        return dp[i][j] = grid[i][j] + Math.min(left, right);
    }
    public int minPathSumTab(int m, int n, int[][] grid, int[][] dp){
        dp[0][0] = grid[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(i > 0) {
                    left = dp[i-1][j];
                }
                if(j > 0) {
                    right = dp[i][j-1];
                }
                dp[i][j] = grid[i][j] + Math.min(left, right);
            }
        }
        return dp[m-1][n-1];
    }
}
