package org.xiao.rain.test.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * Author: xiaojl
 * Date:2022-02-23 17:48:20
 */
public class T1_TwoSum{
    public static void main(String[] args) {
        Solution solution = new T1_TwoSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums == null || nums.length < 2) {
            return null;
        }
        
        //第一种、map存值对应的索引
        //key:值  value:索引
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[] {map.get(left), i};
            }
            map.put(nums[i], i);
        }
        //第二种、暴力解法
//        for (int i = 0; i < nums.length; i++) {
//            int firstValue = nums[i];
//            for (int j = i+1; j < nums.length; j++) {
//                int second = nums[j];
//                if(firstValue + second == target) {
//                    return new int[]{firstValue, second};
//                }
//            }
//        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}




////////给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标
//。 
////
////////
//////// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
////////
//////// 你可以按任意顺序返回答案。 
////////
//////// 
////////
//////// 示例 1： 
////////
//////// 
////////输入：nums = [2,7,11,15], target = 9
////////输出：[0,1]
////////解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//////// 
////////
//////// 示例 2： 
////////
//////// 
////////输入：nums = [3,2,4], target = 6
////////输出：[1,2]
//////// 
////////
//////// 示例 3： 
////////
//////// 
////////输入：nums = [3,3], target = 6
////////输出：[0,1]
//////// 
////////
//////// 
////////
//////// 提示： 
////////
//////// 
//////// 2 <= nums.length <= 10⁴ 
//////// -10⁹ <= nums[i] <= 10⁹ 
//////// -10⁹ <= target <= 10⁹ 
//////// 只会存在一个有效答案 
//////// 
////////
//////// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//////// Related Topics 数组 哈希表 👍 13508 👎 0
//////
////
//
