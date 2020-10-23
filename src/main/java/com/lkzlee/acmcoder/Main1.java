package com.lkzlee.acmcoder;

import java.util.*;

/***
 * @author: lkzlee
 * @date: 2020-10-22 14:40
 * @desc:
 * 小明用计算机随机生成了N个正整数，他希望从这N个数中选取若干个数，使得它们的和等于M。这些随机生成的数字可能会相同，但是每个数字最多只允许使用一次。
 *
 * 当然这样的选取方案可能不存在，也可能有多个。
 *
 * 现在希望你编写一个程序，能够找出数字个数最少的选取方案，输出对应的最少数字的个数，如果无解输出“No solution”。
 *
 *
 *
 * 输入描述
 * 单组输入，每组输入2行。
 *
 * 第1行包含两个正整数N和M，分别表示初始输入的正整数个数和目标数字和(N<=1e3, M<=1e5)。
 *
 * 第2行为N个正整数，两两之间用空格隔开(每一个正整数均小于等于1e5)。
 *
 * 输出描述
 * 输出数字个数最少的选取方案中所包含的最少数字个数，如果无解输出“No solution”。
 */
public class Main1 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int m = s.nextInt();
            int n = s.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = s.nextInt();
            }
            Arrays.sort(nums);
            doSovleMin(nums, n, nums.length - 1, 0);
            if (min == Integer.MAX_VALUE)
                System.out.println("No solution");
            else
                System.out.println(min);
        }
    }

    private static boolean doSovleMin(int[] nums, int n, int start, int cnt) {
        if (n == 0) {
            min = cnt;
            return true;
        }
        if (n < 0) return false;
        for (int i = start; i >= 0; i--) {
            if (n - nums[i] < 0) continue;
            boolean end = doSovleMin(nums, n - nums[i], i - 1, cnt + 1);
            if (end) return true;
        }
        return false;
    }
}
