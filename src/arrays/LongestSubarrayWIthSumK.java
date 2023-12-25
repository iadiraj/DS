package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWIthSumK {
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
}
