package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-14.
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * https://blog.csdn.net/whdAlive/article/details/80480778
 */
public class BuildTreeByPreAndIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        return buildCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildCore(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd) {

        TreeNode root = new TreeNode(preorder[preSt]);

        if (preSt == preEnd) {
            return root;
        }

        int middleRootIndex = 0;
        while (root.val != inorder[middleRootIndex]) {
            middleRootIndex++;
        }

        int leftLength = middleRootIndex - inSt;

        if (leftLength > 0) {
            root.left = buildCore(preorder, preSt + 1, preSt + leftLength, inorder, inSt, middleRootIndex - 1);
        }

        if (middleRootIndex < inEnd) {
            root.right = buildCore(preorder, preSt + leftLength + 1, preEnd, inorder, middleRootIndex + 1, inEnd);
        }
        return root;

    }

    public static void main(String[] args) {
        int[] preOrder = {2, 1, 6, 3, 4, 5};
        int[] inOrder = {1, 2, 3, 4, 5, 6};
        BuildTreeByPreAndIn buildTreeByPreAndIn = new BuildTreeByPreAndIn();
        buildTreeByPreAndIn.buildTree(preOrder, inOrder);
    }

    class Solution {
        //写法仿照 剑指offer 面试题7 重建二叉树

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0) {
                return null;
            }
            return buildCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildCore(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd) {
            //前序遍历第一个节点是根节点
            int rootValue = preorder[preSt];
            TreeNode root = new TreeNode(rootValue);

            //前序序列只有根节点
            if (preSt == preEnd) {
                return root;
            }
            //遍历中序序列，找到根节点的位置
            int rootInorder = inSt;
            while (inorder[rootInorder] != rootValue && rootInorder <= inEnd) {
                rootInorder++;
            }

            //左子树的长度
            int leftLength = rootInorder - inSt;
            //前序序列中左子树的最后一个节点

            //左子树非空
            if (leftLength > 0) {
                //重建左子树
                root.left = buildCore(preorder, preSt + 1, preSt + leftLength, inorder, inSt, inEnd);
            }
            //右子树非空
            if (leftLength < preEnd - preSt) {
                //重建右子树
                root.right = buildCore(preorder, preSt + leftLength + 1, preEnd, inorder, rootInorder + 1, inEnd);
            }
            return root;
        }
    }

}
