package com.department.deng.tree;

import com.department.deng.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deng on 19-4-15.
 * <p>
 * 230. 二叉搜索树中第K小的元素
 */
public class BinarySearchTreeTopK {

    List<TreeNode> list = new ArrayList<TreeNode>();

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        find(root);
        return list.get(k - 1).val;

    }

    private void find(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            find(root.left);
        }
        list.add(root);
        if (root.right != null) {
            find(root.right);
        }
    }

}
