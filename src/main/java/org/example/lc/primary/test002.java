package org.example.lc.primary;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 */
public class test002 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit3(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int length = prices.length;
        int[][] dp = new int[length][2];
        //初始条件
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候，利润才会最大
        //只需要返回 dp[length-1][0] 即可
        return dp[length - 1][0];
    }

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        //初始条件
        int hold = -prices[0]; //持有股票
        int noHold = 0; //没有持有股票
        for (int i = 1; i < length; i++) {
            //递推公式转换的
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        //最后一天肯定是手里没有股票时利润才最大
        //所以这里返回的是 noHold
        return noHold;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int total = 0, index = 0, length = prices.length;
        while (index < length) {
            //如果股票下跌就一直找，直到找到股票开始上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1])
                index++;
            //股票上涨开始的值，也就是这段时间上涨的最小值
            int min = prices[index];
            //一直找到股票上涨的最大值为止
            while (index < length - 1 && prices[index] <= prices[index + 1])
                index++;
            //计算这段上涨时间的差值，然后累加
            total += prices[index++] - min;
        }
        return total;
    }

    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
