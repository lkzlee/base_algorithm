package com.lkzlee.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @author:lkzlee
 * @date: 2018/9/27 16:46
 * @Desc:给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 *
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution_347
{
	public List<Integer> topKFrequent(int[] nums, int k)
	{

		/***
		 * 最最正宗的还是用桶比较靠谱，将频次作为桶的下标，数组长度为最大出现的频次，不可能超过这个值
		 * 时间复杂度为o(N)  leetcode: 28ms
		 */
		Map<Integer, Integer> frMaps = new HashMap<>();
		for (int n : nums)
		{
			frMaps.put(n, frMaps.getOrDefault(n, 0) + 1);
		}
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int t : frMaps.keySet())
		{
			int frequency = frMaps.get(t);
			if (bucket[frequency] == null)
			{
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(t);
		}
		List<Integer> topKList = new ArrayList<>();
		for (int i = bucket.length - 1; i >= 0 && topKList.size() < k; i--)
		{
			if (bucket[i] != null)
				topKList.addAll(bucket[i]);
		}
		return topKList;
		/***
		 * 我自己的实现时间复杂度是 o(N*logK),利用了快排的方式，最后发现太low，想复杂了
		 * leetcode: 33ms 与桶的使用整整差了5ms，差距啊
		 *
		 */
		//		Map<Integer, Integer> maps = new HashMap<>();
		//		for (int n : nums)
		//		{
		//			maps.put(n, maps.getOrDefault(n, 0) + 1);
		//		}
		//		int[] arr = new int[maps.keySet().size()];
		//		int len = 0;
		//		for (int t : maps.keySet())
		//		{
		//			arr[len++] = t;
		//		}
		//		List<Integer> list = quickSelectKth(arr, maps, k);
		//		return list;
	}

	private List<Integer> quickSelectKth(int[] nums, Map<Integer, Integer> maps, int k)
	{
		int low = 0, high = nums.length - 1;
		while (low < high)
		{
			int p = partionByMap(nums, maps, low, high);
			if (p == k)
				break;
			else if (p < k)
				low = p + 1;
			else
				high = p - 1;

		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++)
		{
			list.add(nums[i]);
		}
		return list;
	}

	private int partionByMap(int[] nums, Map<Integer, Integer> maps, int low, int high)
	{
		int prtVal = nums[low];
		while (low < high)
		{
			while (low < high && maps.get(nums[high]) <= maps.get(prtVal))
				high--;
			nums[low] = nums[high];
			while (low < high && maps.get(nums[low]) >= maps.get(prtVal))
				low++;
			nums[high] = nums[low];
		}
		nums[low] = prtVal;
		return low;
	}

	public static void main(String[] args)
	{
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		List<Integer> list = new Solution_347().topKFrequent(nums, 2);
		System.out.println(list);
	}
}
