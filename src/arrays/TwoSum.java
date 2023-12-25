package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
//    Approach 1 (when need to find the index)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int req = target - nums[i];
            if(map.containsKey(req)) return new int[]{map.get(req), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
//  Approach 2 (No need to find the index)
    public static String read(int n, int []book, int target){
        Arrays.sort(book);
        int l = 0, r = book.length - 1;
        while(l < r){
            int sum = book[l] + book[r];
            if(sum == target) return "YES";
            else if(sum < target) l++;
            else r--;
        }
        return "NO";
    }
}
