package com.lkzlee.leetcode.data_structure_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * @author: lkzlee
 * @date: 2019-10-29 16:06
 * @desc:设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_155 {
    private Stack<Integer> stack = new Stack<>();
    private List<Integer> arrayList = new ArrayList<>();

    public void push(int x) {
        stack.push(x);
        int i = 0;
        for (; i < arrayList.size(); i++) {
            if (arrayList.get(i) < x) {
                break;
            }
        }
        arrayList.add(i, x);
    }

    public void pop() {
        Integer ele = stack.pop();
        arrayList.remove(ele);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return arrayList.get(arrayList.size() - 1);
    }

    public static void main(String[] args) {

    }
}
