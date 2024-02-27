package arrays;

public class isSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int ind = 0;
        for(int i = 0; i < s.length(); i++){
            ind = t.indexOf(s.charAt(i), ind);
            if(ind == -1){
                return false;
            }
            ind++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
