package arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(nums);
            return;
        }
        for(int i = nums.length - 1; i > ind; i--){
            if(nums[i] > nums[ind]){
                swap(nums, i, ind);
                break;
            }
        }
        reverse(nums, ind+1, nums.length - 1);
    }
    public static void reverse(int[] nums){
        int i = 0, j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static void reverse(int[] nums, int i, int j){
        // int i = 0, j = nums.length - 1;
        while(i <= j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static void swap(int[] nums, int a, int b){
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
