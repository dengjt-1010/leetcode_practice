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
        int i=0,j=0,max=0,len=s.length();
        Set<Character> set=new HashSet<Character>();
        while(i<len&&j<len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max=Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
