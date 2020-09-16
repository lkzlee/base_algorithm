package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 17:17
 * @desc:给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数介于 1 和 100 之间。
 * 每个节点的值介于 0 和 100 之间。
 * 给定的树为二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1038 {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        calcGreaterTree(root);
        return root;
    }

    int sum = 0;

    public void calcGreaterTree(TreeNode root) {
        if (root == null) return;
        if (root.right != null) {
            calcGreaterTree(root.right);
        }
        sum += root.val;
        root.val = sum;
        if (root.left != null) {
            calcGreaterTree(root.left);
        }
    }
}
