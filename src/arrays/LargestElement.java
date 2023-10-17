package arrays;
//  Find Second Largest Element in Array | Remove duplicates from Sorted Array | Arrays Intro Video
public class LargestElement {
    static int largestElement(int[] arr, int n) {
        int ans = Integer.MIN_VALUE;
        for(int i : arr){
            ans = Math.max(ans, i);
        }
        return ans;
    }
}

//  Problem Statement
//  Given an array ‘arr’ of size ‘n’ find the largest element in the array.

//  Example:
//  Input: 'n' = 5, 'arr' = [1, 2, 3, 4, 5]
//  Output: 5
//  Explanation: From the array {1, 2, 3, 4, 5}, the largest element is 5.

//  Expected Time Complexity:
//  O(n), Where ‘n’ is the size of an input array ‘arr’.

//  Constraints :
//  1 <= 'n' <= 10^5
//  1 <= 'arr[i]' <= 10^9
//  Time Limit: 1 sec