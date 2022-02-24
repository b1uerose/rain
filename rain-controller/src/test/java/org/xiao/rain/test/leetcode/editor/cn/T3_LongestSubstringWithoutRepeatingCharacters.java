package org.xiao.rain.test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符的最长子串
 * Author: xiaojl
 * Date:2022-02-24 16:08:51
 */
public class T3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new T3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST

        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int maxLength = 0 ;
        
        for (int i = 0; i < charArray.length; i++) {
            List<Character> list = new ArrayList<Character>();
            list.add(charArray[i]);
            int curMaxlength = 1;
            int j = i + 1;
            while (j < charArray.length && !list.contains(charArray[j])) {
                list.add(charArray[j]);
                j ++;
                curMaxlength ++;
            }
            
            if(curMaxlength > maxLength) {
                maxLength = curMaxlength;
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}




//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6959 👎 0
