package com.lkzlee.leetcode;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/11/12 18:26
 * @Desc:
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class Solution_260
{
	public int[] singleNumber(int[] nums)
	{
		if (nums == null || nums.length <= 0)
			return new int[2];
		int AOB = 0;
		for (int i = 0; i < nums.length; i++)
			AOB ^= nums[i];
		int a, b;
		int mask = 1;
		a = b = 0;
		/***
		 * 太他妈傻逼了，只要找到一位不相同的，作为分组，然后异或就可以求出对应的A、B值了。
		 */
		while ((mask & AOB) == 0)
			mask = mask << 1;
		for (int i = 0; i < nums.length; i++)
		{
			if ((nums[i] & mask) == 0)
			{
				a ^= nums[i];
			}
			else
			{
				b ^= nums[i];
			}
		}
		return new int[] { a, b };
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 2, 1, 3, 2, 5 };
		int[] rs = new Solution_260().singleNumber(nums);
		System.out.println(Arrays.toString(rs));
	}
}
