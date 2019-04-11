package com.department.deng.string;

/**
 * Created by deng on 19-4-11.
 * 判断一个整数是否是回文数。回文数是指正序
 * （从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsHuiWenNum {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0) {
            return false;
        }
        if (x % 10 == 0) {
            return false;
        }


        int reverse = 0;

        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return x == reverse || reverse / 10 == x;

    }
}
