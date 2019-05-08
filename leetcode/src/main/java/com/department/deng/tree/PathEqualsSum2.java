package com.department.deng.tree;

import com.department.deng.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deng on 19-4-14.
 * <p>
 * 113. 路径总和 II
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class PathEqualsSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            result.add(temp);
        } else {
            find(root, sum, null, result);
        }

        return result;
    }


    /**
     * @param root
     * @param sum
     * @param list   这个方法调用，此处的list必须是新的。否则的话不同递归流程中用的是同一个list,肯定有问题。
     * @param result
     */
    private void find(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {

        if (root == null) {
            return;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if (list == null) {
            list = new ArrayList<Integer>();
        }
        temp.addAll(list);
        temp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(temp);
        } else if (root.left != null || root.right != null) {
            find(root.left, sum - root.val, temp, result);
            find(root.right, sum - root.val, temp, result);
        }
    }
}
