package com.department.deng.string;

/**
 * Created by deng on 19-3-22.
 */
public class LongestHuiWenSubStr {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * <p>
     * 注意：求最长回文子串的时候需要考虑两种情况：
     * 1.  abcba的形式，奇数长度
     * 2. abccba的形式，偶数长度
     */
    public String longestPalindrome(String s) {

        if (s == null || s.equals("")) {
            return "";
        }

        int strLen = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < strLen; i++) {
            int len1 = countAroundCenter(s, i, i);
            int len2 = countAroundCenter(s, i, i + 1);
            int lenTemp = Math.max(len1, len2);
            if (lenTemp > (end - start)) {
                start = i - (lenTemp - 1) / 2;
                end = i + lenTemp / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int countAroundCenter(String s, int left, int right) {
        if (left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


}
