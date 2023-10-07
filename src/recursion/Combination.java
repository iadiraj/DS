package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List<List<Integer>> combination(int n, int k){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        combinationHelper2(n, k, 1, ds, ans);
        return ans;
    }
//    APPROACH 1
    public static void combinationHelper1(int n, int k, int in, List<Integer> ds, List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(in > n || k > n - in + 1) return;
//        pick
        ds.add(in);
        combinationHelper1(n, k-1, in+1, ds, ans);
//        don't pick
        ds.remove(ds.size()-1);
        combinationHelper1(n, k, in+1, ds, ans);
    }
//    APPROACH 2
    public static void combinationHelper2(int n, int k, int in, List<Integer> ds, List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = in; i <= n; i++){
            ds.add(i);
            combinationHelper2(n, k-1, i+1, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
//        nums.add(4);
        List<List<Integer>> ans = combination(n, k);
        System.out.println(ans);
    }
}
