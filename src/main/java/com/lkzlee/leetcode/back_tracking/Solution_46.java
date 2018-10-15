package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/12 15:51
 * @Desc:
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution_46
{
	public List<List<Integer>> permute(int[] nums)
	{
		/***
		 * 该题全排列有好几种解决方法：
		 * 1. 全排列有顺序，依次交换 按分治法处理，第0，1...n-1每个数的交换即可
		 * 2. 回溯法，递归，组合去重(1，1，1)
		 */
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length <= 0)
			return list;
		doPermuteByDFS(nums, list, 0);
		/*List<Integer> permuteList = new ArrayList<>();
		boolean[] mark = new boolean[nums.length];
		doPermuteByBackTracking(nums, permuteList, list, mark);*/
		return list;
	}

	/***
	 * 从而可以推断，设一组数p = {r1, r2, r3, ... ,rn}, 全排列为perm(p)，
	 * pn = p - {rn}。因此
	 * perm(p) = r1perm(p1), r2perm(p2), r3perm(p3), ... , rnperm(pn)。
	 *
	 * 当n = 1时perm(p} = r1。为了更容易理解，将整组数中的所有的数分别与第一个数交换，这样就总是在处理后n-1个数的全排列。
	 ---------------------
	 * @param nums
	 * @param list
	 * @param i
	 */
	private void doPermuteByDFS(int[] nums, List<List<Integer>> list, int i)
	{
		if (i == nums.length)
		{
			List<Integer> rsList = new ArrayList<>();
			for (int t : nums)
			{
				rsList.add(t);
			}
			list.add(rsList);
			return;
		}
		for (int j = i; j < nums.length; j++)
		{
			swap(nums, i, j);
			doPermuteByDFS(nums, list, i + 1);
			swap(nums, i, j);
		}
	}

	private void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	private void doPermuteByBackTracking(int[] nums, List<Integer> permuteList, List<List<Integer>> list,
			boolean[] mark)
	{
		if (permuteList.size() == nums.length)
		{
			List<Integer> rsList = new ArrayList<>();
			rsList.addAll(permuteList);
			list.add(rsList);
			return;
		}
		for (int i = 0; i < nums.length; i++)
		{
			if (mark[i]) //组合去重，剪枝
				continue;
			permuteList.add(nums[i]);
			mark[i] = true;
			doPermuteByBackTracking(nums, permuteList, list, mark);
			mark[i] = false;
			permuteList.remove(permuteList.size() - 1);
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> rs = new Solution_46().permute(nums);
		System.out.println(rs);
	}
}
