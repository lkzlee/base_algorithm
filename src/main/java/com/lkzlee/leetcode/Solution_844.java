package com.lkzlee.leetcode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/19 17:18
 * @desc: 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
 * # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_844 {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) return s == t;
        if (s.length() <= 0 || t.length() <= 0) return s.equals(t);
        String ret1 = doBackspaceStr(s);
        String ret2 = doBackspaceStr(t);
        return !"".equals(ret1)&&!"".equals(ret2)&&ret1.equals(ret2);
    }

    private String doBackspaceStr(String s) {
        StringBuilder ret = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (ret.length() > 0)
                    ret.deleteCharAt(ret.length() - 1);
            } else ret.append(ch);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        boolean rs = new Solution_844().backspaceCompare(s, t);
        System.out.println(rs);
    }
}
