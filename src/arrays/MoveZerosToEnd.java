package arrays;

//  Rotate Array by K places | Union, Intersection of Sorted Arrays | Move Zeros to End | Arrays Part-2
public class MoveZerosToEnd {
    public static int[] moveZeros(int n, int []a) {
        int t = 0;
        for(int i = 0; i < n; i++){
            if(a[i] != 0){
                swap(a, i, t);
                t++;
            };
        }
        return a;
    }
    public static void swap(int[] a, int x, int y){
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
}

//  283. Move Zeroes

//  Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Note that you must do this in-place without making a copy of the array.

//  Example 1:
//  Input: nums = [0,1,0,3,12]
//  Output: [1,3,12,0,0]
//  Example 2:

//  Input: nums = [0]
//  Output: [0]

//  Constraints:
//  1 <= nums.length <= 104
//  -231 <= nums[i] <= 231 - 1