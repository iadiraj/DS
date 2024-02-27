package arrays;

import java.util.ArrayList;

//  Find Second-Largest Element in Array | Remove duplicates from Sorted Array | Arrays Intro Video
public class RemoveDuplicates {
    public static int removeDuplicates(ArrayList<Integer> arr, int n) {
        int i = 0;
        for(int j = 1; j < n; j++){
            if(!arr.get(i).equals(arr.get(j))){
                arr.set(i+1, arr.get(j));
                i++;
            }
        }
        return i+1;
    }
}

//  Problem Statement
//  You are given a sorted integer array 'arr' of size 'n'.
//  You need to remove the duplicates from the array such that each element appears only once.
//  Return the length of this new array.

//  Note:
//  Do not allocate extra space for another array. You need to do this by modifying the given input array in place with O(1) extra memory.

//  For Example:
//  'n' = 5, 'arr' = [1 2 2 2 3].
//  The new array will be [1 2 3].
//  So our answer is 3.

//  Expected Time Complexity:
//  The expected time complexity is O(n).

//  Constraints :
//  1 <= 'n' <= 10^6
//  -10^9 <= 'arr[i]' <=10^9
//  Where ‘arr[i]’ is the value of elements of the array.
//  Time limit: 1 sec