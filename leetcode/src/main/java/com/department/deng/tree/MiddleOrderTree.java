package com.department.deng.tree;

import com.department.deng.base.ListNode;
import com.department.deng.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deng on 19-4-12.
 * 94.中序遍历
 */
public class MiddleOrderTree {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));

        return result;
    }

}
