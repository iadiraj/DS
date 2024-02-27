package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum1 {
    public static List<List<Integer>> combinationSum1(List<Integer> nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Collections.sort(nums);
        combinationSum1Helper1(nums, target, 0, ds, ans);
        return ans;
    }
//    APPROACH 1
    public static void combinationSum1Helper1(List<Integer> nums, int target, int in, List<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = in; i < nums.size(); i++){
            if(nums.get(i) > target) break;
            ds.add(nums.get(i));
            combinationSum1Helper1(nums, target-nums.get(i), i, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
//    APPROACH 2
    public static void combinationSum1Helper2(List<Integer> nums, int target, int in, List<Integer> ds, List<List<Integer>> ans){
//        base conditions
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(in >= nums.size() || target < 0) return;
//        pick
        ds.add(nums.get(in));
        combinationSum1Helper2(nums, target-nums.get(in), in, ds, ans);
//        don't pick
        ds.remove(ds.size()-1);
        combinationSum1Helper2(nums, target, in+1, ds, ans);
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
//        nums.add(3);
//        nums.add(4);
        int target = 3;
        List<List<Integer>> ans = combinationSum1(nums, target);
        System.out.println(ans);
    }
}
