package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset2 {
    public static List<List<Integer>> subsetTwo(List<Integer> nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        subsetTwoHelper2(nums, 0, ds, ans);
        return ans;
    }
    public static void subsetTwoHelper1(List<Integer> nums, int in, List<Integer> ds, List<List<Integer>> ans){
        if(in == nums.size()){
            ans.add(new ArrayList<>(ds));
            return;
        }
//        pick
        ds.add(nums.get(in));
        subsetTwoHelper1(nums, in+1, ds, ans);
//        skip
        while(in + 1 < nums.size() && nums.get(in).equals(nums.get(in+1))) in++;
//        don't pick
        ds.remove(ds.size()-1);
        subsetTwoHelper1(nums, in+1, ds, ans);

    }
    public static void subsetTwoHelper2(List<Integer> nums, int in, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = in; i < nums.size(); i++){
            if(i > in && nums.get(in).equals(nums.get(i-1))) continue;
            ds.add(nums.get(i));
            subsetTwoHelper2(nums, i+1, ds, ans);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        List<List<Integer>> ans = subsetTwo(nums);
        System.out.println(ans);
    }
}
