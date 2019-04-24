package com.department.deng.tree;

import com.department.deng.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> layer = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    queue.add(current.left);
                    queue.add(current.right);
                    layer.add(current.val);
                }
            }
            if (layer != null && layer.size() != 0) {
                res.add(layer);
            }
        }
        return res;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int depth = maxDepth(root);

        for (int i = 1; i <= depth; i++) {
            List<Integer> values = levelOrder(root, i);
            if (values != null && values.size() != 0) {
                result.add(values);
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

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }
}

