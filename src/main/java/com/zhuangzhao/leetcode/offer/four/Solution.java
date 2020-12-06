package com.zhuangzhao.leetcode.offer.four;



class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int index = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        if (index > inStart) {
            treeNode.left = this.buildTree(preorder, preStart + 1, preStart + 1 + (index - inStart), inorder, inStart, index);
        }
        if (index < inEnd - 1) {
            treeNode.right = this.buildTree(preorder, preStart + 1 + (index - inStart), preEnd, inorder, index + 1, inEnd);
        }
        return treeNode;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



