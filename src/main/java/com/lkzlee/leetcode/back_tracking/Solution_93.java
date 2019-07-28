package com.lkzlee.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author:lkzlee
 * @date: 2018/10/12 11:43
 * @Desc: 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() <= 0)
            return list;
        doRestoreIp(0, s, new StringBuilder(), list);
        return list;

    }

    private void doRestoreIp(int pointNum, String s, StringBuilder tempIp, List<String> list) {
        if (pointNum == 4 || s.length() <= 0) {
            if (pointNum == 4 && s.length() == 0)
                list.add(tempIp.toString());
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0')
                break;
            String part = s.substring(0, i + 1);
            if (Integer.parseInt(part) <= 255) {
                //首次处理ip值，不用加.
                if (tempIp.length() != 0) {
                    part = "." + part;
                }
                tempIp.append(part);
                doRestoreIp(pointNum + 1, s.substring(i + 1), tempIp, list);
                tempIp.delete(tempIp.length() - part.length(), tempIp.length());
            }
        }
    }

    public static void main(String[] args) {
        List<String> rs = new Solution_93().restoreIpAddresses("25525511135");
        System.out.println(rs);
    }
}
