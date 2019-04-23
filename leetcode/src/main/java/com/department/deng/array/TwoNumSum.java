package com.department.deng.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by deng on 19-3-22.
 *
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TwoNumSum {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * 因为快排之后原来的数据位置信息没得了，所以这种解法只能求出对应的数字，而不能获得其下标
     */
    public int[] twoSumNoExtraSpace(int[] nums, int target) {

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if ((nums[left] + nums[right]) > target) {
                //因为最大的和最小的相加都比target大，所以和为target的两数肯定不包含最大的。
                right--;
            } else if ((nums[left] + nums[right] < target)) {
                //因为最小的和最大的相加都小于target,所以和为target的两数肯定不包含最小的。
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }

    public int[] twoSumForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 4};
        TwoNumSum twoNumSum = new TwoNumSum();
        twoNumSum.twoSumNoExtraSpace(a, 6);
    }

}
