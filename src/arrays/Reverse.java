package arrays;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int a, int b) {
        if (a >= b) return;  // Changed ">" to ">="
        swap(arr, a, b);
        reverse(arr, a + 1, b - 1);
    }

    public static void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
