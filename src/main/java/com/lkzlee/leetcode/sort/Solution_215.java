package com.lkzlee.leetcode.sort;

import java.util.PriorityQueue;

/***
 * @author:lkzlee
 * @date: 2018/9/27 15:40
 * @Desc:在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Solution_215
{
	public int findKthLargest(int[] nums, int k)
	{
		/***
		 * 最简单的处理思路排序 o(N*logN) 空间复杂度o(1)
		 */
		/*Arrays.sort(nums);
		return nums[nums.length - k];*/

		/***
		 * 堆排序 时间复杂度o(N*logK) 空间复杂度 o(k)
		 */
		//		return topKHeap(nums, k);

		/***
		 * 快速选择，时间复杂度 o(N) 空间复杂度 o(1)
		 */
		return quickFindKth(nums, k-1);
	}

	private int quickFindKth(int[] nums, int k)
	{
		/***
		 * 用partion函数，如果位置是k则找到了
		 */
		int low = 0, high = nums.length - 1;
		while (low < high)
		{
			int p = partion(nums, low, high);
			if (p == k)
				break;
			else if (p < k)
				low = p + 1;
			else
				high = p - 1;

		}
		return nums[k];
	}

	private int partion(int[] nums, int low, int high)
	{
		int partVal = nums[low];
		while (low < high)
		{
			while (low < high && nums[high] <= partVal)
				high--;
			nums[low] = nums[high];
			while (low < high && nums[low] >= partVal)
				low++;
			nums[high] = nums[low];
		}
		nums[low] = partVal;
		return low;
	}

	private void swap(int[] num, int i, int j)
	{
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	public int topKHeap(int[] nums, int k)
	{
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int t : nums)
		{
			heap.add(t);
			if (heap.size() > k)
				heap.poll();
		}
		return heap.poll();
	}
}
