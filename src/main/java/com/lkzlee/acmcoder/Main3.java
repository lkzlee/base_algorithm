package com.lkzlee.acmcoder;

import java.util.Scanner;

/***
 * @author: lkzlee
 * @date: 2020-10-22 14:40
 * @desc:临时换人
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 因为某些原因，Jack和Rose没有办法参加毕业演出，他们两个的工作任务都将由劳模Tom来代替。
 *
 * 现在需要更新演职人员名单，将所有的Jack和Rose替换成Tom【注意：字母区分大小写，即需要完全符合才能替换】。
 *
 * 请你编写一段程序实现人员替换功能。
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 输入一个字符串（可能有空格,字符串长度<=1e5），包含若干Jack和Rose。
 *
 * 输出描述
 * 输出替换之后的字符串。
 *
 *
 * 样例输入
 * Cameraman: Jack, Lighting engineer: Rose.
 * 样例输出
 * Cameraman: Tom, Lighting engineer: Tom.
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String m = s.nextLine();
            m = m.replaceAll("Jack", "Tom");
            m = m.replaceAll("Rose", "Tom");
            System.out.println(m);
        }
    }

}
