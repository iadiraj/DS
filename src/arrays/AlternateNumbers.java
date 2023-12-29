package arrays;

public class AlternateNumbers {
//    Approach 1 (Using Two Pointer) When both the positive values and negative values are in equal numbers
    public static int[] alternateNumbers(int []a) {
        int[] ans = new int[a.length];
        int p = 0;
        int n = 1;
        for(int i = 0; i < a.length; i++){
            if(a[i] < 0){
                ans[n] = a[i];
                n += 2;
            }else{
                ans[p] = a[i];
                p += 2;
            }
        }
        return ans;
    }
//    Approach 2 (Using HashMap) When both the positive values and negative values are not in equal numbers
}
