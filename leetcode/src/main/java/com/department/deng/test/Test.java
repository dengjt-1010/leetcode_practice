package com.department.deng.test;

import com.alibaba.fastjson.JSON;
import com.department.deng.array.TwoNumSum;
import com.department.deng.string.LongestHuiWenSubStr;
import com.department.deng.string.NotRepeatSubStr;

/**
 * Created by deng on 19-3-22.
 */
public class Test {

    //    /**
//     * 1
//     */
//    public static void main(String[] args) {
//        TwoNumSum twoNumSum=new TwoNumSum();
//        int [] request={2, 7, 11, 15};
//        int [] result=twoNumSum.twoSum(request,9);
//        System.out.println(JSON.toJSONString(result));
//    }


//    public static void main(String[] args) {
//        NotRepeatSubStr notRepeatSubStr = new NotRepeatSubStr();
//        System.out.println(notRepeatSubStr.lengthOfLongestSubstring("dvdf"));
//    }

    public static void main(String[] args) {
        LongestHuiWenSubStr longestHuiWenSubStr = new LongestHuiWenSubStr();
        System.out.println(longestHuiWenSubStr.longestPalindrome("abcdccd"));
    }
}
