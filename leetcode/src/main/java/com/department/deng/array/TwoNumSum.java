package com.department.deng.array;

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
                if (map.keySet().contains(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                } else {
                    map.put(target - nums[i], i);
                }
            }
            throw new IllegalArgumentException();
    }

    public int[] twoSumForce(int[] nums,int target){
            for (int i=0;i<nums.length;i++){
                for (int j=0;j<nums.length;j++){
                    if(i==j){
                        continue;
                    }
                    if ((nums[i]+nums[j])==target){
                        return new int[]{i,j};
                    }
                }
            }
            throw new IllegalArgumentException();
    }

}
