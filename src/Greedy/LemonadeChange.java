package Greedy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill : bills) {
            if(bill == 5) {
                five += 1;
            } else if(bill == 10) {
                ten += 1;
                if(five < 1) return false;
                else five -= 1;
            }else {
                if(ten < 1) {
                    if(five < 3) return false;
                    else five -= 3;
                }else {
                    ten -= 1;
                    if(five < 1) return false;
                    else five -= 1;
                }
            }
        }
        return true;
    }
}
