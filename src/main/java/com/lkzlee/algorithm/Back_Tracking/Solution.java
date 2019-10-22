package com.lkzlee.algorithm.Back_Tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * @author: lkzlee
 * @date: 2019-10-22 09:07
 * @desc:
 * 破解密码的题，大概意思是：
 * 密码长度为n，每一位可能是1-4数字，至少有一对相邻数字相差3（好像是3），密码中至少包含了3种不同数字
 *
 * 求暴力破解的话，最多需要多少次尝试才能打开箱子
 */
public class Solution {

    public int solvePassword(int n) {
        if (n <= 2) return 0;
        int rs = doSolve(n, new ArrayList<Character>());
        return rs;
    }

    private int doSolve(int n, List<Character> tmpList) {
        if (n == tmpList.size()) {
            //如果校验合格，则输入合法密码的一种
            //密码条件:每一位可能是1-4数字，至少有一对相邻数字相差3（好像是3），密码中至少包含了3种不同数字
            if (isValidPassword(tmpList)) {
                return 1;
            }
            //否则不是
            return 0;
        }
        int rs = 0;
        for (int i = '1'; i <= '4'; i++) {
            tmpList.add((char) i);
            rs += doSolve(n, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
        return rs;
    }

    /***
     * 每一位可能是1-4数字，至少有一对相邻数字相差3（好像是3），密码中至少包含了3种不同数字
     * @param tmpList
     * @return
     */
    private boolean isValidPassword(List<Character> tmpList) {
        if (tmpList == null || tmpList.size() < 2) return false;
        boolean isDiff3 = false;
        Set<Character> containSet = new HashSet<Character>();
        containSet.add(tmpList.get(0));
        for (int i = 1; i < tmpList.size(); i++) {
            if (!isDiff3 && Math.abs(tmpList.get(i) - tmpList.get(i - 1)) >= 3) {
                isDiff3 = true;
            }
            if (!containSet.contains(tmpList.get(i)))
                containSet.add(tmpList.get(i));
            if (isDiff3 && containSet.size() >= 3) break;
        }
        if (isDiff3 && containSet.size() >= 3) return true;
        return false;
    }

    public static void main(String[] args) {
        int rs = new Solution().solvePassword(3);
        System.out.println(rs);
    }
}
