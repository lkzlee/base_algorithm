package com.lkzlee.leetcode.DP_problem;

import java.util.Arrays;

/***
 * @author: lkzlee
 * @date: 2019-10-21 15:36
 * @desc:
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */
public class Solution_338 {
    public int[] stupidSolve(int num) {
        if (num < 0) return null;
        if (num == 0) return new int[]{0};
        int[] rs = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            rs[i] = bitNormal(i);
        }
        return rs;
    }

    private int bitNormal(int i) {
        int rcs = 0;
        while (i > 0) {
            if ((i & 0x01) != 0) rcs++;
            i = i >> 1;
        }
        return rcs;
    }

    public int[] countBits(int num) {
        if (num < 0) return null;
        if (num == 0) return new int[]{0};
        //先用一种比较笨的办法
        // return stupidSolve(num);
        int[] rs = new int[num + 1];
        //比较聪明的做法
        //   0000    0  0
        //-------------
        //   0001    1  1
        //-------------
        //   0010    1  2
        //   0011    2  3
        //-------------
        //   0100    1  4
        //   0101    2  5
        //   0110    2  6
        //   0111    3  7
        //-------------
        //   1000    1  8
        //   1001    2  9
        //   1010    2  10
        //   1011    3  11
        //   1100    2  12
        //   1101    3  13
        //   1110    3  14
        //   1111    4  15
        //找规律，以分割线为界限。比如4-7。4,5和2，3相同，但是6，7却是2，3 加 1. 而8-15也符合类似的规则。
        // 这时候需要找规律并写下推导方程式。
        //  dp[0]=0
        //  dp[1]=dp[0]+1

        //  dp[2]=dp[1]
        //  dp[3]=dp[1]+1

        //  dp[4]=dp[2]+0
        //  dp[5]=dp[2]+1
        //  dp[6]=dp[3]+0
        //  dp[7]=dp[3]+1

        //所以公式为：f[i]=f[i>>1]+(i&0x01)

        for (int i = 1; i <= num; i++) {
            //这里有坑，千万注意&比+号优先级低
            rs[i] = rs[i >> 1] + (i & 0x01);
        }
        return rs;
    }

    public static void main(String[] args) {
        int num = 5;
        int[] rs = new Solution_338().countBits(num);
        System.out.println(Arrays.toString(rs));
    }
}
