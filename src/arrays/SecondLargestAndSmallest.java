package arrays;


//  Find Second Largest Element in Array | Remove duplicates from Sorted Array | Arrays Intro Video
public class SecondLargestAndSmallest {
    public static int[] getSecondOrderElements(int n, int []a) {
        int lar = getSecLargest(n, a);
        int small = getSecSmallest(n, a);
        return new int[]{lar, small};
    }
    public static int getSecLargest(int n, int[] a){
        int lar = a[0];
        int slar = Integer.MIN_VALUE;
        for(int i = 1; i < a.length; i++){
            if(a[i] > lar){
                slar = lar;
                lar = a[i];
            }else if(a[i] < lar && a[i] > slar){
                slar = a[i];
            }
        }
        return slar;
    }
    public static int getSecSmallest(int n, int[] a){
        int small = a[0];
        int sSmall = Integer.MAX_VALUE;
        for(int i = 1; i < a.length; i++){
            if(a[i] < small){
                sSmall = small;
                small = a[i];
            }else if(a[i] > small && a[i] < sSmall){
                sSmall = a[i];
            }
        }
        return sSmall;
    }
}

//  Problem Statement

//  You have been given an array ‘a’ of ‘n’ unique non-negative integers.
//  Find the second largest and second smallest element from the array.
//  Return the two elements (second largest and second smallest) as another array of size 2.

//  Example :

//  Input: ‘n’ = 5, ‘a’ = [1, 2, 3, 4, 5]
//  Output: [4, 2]
//  The second largest element after 5 is 4, and the second smallest element after 1 is 2.

//  Expected Time Complexity:
//  O(n), Where ‘n’ is the size of an input array ‘a’.

//  Constraints:

//  2 ≤ 'n' ≤ 10^5
//  0 ≤ 'a'[i] ≤ 10^9
//  Time limit: 1 sec