package com.department.deng.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deng on 19-3-22.
 */
public class TwoNumSum {
        public int[] twoSum(int[] nums, int target) {
           Map<Integer,Integer> map=new HashMap<Integer, Integer>();
           for(int i=0;i<nums.length;i++){
               int other=target-nums[i];
               if(map.containsKey(other)){
                   return new int[]{i,map.get(other)};
               }else {
                   map.put(nums[i],i);
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
