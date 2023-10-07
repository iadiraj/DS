package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerSet(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        powerSetHelper2(nums, 0, ans, new ArrayList<>());
        return ans;
    }
//    APPROACH 2
    public static void powerSetHelper2(int[] nums, int in, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for(int i = in; i < nums.length; i++){
            ds.add(nums[i]);
            powerSetHelper2(nums, i+1, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
//    APPROACH 3
    public static void powerSetHelper3(int[] nums, int in, List<List<Integer>> ans, List<Integer> ds){
//        base condition
        if(in >= nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
//        pick
        ds.add(nums[in]);
        powerSetHelper3(nums, in+1, ans, ds);
//        donot pick
        ds.remove(ds.size()-1);
        powerSetHelper3(nums, in+1, ans, ds);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = powerSet(nums);
        System.out.println(ans);
    }
}
