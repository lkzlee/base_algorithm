package com.lkzlee.leetcode.offer;

import java.util.Arrays;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/19 17:30
 * @desc: 地上有一个m行n列的方格，从坐标 [0, 0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionOffer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mark[i], false);
        }
        int cnt = doBackTracking(m, n, k, 0, 0, mark);
        return cnt;
    }

    private int doBackTracking(int m, int n, int k, int i, int j, boolean[][] mark) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (mark[i][j]) return 0;
        mark[i][j] = true;
        int sum = i / 100 + (i % 100) / 10 + i % 10 + j / 100 + (j % 100) / 10 + j % 10;
        if (sum > k) return 0;
        int rs = 1;
        rs += doBackTracking(m, n, k, i + 1, j, mark);
        rs += doBackTracking(m, n, k, i, j + 1, mark);
        rs += doBackTracking(m, n, k, i - 1, j, mark);
        rs += doBackTracking(m, n, k, i, j - 1, mark);
        return rs;
    }
}
