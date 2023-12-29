package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int last = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                while(last < i){
                    if(s.charAt(last) == s.charAt(i)){
                        set.remove(s.charAt(last));
                        last++;
                        break;
                    }
                    set.remove(s.charAt(last));
                    last++;
                }
            }
            set.add(s.charAt(i));
            max = Math.max(max, i - last + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("tmmzuxt"));
    }
}
