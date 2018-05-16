package com.lkzlee.algorithm.sort;

import java.util.Arrays;

/***
 * @author lkzlee
 * 快速排序
 * 快排的平均时间复杂度为：o(N*log(N))
 * 算法思想：a1,a2,a3,a5,a6 是一个无序数组，利用分治法将问题划分为若干小问题，
 * 		     找到一个基准使得左边的小，右边的大，然后对左区间，右区间分治处理，使得整个数组有序。
 */
public class QuickSort
{
	public static void quickSort(int[] arr, int low, int high)
	{
		if (low >= high)
			return;
		int p = partionUpdate(arr, low, high);
		quickSort(arr, low, p - 1);
		quickSort(arr, p + 1, high);
	}

	/***
	 * 快速排序的核心，关键在于找出基准值，并且选用基准值必须进行调整，使得 左边小于它，右边大于它
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partionUpdate(int[] arr, int low, int high)
	{
		int x = arr[low];
		while (true)
		{
			while (low < high && arr[high] >= x)
				high--;
			arr[low] = arr[high];
			while (low < high && arr[low] < x)
				low++;
			arr[high] = arr[low];
			if (low >= high)
				break;

		}
		arr[low] = x;
		return low;
	}

	public static void main(String[] args)
	{
		int arr[] =
		{ 9, 4, 1, 4, 3, 8, 26, 9, 12, 34, 29 };
		System.out.println("排序前：" + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("排序后：" + Arrays.toString(arr));
	}
}
