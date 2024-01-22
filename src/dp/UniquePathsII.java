package dp;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return uniquePathsWithObstaclesTab(m, n, obstacleGrid, dp);
    }
    // Recursive
    public int uniquePathsWithObstaclesRec(int i, int j, int[][] obstacleGrid){
        if(i < 0 || j < 0) return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        int left = uniquePathsWithObstaclesRec(i - 1, j, obstacleGrid);
        int right = uniquePathsWithObstaclesRec(i, j - 1, obstacleGrid);
        return left + right;
    }
    // Memoization
    public int uniquePathsWithObstaclesMem(int i, int j, int[][] obstacleGrid, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int left = uniquePathsWithObstaclesRec(i - 1, j, obstacleGrid);
        int right = uniquePathsWithObstaclesRec(i, j - 1, obstacleGrid);
        dp[i][j] = left + right;
        return dp[i][j];
    }
    // Tabulation
    public int uniquePathsWithObstaclesTab(int m, int n, int[][] obstacleGrid, int[][] dp){
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0) continue;
                int left = 0;
                int right = 0;
                if(i > 0){
                    left = dp[i-1][j];
                }
                if(j > 0){
                    right = dp[i][j-1];
                }
                dp[i][j] = left + right;
            }
        }
        return dp[m-1][n-1];
    }
}
