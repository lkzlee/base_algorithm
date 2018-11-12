package com.lkzlee.leetcode;

import com.lkzlee.leetcode.datastructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/11/12 19:53
 * @Desc:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution_56
{
	public List<Interval> merge(List<Interval> intervals)
	{
		List<Interval> rsList = new ArrayList<>();
		if (intervals == null || intervals.size() <= 0)
			return rsList;
		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval o1, Interval o2)
			{
				return o1.start - o2.start;
			}
		});
		Interval p = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++)
		{
			Interval tmp = intervals.get(i);
			if (p.end >= tmp.start)
			{
				p.end = Math.max(p.end, tmp.end);
			}
			else
			{
				rsList.add(p);
				p = tmp;
			}
		}
		rsList.add(p);
		return rsList;
	}
}
