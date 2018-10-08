package com.lkzlee.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/8 15:30
 * @Desc:
 *
 * 假设有打乱顺序的一群人站成一个队列。
 * 每个人由一个整数对(h, k)* 表示，其中h是这个人的身高，
 * k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Solution_406
{
	public int[][] reconstructQueue(int[][] people)
	{
		/***
		 * 自己没解出这道题，很遗憾。网上这个思路很赞，比其他的都清晰
		 *
		 * 首先找到身高最高的人并对他们进行排序。
		 * 然后找到身高次高的人，按照他们的前面的人数把他们插入到最高的人群中。
		 *
		 * 因此这是一个排序和插入的过程，按照身高进行降序排序，
		 * 然后把身高相同的人按照k进行升序排序。每次取出身高相同的一组人，按照k值把他们插入到队列中。
		 */
		if (people == null || people.length <= 0)
			return people;
		Arrays.sort(people, new Comparator<int[]>()
		{
			@Override
			public int compare(int[] o1, int[] o2)
			{
				if (o1[0] != o2[0])
					return o2[0] - o1[0];
				else
					return o1[1] - o2[1];
			}
		});
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < people.length; i++)
		{
			list.add(people[i][1], people[i]);
		}
		return list.toArray(new int[list.size()][2]);
	}

	public static void main(String[] args)
	{
		int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 5, 0 }, { 6, 1 }, { 5, 2 }, { 7, 1 } };
		for (int[] t : people)
		{
			System.out.println(Arrays.toString(t));
		}
		int[][] rs = new Solution_406().reconstructQueue(people);
		System.out.println("\n");
		for (int[] t : rs)
		{
			System.out.println(Arrays.toString(t));
		}

	}
}
