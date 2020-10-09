package com.lkzlee.leetcode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 14:36
 * @desc: 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 * <p>
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 * <p>
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 * <p>
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_693 {
    public boolean hasAlternatingBits(int n) {
        if (n <= 0) return false;
      /*  while (n > 0) {
            int a = n & 0x01;
            int b = (n >>> 1) & 0x01;
            if (a == b) return false;
            n = n >>> 1;
        }
        return true;*/
        //对于 10101 这种位级表示的数，把它向右移动 1 位得到 1010 ，这两个数每个位都不同，因此异或得到的结果为 11111。
        int ret = n ^ (n >>> 1);
        return (ret & (ret + 1)) == 0;

    }
}
