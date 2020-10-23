package com.lkzlee.acmcoder;

import java.util.Scanner;

/***
 * @author: lkzlee
 * @date: 2020-10-22 14:40
 * @desc:
 * 最长重复AB串
 * 时间限制： 4000MS
 * 内存限制： 589824KB
 * 题目描述：
 * X星人最近发明了一种暗语，在这套暗语中只包含两种字符A和B。
 *
 * 暗语中的“AB”串据说表示心情好，“AB”串连续重复次数越多表示X星人越开心。
 *
 * 现在给你一串X星人的暗语，请计算最长连续重复AB串的长度。
 *
 * 例如暗语“ABBABABABBAAB”中最长连续重复AB串的长度为6，即第4个到第9个字符。
 *
 *
 *
 * 输入描述
 * 单组输入，输入数据占1行，包含一串X星人的暗语，其长度不超过100000个字符。
 *
 * 输出描述
 * 输出占1行，包含一个整数，表示最长连续重复AB串的长度
 */
public class Main4 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String m = s.nextLine();
            int rs = doSolve(m);
            System.out.println(rs);
        }
    }

    private static int doSolve(String m) {
        if (m == null || m.length() <= 0) return 0;
        int max = 0;
        int tmp = 0;
        while (m.length() > 0) {
            if (m.startsWith("AB")) {
                m = m.substring(2);
                tmp += 2;
            } else {
                m = m.substring(1);
                tmp = 0;
            }
            if (tmp > max) max = tmp;
        }
        return max;
    }

}
