package com.department.deng.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by deng on 19-3-22.
 */
public class NotRepeatSubStr {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s == "") {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        int max = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int start = i;
            int end = start;
            Set<Character> set = new HashSet<Character>();
            int curr = 0;
            while (end != len) {

                if (!set.contains(s.charAt(end))) {
                    set.add(s.charAt(end));
                    curr++;
                    end++;
                } else {
                    break;
                }
            }
            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NotRepeatSubStr notRepeatSubStr = new NotRepeatSubStr();

        notRepeatSubStr.lengthOfLongestSubstring("au");
    }
}
