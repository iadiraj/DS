package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumZero {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == 0){
                max = Math.max(max, i+1);
            }
            int rem = sum - 0;
            if(map.containsKey(rem)){
                max = Math.max(max, i - map.get(rem));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
    }
}
