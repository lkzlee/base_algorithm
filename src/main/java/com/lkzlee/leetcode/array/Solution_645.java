package com.lkzlee.leetcode.array;

import java.util.Arrays;

/***
 *集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_645 {
    public int[] findErrorNums(int[] nums) {

        //笨办法，先排序，再分别找出重复的，和缺少的数
        //return snormalSolve(nums);

        //第二种思路对于遍历数组，
        // 如果第 i 位上的元素不是 i + 1 ，那么就交换第 i 位 和 nums[i] - 1 位上的元素，使得 num[i] - 1 的元素为 nums[i] ，也就是该位的元素是正确的。
        // 交换操作需要循环进行，因为一次交换没办法使得第 i 位上的元素是正确的。
        // 但是要交换的两个元素可能就是重复元素，那么循环就可能永远进行下去，终止循环的方法是加上 nums[i] != nums[nums[i] - 1 条件。
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int[] snormalSolve(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[]{};
        }
        Arrays.sort(nums);
        int[] rs = new int[2];
        int sCnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                rs[0] = nums[i];
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (sCnt == nums[i]) {
                sCnt++;
            }
        }
        rs[1] = sCnt;
        return rs;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 3, 4, 6, 5};
        int[] nums = new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9};

        int[] rs = new Solution_645().findErrorNums(nums);
        System.out.println(Arrays.toString(rs));
    }
}
