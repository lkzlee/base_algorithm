package com.lkzlee.leetcode.DP_problem;

import java.util.Arrays;

/***
 * @author: lkzlee
 * @date: 2019-10-21 16:29
 * @desc:最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 * 说明:
 *
 * n 的取值范围是 [1, 1000] 。
 */
public class Solution_650 {

    public int minSteps(int n) {
        if (n <= 0) return 0;
        //很典型，这是一道动态规划题
        //最难的当然是写出推导公式
        //copy=1
        //paste=1
        //dp[i] 代表当前的长度为i的最小操作次数
        //dp[i]= Math.min(dp[i],dp[j]+i/j),i为j的倍数时
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        int rs = new Solution_650().minSteps(n);
        System.out.println(rs);
    }
}
