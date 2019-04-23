package com.department.deng.array;

/**
 * Created by deng on 19-4-12.
 *
 * 26. 删除排序数组中的重复项
 *
 * 这个题前提条件是排序数组，而针对排序就有很多可以问了。其中：快排，归并等都没有用到额外的存储空间。
 *
 * 不要使用额外的数组空间，你必须在原地修改
 * 输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class DeleteSameItemForSortArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }


    public static void main(String[] args) {
        int[] request = {1, 1, 2};
        DeleteSameItemForSortArray deleteSameItemForSortArray = new DeleteSameItemForSortArray();
        deleteSameItemForSortArray.removeDuplicates(request);
    }

}
