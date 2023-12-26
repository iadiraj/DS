package arrays;

public class MajorityElement {
    public static int majorityElement(int []v) {
        int curr = 0;
        int count = 0;
        for(int i = 0; i < v.length; i++){
            if(count == 0){
                curr = v[i];
                count = 1;
            }
            else if(v[i] == curr){
                count++;
            }else{
                count--;
            }
        }
        // in addition, add this to confirm that the element count is greater than size/2 ( Moore's Voting Algorithm )
        int cnt = 0;
        for(int num : v){
            if(num == curr) cnt++;
        }
        return cnt > v.length/2 ? curr : 0;
    }
}
