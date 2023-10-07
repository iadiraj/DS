package arrays;

public class IsSorted {
    public static boolean isSorted(int[] nums){
        return isSortedHelper(nums, 0);
    }
    public static boolean isSortedHelper(int[] nums, int in){
        if(in == nums.length-1){
            return true;
        }
        return nums[in] < nums[in+1] && isSortedHelper(nums, in+1);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(isSorted(nums));
    }
}
