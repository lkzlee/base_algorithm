package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 9:47
 * @desc:给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> retList = new ArrayList<>();
        if (root == null) return retList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int n = len;
            long sum = 0;
            while (len > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                len--;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            double avg = (double) sum / n;
            retList.add(avg);
        }
        return retList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> rs = new Solution_637().averageOfLevels(root);
        System.out.println(rs);
    }
}
