package recursion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permutation(List<Integer> nums){
        List<List<Integer>> ans = new ArrayList<>();
        permutationHelper(nums, 0, ans);
        return ans;
    }
    public static void permutationHelper(List<Integer> nums, int in, List<List<Integer>> ans){
        if(in >= nums.size()){
            ans.add(new ArrayList<>(nums));
            return;
        }
        for(int i = in; i < nums.size(); i++){
            Collections.swap(nums, in, i);
            permutationHelper(nums, in+1, ans);
            Collections.swap(nums, in, i);
        }
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        List<List<Integer>> ans = permutation(nums);
        System.out.println(ans);
    }
}
