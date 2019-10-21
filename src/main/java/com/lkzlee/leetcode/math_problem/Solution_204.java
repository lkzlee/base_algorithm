package com.lkzlee.leetcode.math_problem;

/***
 * @author: lkzlee
 * @date: 2019-10-21 17:20
 * @desc:
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution_204 {
    public int countPrimes(int n) {
        if (n <= 0) return 0;
        int num = 0;
        //普通做法，时间超时，不能AC，说明方法太暴力，不太对
//        for (int i = 2; i < n; i++) {
//            if (isPrime(i)) num++;
//        }
        //埃拉托斯特尼素数筛选法
        //该定理采用标记法
        //大概步骤为，第一次筛选2的倍数的数字，将其都筛选出去，
        // 第二轮筛选3的倍数的数字，筛选后，
        // 剩下的第一个数字就是5（因为4在第一次筛选的时候作为2的倍数已经筛出去）
        // 第三轮则筛选5倍数的数字，
        // 第四轮7倍数，
        // 第五轮11倍数……依次筛选下去，筛n轮。
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) num++;
            for (int j = 1; i * j < n; j++) {
                isPrime[i * j] = true;
            }
        }
        return num;
    }

    private boolean isPrime(int p) {
        for (int i = 2; i < p; i++) {
            if (p % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        int rs = new Solution_204().countPrimes(n);
        System.out.println(rs);
    }
}
