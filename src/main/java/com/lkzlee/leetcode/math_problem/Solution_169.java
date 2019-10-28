package com.lkzlee.leetcode.math_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * @author: lkzlee
 * @date: 2019-10-28 15:59
 * @desc:给定一个大小为 n 的数组，找到其中的众数。
 * 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        //数组排序，取一半位置,不过这种做法的时间复杂较高，需要进行排序，
        // 我直接用o（n）统计超过一半次数的元素即可
//        Arrays.sort(nums);
//        return nums[(nums.length - 1) / 2];
        //运行完后发现第一种还是靠谱
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if ((nums.length & 0x01) == 0 && map.get(nums[i]) >= nums.length / 2)
                return nums[i];
            if ((nums.length & 0x01) != 0 && map.get(nums[i]) >= (nums.length + 1) / 2)
                return nums[i];
        }
        return 0;*/

        //第三种算法，这个是真聪明啊
        // 摩尔投票算法是一种在线性时间O(n)和线性空间复杂度下，在一个元素序列中，查找出现次数最多的元素；
        //算法实现
        //1.定义两个变量：m存储当前变量到的元素，count为计数器，初始情况下，count=0；
        //2.依次遍历数组中的每个元素，当遍历到元素x时，
        //如果count == 0，那么m=x，然后将count=1；
        //如果count != 0，将m与x进行比较，如果相等，count++；如果不等，count--；
        //3.处理完后，最后m存储的值就是这个序列中最多的元素；
        //————————————————
        //可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(n)。
        // 可以这么理解该算法：使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不想等时，令 cnt--。
        // 如果前面查找了 i 个元素，且 cnt == 0 ，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，
        // 因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
        // 此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
        int cnt = 0, major = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                major = nums[i];
                cnt++;
            } else if (major == nums[i]) cnt++;
            else cnt--;
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int rs = new Solution_169().majorityElement(nums);
        System.out.println(rs);
    }
}
