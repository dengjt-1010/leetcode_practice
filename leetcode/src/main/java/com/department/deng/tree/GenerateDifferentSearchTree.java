package com.department.deng.tree;

import com.department.deng.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by deng on 19-4-12.
 * <p>
 * 95. 不同的二叉搜索树 II
 * 根据不同的输入参数n,生成不同的1~n的二叉查找（搜索）树
 */
public class GenerateDifferentSearchTree {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (n <= 0) {
            return result;
        }

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTree = generateTrees(start, i - 1);
            List<TreeNode> subRightTree = generateTrees(i + 1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        GenerateDifferentSearchTree generateDifferentSearchTree = new GenerateDifferentSearchTree();

        System.out.println(generateDifferentSearchTree.generateTrees(3));
    }
}
