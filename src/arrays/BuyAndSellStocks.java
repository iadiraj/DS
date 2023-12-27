package arrays;

public class BuyAndSellStocks {
//    Approach 1
    public static int bestTimeToBuyAndSellStock(int []prices) {
        //
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
//    Approach 2 (Using Two Pointer Methods)
//    public static int bestTimeToBuyAndSellStock(int[] prices){
//        int left = 0;
//        int right = 1;
//        int maxProfit = 0;
//        while (right < prices.length) {
//            if (prices[left] < prices[right]) {
//                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
//            } else {
//                left = right;
//            }
//            right++;
//        }
//        return maxProfit;
//    }
}
