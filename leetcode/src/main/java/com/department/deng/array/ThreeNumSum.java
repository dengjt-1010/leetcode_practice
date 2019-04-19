package com.department.deng.array;

import java.util.Arrays;

/**
 * Created by deng on 19-4-16.
 * <p>
 * 16. 最接近的三数之和
 * <p>
 * https://www.jianshu.com/p/44b22c0c1288
 */
public class ThreeNumSum {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && right < nums.length) {
                int current = (nums[left] + nums[right] + nums[i]);
                if (Math.abs(current - target) < Math.abs(res - target)) {
                    res = current;
                }
                if (current < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {0, 2, 1, -3};
        ThreeNumSum threeNumSum = new ThreeNumSum();
        int result = threeNumSum.threeSumClosest(a, 1);
        System.out.println(result);
    }
}
