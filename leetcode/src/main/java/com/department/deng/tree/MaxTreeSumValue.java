package com.department.deng.tree;

import com.department.deng.base.TreeNode;

/**
 * Created by deng on 19-4-15.
 * <p>
 * 124. 二叉树中的最大路径和
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * https://www.jianshu.com/p/86d6f0932484
 */
public class MaxTreeSumValue {


    /**
     * 这个解法是理解错了题意，理解成了，从根节点到叶子节点的最大路径和
     *
     * @param args
     */

//    public int maxPathSum(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        if(root.left==null&&root.right==null){
//            return root.val;
//        }
//        int left=maxPathSum(root.left);
//        int right=maxPathSum(root.right);
//
//        if(root.left==null){
//            return right+root.val;
//        }else if(root.right==null){
//            return left+root.val;
//        }else {
//            return left>right?left+root.val:right+root.val;
//        }
//    }
    public static void main(String[] args) {
        MaxTreeSumValue maxTreeSumValue = new MaxTreeSumValue();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.right = c;

        System.out.println(maxTreeSumValue.maxPathSum(a));
        ;
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }

    private int pathSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        int rootPath = root.val + Math.max(left, right);
        max = Math.max(root.val + left + right, max);
        return Math.max(rootPath, 0);
    }
}
