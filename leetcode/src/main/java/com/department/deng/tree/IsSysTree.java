package com.department.deng.tree;

import com.department.deng.base.TreeNode;
import sun.swing.StringUIClientPropertyKey;

/**
 * Created by deng on 19-4-12.
 * 101. 对称二叉树
 */
public class IsSysTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
