package com.department.deng.array;

/**
 * Created by deng on 19-4-16.
 * <p>
 * 11. 盛最多水的容器
 */
public class MaxWater {

    /**
     * 解法一：暴力方法，两层for循环。
     */

    //todo

    /**
     * 解法二：
     * <p>
     * 这种方法背后的思路在于，
     * 两线段之间形成的区域总是会受到其中较短那条长度的限制。
     * 此外，两线段距离越远，得到的面积就越大。
     * <p>
     * 我们在由线段长度构成的数组中使用两个指针，
     * 一个放在开始，一个置于末尾。
     * 此外，我们会使用变量 maxareamaxarea
     * 来持续存储到目前为止所获得的最大面积。
     * 在每一步中，我们会找出指针所指向的两条线段形成的区域，
     * 更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
     */


    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;

        while (left < right && left >= 0 && right < height.length) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


}
