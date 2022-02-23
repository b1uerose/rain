package org.xiao.rain.test.leetcode.editor.cn;

/**
 * 仅反转字母
 * Author: xiaojl
 * Date:2022-02-23 17:48:49
 */
public class T917_ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new T917_ReverseOnlyLetters().new Solution();
        System.out.println(solution.reverseOnlyLetters("abc-def-ghi-jk"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            if (s == null) {
                return null;
            }
            if ("".equals(s) || s.length() == 1) {
                return s;
            }
            char[] chars = s.toCharArray();
            int length = chars.length;
            int startIndex = 0;
            int endIndex = length - 1;
            while (startIndex < endIndex) {
                char startChar = chars[startIndex];
                char endChar = chars[endIndex];
                if (Character.isLetter(startChar) && Character.isLetter(endChar)) {
                    chars[endIndex] = startChar;
                    chars[startIndex] = endChar;
                    endIndex--;
                    startIndex++;
                } else if (Character.isLetter(startChar)) {
                    endIndex--;
                } else if (Character.isLetter(endChar)) {
                    startIndex++;
                } else {
                    endIndex--;
                    startIndex++;
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


////给你一个字符串 s ，根据下述规则反转字符串： 
////
//// 
//// 所有非英文字母保留在原有位置。 
//// 所有英文字母（小写或大写）位置反转。 
//// 
////
//// 返回反转后的 s 。 
////
//// 
////
//// 
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "ab-cd"
////输出："dc-ba"
//// 
////
//// 
//// 
////
//// 示例 2： 
////
//// 
////输入：s = "a-bC-dEf-ghIj"
////输出："j-Ih-gfE-dCba"
//// 
////
//// 
//// 
////
//// 示例 3： 
////
//// 
////输入：s = "Test1ng-Leet=code-Q!"
////输出："Qedo1ct-eeLg=ntse-T!"
//// 
////
//// 
////
//// 提示 
////
//// 
//// 1 <= s.length <= 100 
//// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
//// s 不含 '\"' 或 '\\' 
//// 
//// Related Topics 双指针 字符串 👍 148 👎 0
//
