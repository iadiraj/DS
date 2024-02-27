package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWIthSumK {
//    Optimal Approach ( For postive numbers, zeros and negative numbers)
    public static int getLongestSubarray(int []a, int k) {
        Map<Long, Integer> map = new HashMap<>();
        Long sum = 0L;
        int maxLen = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            Long rem = sum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(len, maxLen);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
//    Optimal Approach ( For postive numbers, zeros)
//    public static int getLongestSubarray(int[] a, int k) {
//        int maxLen = 0;
//        long sum = a[0];
//        int r = 0, l = 0;
//        int n = a.length;
//        while (r < n) {
//            while (l < r && sum > k) {
//                sum -= a[l];
//                l++;
//            }
//            if (sum == k) {
//                maxLen = Math.max(maxLen, r - l + 1);
//            }
//            r++;
//            if (r < n) {
//                sum += a[r];
//            }
//        }
//        return maxLen;
//    }
}
