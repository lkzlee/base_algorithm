package com.lkzlee.leetcode.DP_problem;

/***
 * @author:lkzlee
 * @date: 2018/12/17 15:30
 * @Desc:
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Solution_416
{
	public boolean canPartition(int[] nums)
	{

		if (nums == null || nums.length <= 0)
			return false;
		int sum = calcSum(nums);
		if ((sum & 0x01) != 0)
			return false;
		int w = sum / 2;
		boolean[] dp = new boolean[w + 1];
		/***
		 * 切分两个元素和相等的子集，转化为对一个数组求和sum，然后sum/2=target,（和必须为偶数，否则肯定不能切分为和相等的两个子集），
		 * 求出一个子数组和为target
		 * 定义一个dp[i] 表示是否可以从数组中找到一个子数组和为i的子集。
		 *
		 * 如果一个dp[i-nums[x]]=true,那么一定可以找到dp[i]为true。
		 * 此时动态规划的转移方程变为：
		 * dp[i]=dp[i]||dp[i-nums[x]],需要注意的是：元素只能使用一次，
		 *
		 *
		 * 第二个for循环一定要从target遍历到nums[i]，
		 * 而不能反过来，想想为什么呢？因为如果我们从nums[i]遍历到target的话，
		 * 假如nums[i]=1的话，那么[1, target]中所有的dp值都是true，
		 * 因为dp[0]是true，dp[1]会或上dp[0]，为true，
		 * dp[2]会或上dp[1]，为true，依此类推，完全使我们的dp数组失效了
		 */
		dp[0] = true;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = w; j >= nums[i]; j--)
			{
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		return dp[w];

	}

	private int calcSum(int[] nums)
	{
		int sum = 0;
		for (int t : nums)
			sum += t;
		return sum;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 5, 11, 5 };
		boolean rs = new Solution_416().canPartition(nums);
		System.out.println(rs);
	}
}
