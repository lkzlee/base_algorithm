package com.lkzlee.algorithm;

/***
 * @author:lkzlee
 * @date: 2018/5/8 19:39
 * @Desc:
 */
public class BinarySearch
{
	public int binarySearch(int[] arr, int target)
	{
		int l = 0, h = arr.length - 1;
		while (l <= h)
		{
			int mid = l + (h - l) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] > target)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}

	/***
	 * 例如在一个有重复元素的数组中查找 key 的最左位置的实现如下：
	 */
	public int leftBinarySearch(int[] arr, int target)
	{
		int l = 0, h = arr.length - 1;
		while (l < h)
		{
			int mid = l + (h - l) / 2;

			if (arr[mid] >= target)
				h = mid;
			else
				l = mid + 1;
		}
		return l;
	}

	public static void main(String[] args)
	{
		int index = new BinarySearch().binarySearch(new int[] { 1, 2 }, 2);
		System.out.println(index);
		index = new BinarySearch().leftBinarySearch(new int[] { 1, 1, 1, 2,2 }, 2);
		System.out.println(index);
	}

}
