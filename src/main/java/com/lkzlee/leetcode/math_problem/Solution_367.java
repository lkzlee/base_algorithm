package com.lkzlee.leetcode.math_problem;

/***
 * @author: lkzlee
 * @date: 2019-10-28 16:17
 * @desc:给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，
 * 否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_367 {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0) return true;
        //第一种，比较笨的办法，尝试看看是否能找出num，这种提交超时了，看来常规算法不能满足要求
//        for (int i = 1; i * i <= num; i++) {
//            if (i * i == num) return true;
//        }
        //第二种算法，平方序列：1,4,9,16,.. 间隔：3,5,7,...
        //间隔为等差数列，使用这个特性可以得到从 1 开始的平方序列。
        for (int i = 1; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
        //第三种利用二分的思想，对第一种算法进行变形,麻蛋，第三种也超时了，不行了 ，还是用第二种吧
        /*int low = 0, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int trs = mid * mid;
            if (trs == num) return true;
            else if (trs < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;*/
    }

    public static void main(String[] args) {
        boolean rs = new Solution_367().isPerfectSquare(4);
        System.out.println(rs);
    }
}
