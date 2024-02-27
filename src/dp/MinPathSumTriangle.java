package dp;

import java.util.Arrays;
import java.util.List;

public class MinPathSumTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return minimumTotalTab(m, triangle, dp);
    }
    public int minimumTotalRec(int i, int j, int m, List<List<Integer>> triangle){
        if(i == m - 1) return triangle.get(i).get(j);
        int down = minimumTotalRec(i+1, j, m, triangle);
        int diag = minimumTotalRec(i+1, j+1, m, triangle);
        return triangle.get(i).get(j) + Math.min(down, diag);
    }
    public int minimumTotalMem(int i, int j, int m, List<List<Integer>> triangle, int[][] dp){
        if(i == m - 1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = minimumTotalMem(i+1, j, m, triangle, dp);
        int diag = minimumTotalMem(i+1, j+1, m, triangle, dp);
        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
        return dp[i][j];
    }
    public int minimumTotalTab(int m, List<List<Integer>> triangle, int[][] dp){
        for(int t = 0; t < triangle.get(m-1).size(); t++){
            dp[m-1][t] = triangle.get(m-1).get(t);
        }
        for(int i = m-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = dp[i+1][j];
                int diag = dp[i+1][j+1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}
