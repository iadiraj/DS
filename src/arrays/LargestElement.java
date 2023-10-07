package arrays;

public class LargestElement {
    public static int largestElement(int[] nums){
        return largestElementHelper(nums, 0);
    }
    public static int largestElementHelper(int[] nums, int in){
        if(in == nums.length-1){
            return nums[in];
        }
        int partialAns = largestElementHelper(nums, in+1);
        if(partialAns < nums[in]) return nums[in];
        return partialAns;

    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 7, 5, 8, 6, 9, 0};
        System.out.println(largestElement(nums));
    }
}
