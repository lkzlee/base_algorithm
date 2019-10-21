package com.lkzlee.leetcode.DP_problem;

/****
 * @author lkzlee
 * @date 2019-10-17 17:27
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */
public class Solution_309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) return 0;
        //思路是这样子的
        //每天可能存在三种状态：
        //hold：继续持有股票
        //sold：卖出股票
        //rest：什么都不做
        //s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
        //s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
        //s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
        int n = prices.length;
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = Math.max(s2[i - 1], s1[i - 1] + prices[i]);
        }
        return Math.max(s0[n - 1], s2[n - 1]);

    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        int rs = new Solution_309().maxProfit(prices);
        System.out.println(rs);
    }
}
