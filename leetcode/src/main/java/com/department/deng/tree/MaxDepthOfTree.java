package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-12.
 * <p>
 * 104. 二叉树的最大深度
 */
public class MaxDepthOfTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }
}
