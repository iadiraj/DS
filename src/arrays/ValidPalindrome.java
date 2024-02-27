package arrays;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = trim(s);
        int start = 0;
        int end = s.length() - 1;
        System.out.println(s);
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public static String trim(String s){
        s = s.toLowerCase();
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                ans += s.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
