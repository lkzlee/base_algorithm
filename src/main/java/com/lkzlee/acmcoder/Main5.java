package com.lkzlee.acmcoder;

import java.util.Scanner;

/***
 * @author: lkzlee
 * @date: 2020-10-22 14:40
 * @desc:
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int m = s.nextInt();
            int[] nums = new int[m];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = s.nextInt();
            }

            int ret = doSolve(nums);
            System.out.println(ret);

        }
    }

    private static int doSolve(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1])
                continue;
            cnt++;
            if (i >= 1 && nums[i - 1] > nums[i + 1])
                nums[i + 1] = nums[i];
            else
                nums[i] = nums[i + 1];
        }
        return cnt;
    }

}
