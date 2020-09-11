package com.lkzlee.leetcode.array;

/***
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_287 {
    public int findDuplicate(int[] nums) {
        // return solveBinarySearch(nums);
        //重复元素可以构造一个循环链表，寻找链表入口
        return solveLinkList(nums);
    }

    private int solveBinarySearch(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) cnt++;
            }
            if (cnt > mid) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    private int solveLinkList(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int rs = new Solution_287().findDuplicate(nums);
        System.out.println(rs);
    }
}
