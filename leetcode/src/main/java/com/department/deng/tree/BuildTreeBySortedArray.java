package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-14.
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * https://www.cnblogs.com/xiangaaa/p/8858124.html
 */
public class BuildTreeBySortedArray {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);

            root.left = build(nums, start, mid - 1);
            root.right = build(nums, mid + 1, end);
            return root;
        } else {
            return null;
        }
    }
}
