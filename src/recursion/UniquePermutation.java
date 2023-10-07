package recursion;

import java.util.*;

public class UniquePermutation {
    public static List<List<Integer>> uniquePermutation(List<Integer> nums){
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ds = new ArrayList<>();
        for(Integer n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        uPermutationHelper1(ds, ans, map); // APPROACH 1
        uPermutationHelper2(nums, 0, ans); // APPROACH 2
        return ans;
    }
//    APPROACH 1
    public static void uPermutationHelper1(List<Integer> ds, List<List<Integer>> ans, Map<Integer, Integer> map){
//        TO STORE DECISION WHETHER ALL VALUE IN MAP IS ZERO.
        boolean allUsed = true;
//        TO CHECK WHETHER ALL VALUE IN MAP IS ZERO
        for (int value : map.values()) {
            if (value != 0) {
                allUsed = false;
                break;
            }
        }
//        TO CHECK IF DECISION IS TRUE OF FALSE
//        BASE CONDITION
        if (allUsed) {
            ans.add(new ArrayList<>(ds));
            return;
        }
//        BACKTRACKING
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if(m.getValue() == 0) continue;
            ds.add(m.getKey());
            map.put(m.getKey(), m.getValue()-1);
            uPermutationHelper1(ds, ans, map);
            ds.remove(ds.size()-1);
            map.put(m.getKey(), m.getValue()+1);
        }
    }
//    APPROACH 2
public static void uPermutationHelper2(List<Integer> nums, int in, List<List<Integer>> ans){
    if(in >= nums.size()){
        ans.add(new ArrayList<>(nums));
        return;
    }
    Set<Integer> set = new HashSet<>();
    for(int i = in; i < nums.size(); i++){
        if(set.contains(nums.get(i))) continue;
        set.add(nums.get(i));
        Collections.swap(nums, in, i);
        uPermutationHelper2(nums, in+1, ans);
        Collections.swap(nums, in, i);
    }
}
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        List<List<Integer>> ans = uniquePermutation(nums);
        System.out.println(ans);
    }
}
