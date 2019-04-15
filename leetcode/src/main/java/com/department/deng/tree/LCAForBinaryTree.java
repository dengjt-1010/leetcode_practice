package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-15.
 * <p>
 * Lowest Common Ancestors:LCA
 * <p>
 * 236. 二叉树的最近公共祖先
 * <p>
 * https://www.jianshu.com/p/f3d2e995fd06
 */
public class LCAForBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题，查阅相关资料
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

}
