package com.lkzlee.leetcode.offer;

import com.lkzlee.leetcode.datastructure.TreeNode;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/9 16:46
 * @desc: 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionOffer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int[] inorder, int pre1, int in1, int in2) {
        if (in1 > in2) return null;
        if (in1 == in2) return new TreeNode(preorder[pre1]);
        TreeNode root = new TreeNode(preorder[pre1]);
        int idx = in1;
        while (idx <= in2 && inorder[idx] != preorder[pre1]) idx++;
        root.left = doBuildTree(preorder, inorder, pre1 + 1, in1, idx - 1);
        root.right = doBuildTree(preorder, inorder, pre1 + (idx - in1) + 1, idx + 1, in2);
        return root;
    }
}
