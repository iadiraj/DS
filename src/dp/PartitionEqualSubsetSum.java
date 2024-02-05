package dp;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum%2 != 0) return false;
        return canPartition(nums, sum/2);
    }
    public boolean canPartition(int[] arr, int k){
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
