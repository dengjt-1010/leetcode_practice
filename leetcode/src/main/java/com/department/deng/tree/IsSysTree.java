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

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && (isMirror(node1.left, node2.right)) && isMirror(node1.right, node2.left);
    }

}
