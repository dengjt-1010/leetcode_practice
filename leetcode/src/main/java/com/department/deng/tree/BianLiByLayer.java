package com.department.deng.tree;

import com.department.deng.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by deng on 19-4-12.
 * 102. 二叉树的层次遍历
 */
public class BianLiByLayer {


    /**
     * 这个方法的层序遍历只需要一次遍历就行，
     * <p>
     * 但是需要额外的存储空间
     * <p>
     * 并且是非递归的。。。。
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res.add(0, list);//不利用栈进行倒序,而是直接加入到0位置,实现了倒叙
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int depth = maxDepth(root);
        for (int i = 0; i <= depth; i++) {
            List<Integer> one = levelOrder(root, i);
            if (one != null && one.size() != 0) {
                result.add(one);
            }

        }
        return result;
    }

    private List<Integer> levelOrder(TreeNode node, int level) {
        List<Integer> result = new ArrayList<Integer>();
        if (node == null || level < 1) {
            return result;
        }
        if (level == 1) {
            result.add(node.val);
        }

        result.addAll(levelOrder(node.left, level - 1));
        result.addAll(levelOrder(node.right, level - 1));

        return result;
    }

    private int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }
}

