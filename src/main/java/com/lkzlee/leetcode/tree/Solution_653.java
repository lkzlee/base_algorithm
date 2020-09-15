package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 14:43
 * @desc:给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 *  
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_653 {
    public boolean findTarget(TreeNode root, int k) {
        //使用中序遍历得到有序数组之后，再利用双指针对数组进行查找。
        //
        //应该注意到，这一题不能用分别在左右子树两部分来处理这种思想，因为两个待求的节点可能分别在左右子树中。
        if (root == null) return false;
        List<Integer> retList = new ArrayList<>();
        inOrderTree(root, retList);
        for (int i = 0, j = retList.size()-1; i < j; ) {
            if (retList.get(i) + retList.get(j) < k) {
                i++;
            } else if (retList.get(i) + retList.get(j) > k) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inOrderTree(TreeNode root, List<Integer> retList) {
        if (root == null) return;
        inOrderTree(root.left, retList);
        retList.add(root.val);
        inOrderTree(root.right, retList);
    }


}
