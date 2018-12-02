121. Best time to buy and sell stock
O(n)
Input: [7,1,5,3,6,4] 第二天买1， 第五天卖6 赚5
Output: 5

public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;//保存最低的价格
        int maxProfit =0;// answer
        for (int i = 0; i < prices.length; i++){
            lowest = Math.min(prices[i], lowest);//update 最新价格
            maxProfit = Math.max(prices[i]-lowest, maxProfit);
            //当前价格减历史最低价， 和maxprofit比较
        }
        return maxProfit;
    }
f122. Best time to buy and sell stock II   可以多次买卖 
Input: [7,1,5,3,2,4] 可以多次交易 1,5 2,4 总赚6
public int maxProfit(int[] prices) {
        int max = 0;
        int len = prices.length;
        if(len == 0) return 0;
        for (int i = 1; i < len; i++){
            if (prices[i] > prices[i-1]){
                max = max + prices[i] - prices[i-1];
            }
        }
        return max;
    }
f123. Best time to buy and sell stock III,只可以买卖两次
First assume that we have no money, so buy1 means that we have to borrow money from others, we want to borrow less so that we have to make our balance as max as we can(because this is negative).
sell1 means we decide to sell the stock, after selling it we have price[i] money and we have to give back the money we owed, so we have price[i] - |buy1| = prices[i ] + buy1, we want to make this max.
buy2 means we want to buy another stock, we already have sell1 money, so after buying stock2 we have buy2 = sell1 - price[i] money left, we want more money left, so we make it max
sell2 means we want to sell stock2, we can have price[i] money after selling it, and we have buy2 money left before, so sell2 = buy2 + prices[i], we make this max.
So sell2 is the most money we can have.

public int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}
