package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/10/9 15:51
 * @Desc:
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution_121
{
	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length <= 0)
			return 0;
		/***
		 * 	这个题最笨的办法是双层循环搞定 ,我的办法耗时：180ms，下面的方法耗时：2ms，真实惭愧啊
		 */
		//		int maxProfit = getMaxProfit(prices);
		//		return maxProfit;

		/***
		 * 这种思路比我的方式快多了，因为股票必须先买入才能卖出
		 *
		 * 只要记录前面的最小价格，将这个最小价格作为买入价格，
		 * 然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
		 */
		int lowInPrice = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++)
		{
			if (maxProfit < prices[i] - lowInPrice)
				maxProfit = prices[i] - lowInPrice;
			if (lowInPrice > prices[i])
				lowInPrice = prices[i];
		}
		return maxProfit;
	}

	private int getMaxProfit(int[] prices)
	{
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++)
		{
			for (int j = i + 1; j < prices.length; j++)
			{
				if (maxProfit < prices[j] - prices[i])
					maxProfit = prices[j] - prices[i];
			}
		}
		return maxProfit;
	}

	public static void main(String[] args)
	{
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		int profit = new Solution_121().maxProfit(prices);
		System.out.println(profit);
	}
}
