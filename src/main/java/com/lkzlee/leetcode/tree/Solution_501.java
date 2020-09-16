package com.lkzlee.leetcode.tree;

import com.lkzlee.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/9/15 17:23
 * @desc:给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_501 {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        //最笨的办法，中序遍历得到数组然后找
        List<Integer> rsList = new ArrayList<>();
        inOrderTree(root, rsList);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rsList.size(); i++) {
            map.put(rsList.get(i), map.getOrDefault(rsList.get(i), 0) + 1);
        }
        List<Integer> retList = new ArrayList<>();
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> k : map.entrySet()) {
            if (maxCnt < k.getValue()) maxCnt = k.getValue();
        }
        for (Map.Entry<Integer, Integer> k : map.entrySet()) {
            if (maxCnt == k.getValue()) retList.add(k.getKey());
        }
        int[] ret = new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }

    private void inOrderTree(TreeNode root, List<Integer> rsList) {
        if (root == null) return;
        inOrderTree(root.left, rsList);
        rsList.add(root.val);
        inOrderTree(root.right, rsList);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(2);
        t.right = new TreeNode(5);
        int[] ret = new Solution_501().findMode(t);
        System.out.println(Arrays.toString(ret));
    }
}
