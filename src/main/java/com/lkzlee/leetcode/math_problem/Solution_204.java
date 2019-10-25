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

    //最大公约数
    //对于最大公约数问题，因为需要计算 a % b ，而这个操作是比较耗时的，可以使用 编程之美：2.7 的方法，利用减法和移位操作来替换它。
    //
    //对于 a 和 b 的最大公约数 f(a, b)，有：
    //
    //1. 如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
    //2. 如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
    //3. 如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
    //4. 如果 a 和 b 均为奇数，f(a, b) = f(a, a-b);
    //
    //乘 2 和除 2 都可以转换为移位操作。
    public int gcd(int m, int n) {
        if (n == 0) return m;
        //return gcd(n, m % n);
        boolean isOddm = (m & 0x01) == 0;
        boolean isOddn = (n & 0x01) == 0;
        if (isOddm && isOddn) return 2 * gcd(m >> 1, n >> 1);
        if (isOddm && !isOddn) return gcd(m >> 1, n);
        if (!isOddm && isOddn) return gcd(m, n >> 1);
        return gcd(m, m - n);
    }

    //最小公倍数
    public int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }

    //
    public static void main(String[] args) {
        int n = 10;
        int rs = new Solution_204().countPrimes(n);
        System.out.println(rs);
        int gct = new Solution_204().gcd(4, 6);
        System.out.println(gct);
    }
}
