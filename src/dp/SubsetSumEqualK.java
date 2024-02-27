package dp;

public class SubsetSumEqualK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        Boolean[][] dp = new Boolean[n][k+1];
        // return subsetSumToKMem(n-1, k, dp, arr);
        return subsetSumToKTab(k, arr);

    }
    // Recursion
    public static boolean subsetSumToKRec(int i, int k, int[] arr) {
        if(k < 0) return false;
        if(k == 0) return true;
        if(i == 0) return arr[0] == k;
        boolean left = subsetSumToKRec(i - 1, k - arr[i], arr);
        boolean right = subsetSumToKRec(i - 1, k, arr);
        return left || right;
    }
    // Memoization
    public static boolean subsetSumToKMem(int i, int k, Boolean[][] dp, int[] arr) {
        if(k == 0) return true;
        if(k < 0) return false;
        if(i == 0) return arr[0] == k;
        if(dp[i][k] != null) return dp[i][k];
        return dp[i][k] = subsetSumToKMem(i-1, k-arr[i], dp, arr) || subsetSumToKMem(i-1, k, dp, arr);
    }
    // Tabulation
    public static boolean subsetSumToKTab(int k, int[] arr){
        int n = arr.length;
        boolean[][] dp = new boolean[n][k+1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= k; target++){
                boolean left = dp[i-1][target];
                boolean right = false;
                if(arr[i] <= target){
                    right = dp[i-1][target - arr[i]];
                }
                dp[i][target] = left || right;
            }
        }
        return dp[n-1][k];

    }
}
