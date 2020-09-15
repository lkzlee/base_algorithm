package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 14:20
 * @desc:给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (root == null) return retList;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);

        //先序遍历，然后进行root-->right--left压栈，之后stakc2就是后续遍历了
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            retList.add(stack2.pop().val);
        }
        return retList;
    }
}
