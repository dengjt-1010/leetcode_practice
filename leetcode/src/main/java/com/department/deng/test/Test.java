package com.department.deng.test;

import com.alibaba.fastjson.JSON;
import com.department.deng.array.TwoNumSum;

/**
 * Created by deng on 19-3-22.
 */
public class Test {

    /**
     * 1
     */
    public static void main(String[] args) {
        TwoNumSum twoNumSum=new TwoNumSum();
        int [] request={2, 7, 11, 15};
        int [] result=twoNumSum.twoSum(request,9);
        System.out.println(JSON.toJSONString(result));
    }
}
