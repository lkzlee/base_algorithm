package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 15:47
 * @desc:给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_530 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        List<Integer> rsList = new ArrayList<>();
        inOrderTree(root, rsList);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < rsList.size(); i++) {
            int deta = Math.abs(rsList.get(i) - rsList.get(i - 1));
            min = Math.min(min, deta);
        }
        return min;
    }

    private void inOrderTree(TreeNode root, List<Integer> rsList) {
        if (root == null) return;
        inOrderTree(root.left, rsList);
        rsList.add(root.val);
        inOrderTree(root.right, rsList);
    }
}
