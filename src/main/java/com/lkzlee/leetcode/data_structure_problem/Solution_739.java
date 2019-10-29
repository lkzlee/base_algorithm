package com.lkzlee.leetcode.data_structure_problem;

import java.util.Arrays;
import java.util.Stack;

/***
 * @author: lkzlee
 * @date: 2019-10-29 16:46
 * @desc:根据每日 气温 列表，请重新生成一个列表，
 * 对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。
 * 每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length <= 0) return new int[]{};
        int[] ret = new int[T.length];
        //第一种思路比较笨，硬算，发现时间复杂度很高，败了，败的妥妥的
        //执行用时 :655 ms 在所有 java 提交中击败了 5.01%的用户
        //内存消耗 : 42.5 M 在所有 java 提交中击败了 94.09% 的用户
//        for (int i = 0; i < T.length; i++) {
//            int d = 0;
//            int cnt = 0;
//            for (int j = i + 1; j < T.length; j++) {
//                cnt++;
//                if (T[j] > T[i]) {
//                    d = cnt;
//                    break;
//                }
//            }
//            ret[i] = d;
//        }
        //第二种思路 采用一个栈，利用栈的特性，因为天气只能向后算，
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] rs = new Solution_739().dailyTemperatures(nums);
        System.out.println(Arrays.toString(rs));
    }
}
