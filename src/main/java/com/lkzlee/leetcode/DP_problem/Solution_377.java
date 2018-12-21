package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/12/20 15:22
 * @Desc:
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 * 进阶：
 * 如果给定的数组中含有负数会怎么样？
 * 问题会产生什么变化？
 * 我们需要在题目中添加什么限制来允许负数的出现？
 */
public class Solution_377
{
	public int combinationSum4(int[] nums, int target)
	{
		if (target == 0 || nums == null || nums.length <= 0)
			return 0;
		/***
		 * 这个题还是想不明白，先用回溯法暴力破解，后续在考虑完全背包的问题（完全背包一开始写的有问题）,
		 * 妈蛋这题用暴力破解法容易TLE，所以还是用动态规划，完全背包的思想吧
		 */
		//		int rs = doCombination(nums, target);
		//		return rs;
		/***
		 * dp[i][j]表示前i个元素值为j的数组的的最大组合个数
		 */
		int[][] dp = new int[nums.length + 1][target + 1];
		//		dp[0][0] = 0;
		for (int i = 1; i <= nums.length; i++)
		{
			int w = nums[i - 1];
			for (int j = 1; j <= target; j++)
			{
				for (int k = 1; k * w <= j; k++)
				{
					dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i - 1][j - k * w] + 1));
				}
			}
		}
		return dp[nums.length][target];
	}

	private int doCombination(int[] nums, int target)
	{
		if (target <= 0)
		{
			if (target == 0)
				return 1;
			else
				return 0;
		}
		int rs = 0;
		for (int i = 0; i < nums.length; i++)
		{
			rs += doCombination(nums, target - nums[i]);
		}
		return rs;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 2, 3 };
		int target = 32;
		int rs = new Solution_377().combinationSum4(nums, target);
		System.out.println(rs);
	}
}
