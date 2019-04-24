package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-14.
 * <p>
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTreeByPostAndIn {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inSt, int inEnd, int[] postorder, int postSt, int postEnd) {
        TreeNode root = new TreeNode(postorder[postEnd]);

        if (postSt == postEnd) {
            return root;
        }

        int rootInIndex = 0;
        while (inorder[rootInIndex] != root.val) {
            rootInIndex++;
        }

        int leftLength = rootInIndex - inSt;

        if (leftLength > 0) {
            root.left = build(inorder, inSt, rootInIndex - 1, postorder, postSt, postSt + leftLength - 1);
        }
        if ((postSt + leftLength) < postEnd) {
            root.right = build(inorder, rootInIndex + 1, inEnd, postorder, postSt + leftLength, postEnd - 1);
        }
        return root;
    }
}
