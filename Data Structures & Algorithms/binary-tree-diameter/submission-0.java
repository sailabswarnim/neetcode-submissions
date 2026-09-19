/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        maxPathRec(root);

        return ans - 1;
    }

    public int maxPathRec(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftTreeMax = maxPathRec(node.left);
        int rightTreeMax = maxPathRec(node.right);
        ans = Math.max(ans, 1 + leftTreeMax + rightTreeMax);

        return 1 + Math.max(leftTreeMax, rightTreeMax);
    }
}
