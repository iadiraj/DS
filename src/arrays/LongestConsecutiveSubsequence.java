package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]-1)) continue;
            int t = nums[i];
            while(set.contains(t)){
                count++;
                max = Math.max(count, max);
                t++;
            }
            count = 0;
        }
        return max;
    }
}
