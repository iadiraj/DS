package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(List<Integer> nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Collections.sort(nums);
        combinationSum2Helper2(nums, target, 0, ds, ans);
        return ans;
    }
//    APPROACH 1
    public static void combinationSum2Helper1(List<Integer> nums, int target, int in, List<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(in >= nums.size() || target < 0) return;
//        pick
        ds.add(nums.get(in));
        combinationSum2Helper1(nums, target- nums.get(in), in+1, ds, ans);
//        skip the duplicates
        while(in < nums.size()-1 && nums.get(in).equals(nums.get(in+1))) in++;
//        don't pick
        ds.remove(ds.size()-1);
        combinationSum2Helper2(nums, target, in+1, ds, ans);
    }
//    APPROACH 2
    public static void combinationSum2Helper2(List<Integer> nums, int target, int in, List<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = in; i < nums.size(); i++){
            if(i > in && nums.get(i).equals(nums.get(i-1))) continue;
            if(target < nums.get(i)) break;
            ds.add(nums.get(i));
            combinationSum2Helper2(nums, target-nums.get(i), i+1, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(1);
        nums.add(2);
        nums.add(7);
        nums.add(6);
        nums.add(5);
        nums.add(1);
        int target = 8;
        List<List<Integer>> ans = combinationSum2(nums, target);
        System.out.println(ans);
    }
}
