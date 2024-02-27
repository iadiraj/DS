package string;
public class StringContain {
    public static boolean doesContain(String a, String b){
        int i = 0;
        for(char c : b.toCharArray()){
            int f = a.indexOf(c, i);
            if(f == -1 || f < i){
                return false;
            }
            i += f+1;
        }
        return true;
    }
    public static void main(String[] args) {
        String a = "adityaraj";
        String b = "iyj";
        System.out.println(doesContain(a, b));
    }
}
