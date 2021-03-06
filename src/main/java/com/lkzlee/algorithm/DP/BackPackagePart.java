package com.lkzlee.algorithm.DP;

/***
 * @author:lkzlee
 * @date: 2018/12/18 14:55
 * @Desc:部分背包问题描述： 有 N 件物品和一个容量为 C 的背包。
 * 第 i 件物品的重量是 w[i]，价值是 v[i]。求解将哪些物品装入背包可使价值总和最大。
 * 注意这里不要求把物品整个装入，可以只装入一个物品的部分。
 *
 * 解法： 部分背包问题常采用贪心算法来解决，先对每件物品计算其每单位重量价值 v[i]/w[i]，
 * 然后从具有最大单位价值的物品开始拿，然后拿第二大价值的物品，直到装满背包。
 * 按照这种贪心策略拿到的必然是价值总和最大，这个比较简单，实现代码就略去了。 贪心算法实现即可
 */
public class BackPackagePart
{
}
