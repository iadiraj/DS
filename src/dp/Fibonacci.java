package dp;

import java.util.Arrays;

public class Fibonacci {
    int[] dp;
    Fibonacci(int size){
        dp = new int[size+1];
        Arrays.fill(dp, -1);
    }
    public int fib(int n){
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1) return dp[n];
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci(26);
        System.out.println(fib.fib(26));
    }
}
