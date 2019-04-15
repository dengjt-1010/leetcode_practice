package com.department.deng.array;

/**
 * Created by deng on 19-4-12.
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有
 * 数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用
 * O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class DeleteItem {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }


    public static void main(String[] args) {
        DeleteItem item = new DeleteItem();

        int[] request = {0, 1, 2, 2, 3, 0, 4, 2};
        item.removeElement(request, 2);
    }
}
