package com.lkzlee.leetcode.math_problem;

import java.util.HashMap;
import java.util.Map;

/***
 * @author: lkzlee
 * @date: 2019-10-25 08:56
 * @desc:
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。
 * 对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 *
 * 输入:
 * 26
 *
 * 输出:
 * "1a"
 * 示例 2：
 *
 * 输入:
 * -1
 *
 * 输出:
 * "ffffffff"
 *
 */
public class Solution_405 {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        char[] dictHexMap = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        //如果为负数，则本身是补码
        //这里有右移和无符号右移区分，根据题目条件我们要计算16进制转换需要bit位上的1 所以才有无符号右移
         /*
		   >>为带符号右移，>>>为不带符号右移
		     当带符号右移（>>）时,第一位原来是什么就补什么,
		     负数原来第一位是1,右移后补1,
		     正数原来第一位0,右移补0,
		     所以带符号右移数字的符号不变;
		     但是，当不带符号右移（>>>）时,负数移动后,第一位前会补0,
		     负数就会变成一个正数
		     对于左移,无带不带符号之分,
		     不管是正数还是负数，移位后最左端都是补0,（没有带符号左移）
		 */
        while (num != 0) {
            sb.insert(0, dictHexMap[num & 0xF]);
            num = num >>> 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /*
		   >>为带符号右移，>>>为不带符号右移
		     当带符号右移（>>）时,第一位原来是什么就补什么,
		     负数原来第一位是1,右移后补1,
		     正数原来第一位0,右移补0,
		     所以带符号右移数字的符号不变;
		     但是，当不带符号右移（>>>）时,负数移动后,第一位前会补0,
		     负数就会变成一个正数
		     对于左移,无带不带符号之分,
		     不管是正数还是负数，移位后最左端都是补0,（没有带符号左移）
		 */
        byte a = -15, b = 15;
        // -15 = [1111 0001]补，右移二位，最高位由符号位填充将得到 [1111 1100]补 即 -4
        System.out.println(a >> 2); // -4
        System.out.println(a >>> 2); // -4

        // 15= [0000 1111]补，右移二位，最高位由符号位填充将得到 [0000 0011] 即 3
        System.out.println(b >> 2); // 3：
        System.out.println(b >>> 2); // -4

        String rs = new Solution_405().toHex(-1);
        System.out.println(rs);
    }
}