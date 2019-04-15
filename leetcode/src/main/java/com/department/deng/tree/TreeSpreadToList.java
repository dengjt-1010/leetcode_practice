package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-14.
 * <p>
 * 114. 二叉树展开为链表
 * <p>
 * 注意：不能使用额外的空间
 */
public class TreeSpreadToList {

    public void flatten(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                current = current.right;
                continue;
            }
            TreeNode leftRightTail = current.left.right;
            if (leftRightTail == null) {
                leftRightTail = current.left;
            } else {
                while (leftRightTail.right != null) {
                    leftRightTail = leftRightTail.right;
                }
            }
            TreeNode currentRight = current.right;
            current.right = current.left;
            current.left = null;
            leftRightTail.right = currentRight;
            current = current.right;

        }
    }
}
