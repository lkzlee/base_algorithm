package com.lkzlee.leetcode;

/***
 * @author:lkzlee
 * @date: 2018/11/12 17:41
 * @Desc:
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class Solution_137
{
	public int singleNumber(int[] nums)
	{

		if (nums == null || nums.length <= 0)
			return -1;
		//		return s1(nums);
		/***
		 * 思路二：对于除出现一次之外的所有的整数，其二进制表示中每一位1出现的次数是3的整数倍，将所有这些1清零，剩下的就是最终的数。
		 * 用ones记录到当前计算的变量为止，二进制1出现“1次”（mod 3 之后的 1）的数位。
		 * 用twos记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的数位，
		 * 用threes记录到当前计算的变量为止，二进制1出现“3次”（mod 3 之后的 2）的数位。
		 * 当ones和twos中的某一位同时为1时表示二进制1出现3次，此时需要清零。
		 * 即用二进制模拟三进制计算。
		 * 最终ones记录的是最终结果。
		 */
		int ones = 0;
		int twos = 0;
		int threes = 0;
		for (int i = 0; i < nums.length; i++)
		{

			twos |= (ones & nums[i]); //二进制1出现2次的数位
			ones = ones ^ nums[i]; //二进制1出现1次的数位<
			threes = (ones & twos); //二进制1出现3次的数位
			ones &= ~(ones & threes); //清0
			twos &= ~(twos & threes);//清0

		}
		return ones;
	}

	private int s1(int[] nums)
	{
		/***
		 * 思路1：
		 * 利用位运算才有办法实现不用额外空间，就是遍历32次每次记录某位的出现的次数，
		 * 如果不能被三整除，说明那个出现一次的就在该位有值，那么ans 或该位一下就可以了。
		 */
		int rs = 0;
		for (int i = 0; i < 32; i++)
		{
			int cnt = 0;
			int bits = (1 << i);
			for (int j = 0; j < nums.length; j++)
			{
				if ((nums[j] & bits) != 0)
					cnt++;
			}
			if (cnt % 3 != 0)
			{
				rs = (rs | bits);
			}

		}
		return rs;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 2, 2, 3, 2 };
		int rs = new Solution_137().singleNumber(nums);
		System.out.println(rs);
	}
}
