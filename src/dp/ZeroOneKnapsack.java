package dp;

import java.util.Arrays;

public class ZeroOneKnapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return knapsackTab(weight, value, maxWeight, n);
    }
//    Recursion
    public static int knapsackRec(int[] weight, int[] value, int maxWeight, int in){
        if(in == 0) {
            if(weight[in] <= maxWeight) return value[in];
            else return 0;
        }
        int take = Integer.MIN_VALUE;
        if(weight[in] <= maxWeight) {
            take = value[in] + knapsackRec(weight, value, maxWeight - weight[in], in - 1);
        }
        int notTake = knapsackRec(weight, value, maxWeight, in - 1);
        return Math.max(take, notTake);
    }
//    Memoization
    public static int knapsackMem(int[] weight, int[] value, int maxWeight, int in, int[][] dp){
        if(in == 0){
            if(weight[in] <= maxWeight) return value[in];
            else return 0;
        }
        if(dp[in][maxWeight] != -1) return dp[in][maxWeight];
        int take = Integer.MIN_VALUE;
        if(weight[in] <= maxWeight) {
            take = value[in] + knapsackMem(weight, value, maxWeight - weight[in], in - 1, dp);
        }
        int notTake = knapsackMem(weight, value, maxWeight, in - 1, dp);
        return dp[in][maxWeight] = Math.max(take, notTake);
    }
//    Tabulation
    public static int knapsackTab(int[] weight, int[] value, int maxWeight, int n){
        int[][] dp = new int[n][maxWeight+1];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        for(int i = weight[0]; i <= maxWeight; i++){
            dp[0][i] = value[0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= maxWeight; j++){
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j) {
                    take = value[i] + dp[i-1][j - weight[i]];
                }
                int notTake = dp[i - 1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n-1][maxWeight];
    }
}
