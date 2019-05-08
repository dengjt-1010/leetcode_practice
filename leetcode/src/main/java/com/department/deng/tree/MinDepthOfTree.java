package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-14.
 * <p>
 * 111. 二叉树的最小深度
 */
public class MinDepthOfTree {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            int left = minDepth(root.left) + 1;
            int right = minDepth(root.right) + 1;
            return left < right ? left : right;
        }
    }

}
