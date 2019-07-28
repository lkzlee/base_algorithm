package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/16 10:23
 * @Desc:
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Solution_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if (n <= 0)
            return list;
        List<String> tempList = new ArrayList<>();
        boolean[] mark = new boolean[n];
        doSolve(n, tempList, list, mark);
        return list;

    }

    private void doSolve(int n, List<String> tempList, List<List<String>> list, boolean[] mark) {
        if (tempList.size() == n) {
            List<String> rsList = new ArrayList<>();
            rsList.addAll(tempList);
            list.add(rsList);
            return;
        }
        //从0开始找皇后的放置位置
        for (int i = 0; i < n; i++) {
            if (mark[i])
                continue;
            //i位置放置皇后
            String genStr = genQueen(i, n);
            boolean ifSit = checkQueen(genStr, tempList);
            if (!ifSit)
                continue;
            mark[i] = true;
            tempList.add(genStr);
            doSolve(n, tempList, list, mark);
            mark[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    private boolean checkQueen(String genStr, List<String> tempList) {
        int locCols = genStr.indexOf("Q");
        int locRow = tempList.size();
        for (int i = 0; i < tempList.size(); i++) {
            int j = tempList.get(i).indexOf("Q");
			//不能在同一列，或者同一斜线上
			//同一行已经由生成皇后（genQueen）保证，不必验证
            if (locCols == j || Math.abs(locCols - j) == Math.abs(locRow - i))
                return false;
        }
        return true;
    }

    //生成皇后的位置摆放
    //i表示皇后的放置位置，n表示有几列（也代表皇后）
    private String genQueen(int i, int n) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (j != i)
                sb.append('.');
            else
                sb.append('Q');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<List<String>> rs = new Solution_51().solveNQueens(8);
        System.out.println(rs);
    }
}
