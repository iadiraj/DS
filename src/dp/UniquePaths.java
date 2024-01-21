package dp;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return uniquePathsTab(m, n, dp);
    }
    // Recursive
    public static int uniquePathsRec(int m, int n){
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;
        int left = uniquePathsRec(m-1, n);
        int right = uniquePathsRec(m, n-1);
        return left + right;
    }
    // Memoization
    public static int uniquePathsMem(int m, int n, int[][] dp){
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int left = uniquePathsRec(m-1, n);
        int right = uniquePathsRec(m, n-1);
        dp[m][n] = left + right;
        return dp[m][n];
    }
    // Tabulation
    public static int uniquePathsTab(int m, int n, int[][] dp){
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
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
