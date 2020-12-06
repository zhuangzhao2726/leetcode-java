package com.zhuangzhao.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-09-15 16:01
 */
public class Solution {

    void removeBranch(TreeNode root, String id) {
        if (root == null || id == null) {
            return;
        } else if (id.equals(root.id)) {
            root.children = new ArrayList<>();
            return;
        } else if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                root.children.set(i, removeBranchNode(root.children.get(i), id));
            }
            root.children.remove(null);
        }
    }


    TreeNode removeBranchNode(TreeNode node, String id) {
        if (id.equals(node.id)) {
            node.children = null;
            return null;
        } else if (node.children != null) {
            for (int i = 0; i < node.children.size(); i++) {
                node.children.set(i, removeBranchNode(node.children.get(i), id));
            }
            node.children.remove(null);
            if (node.children.size() == 0) {
                return null;
            }
        }
        return node;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();


        TreeNode root = new TreeNode();
        root.setId("1");

        List<TreeNode> children = new ArrayList<>();
        for (int i =  2; i < 10; i++) {
            TreeNode child = new TreeNode();
            child.setId(String.valueOf(i));
            TreeNode son = new TreeNode();
            son.setId(String.valueOf(10 + i));
            child.setChildren(new ArrayList<TreeNode>(){{add(son);}});
            children.add(child);
        }
        root.setChildren(children);

        solution.removeBranch(root, "12");


        System.out.println(root);


    }
}

class TreeNode {

    String id;
    List<TreeNode> children;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}