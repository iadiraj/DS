package arrays;

public class MaxProductSubarray {
    public int maxProduct(int[] arr) {
        int pre = 1;
        int suf = 1;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(pre == 0) pre = 1;
            pre *= arr[i];
            max = Math.max(max, pre);
        }
        for(int i = n-1; i >= 0; i--){
            if(suf == 0) suf = 1;
            suf *= arr[i];
            max = Math.max(max, suf);
        }
        return max;
    }
}
