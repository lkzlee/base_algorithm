package com.lkzlee.leetcode;

import com.lkzlee.algorithm.sort.QuickSort;

import java.util.Arrays;

/***
 * @author:lkzlee
 * @date: 2018/2/27 17:07
 * @Desc:
 * Wiggle Sort II
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 该题的意思是一个无序数组，处理后需要保证中间位置大于两边相邻的数
 * 思路：
 * 1.这道题比较low逼的做法是先排序，然后从中间切分两部分，前半部分和后半部分，每次取后半部分一个，前半部分一个，
 * 该算法并不能保证o(n)的时间复杂度，所以只是一个初级算法。
 */
public class Solution_324
{
	public void wiggleSort(int[] nums)
	{

		lowBiSolution(nums);
//		bstSolution(nums);

	}

	/***
	 * 这个做法有点傻逼，目前容易栈溢出
	 * @param nums
	 */
	private void bstSolution(int[] nums)
	{
		/**
		 * 先做一次 topK，找出中间的数，并且处于中间位置o(n),然后分别取前半段一个，后半段一个实现摆钟排序（这种可以采用荷兰国旗算法问题）
		 */
		int mid = (nums.length - 1) / 2;
		topK(nums, 0, nums.length - 1, mid);
		int midVal = nums[mid];
		/**
		 * 此时该数据中间位置的数 大于前半部分，小于后半部分，利用此处可以使用lowBiSolution后半部分来解答(但占用o(n)空间)，此时采用荷兰国旗变种算法来处理需要开辟新空间
		 */
		int i = 0;
		int lt = 0, gt = nums.length - 1;
		int lens = nums.length;
		while (i <= gt)
		{
			if (nums[newIndex(i, lens)] > midVal)
			{
				swap(nums, newIndex(i, lens), newIndex(lt, lens));
				i++;
				lt++;
			}
			else if (nums[newIndex(i, lens)] <= midVal)
			{
				swap(nums, newIndex(i, lens), newIndex(gt, lens));
				gt--;
			}
			else
			{
				i++;
			}
		}
	}

	private int newIndex(int i, int lens)
	{
		return (1 + 2 * i) % (lens | 1);
	}

	/***
	 * 此处会栈溢出，坑爹啊
	 * @param nums
	 * @param low
	 * @param high
	 * @param k
	 */
	private void topK(int[] nums, int low, int high, int k)
	{
		if (nums == null || nums.length <= 0)
			throw new RuntimeException("参数错误");
		if (low >= high)
			return;
		int p = partion(nums, low, high);
		if (p == k)
			return;
		if (p >= low && p < k)
		{
			topK(nums, p + 1, high, k);
		}
		else if (p <= high && p > k)
		{
			topK(nums, 0, p - 1, k);
		}
	}

	private int partion(int[] nums, int low, int high)
	{
		int privot = nums[low];
		while (low < high)
		{
			while (low < high && nums[high] > privot)
				high--;
			if (low < high)
			{
				nums[low] = nums[high];
			}
			while (low < high && nums[low] <= privot)
				low++;
			if (low < high)
			{
				nums[high] = nums[low];
			}
		}
		nums[low] = privot;
		return low;
	}

	private void swap(int[] nums, int i, int lt)
	{
		int t = nums[i];
		nums[i] = nums[lt];
		nums[lt] = t;
	}

	public void lowBiSolution(int[] nums)
	{
		QuickSort.quickSort(nums, 0, nums.length - 1);
		int mid = (nums.length - 1) / 2;
		int[] newArr = new int[nums.length];
		int k = 0;
		int i = mid, j = nums.length - 1;
		for (; i >= 0 & j > mid; i--, j--)
		{
			newArr[k++] = nums[i];
			newArr[k++] = nums[j];
		}
		if (j <= mid && i >= 0)
		{
			newArr[k] = nums[i];
		}
		else if (j > mid)
		{
			newArr[k] = nums[j];
		}
		for (i = 0; i < nums.length; i++)
		{
			nums[i] = newArr[i];
		}
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 5, 3, 8, 6, 9 };

		new Solution_324().wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
