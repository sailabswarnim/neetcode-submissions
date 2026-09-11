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
    public boolean isBalanced(TreeNode root) {
        return isBalancedRec(root)[0] == 1;
    }

    public int[] isBalancedRec(TreeNode node){
        if(node == null){
            return new int[]{1, 0};
        }

        int[] leftRes = isBalancedRec(node.left);
        int[] rightRes = isBalancedRec(node.right);

        if(leftRes[0] == 0 || rightRes[0] == 0){
            return new int[]{0, -1};
        }

        if(Math.abs(leftRes[1] - rightRes[1]) >= 2){
            return new int[]{0, -1};
        }

        return new int[]{1, 1 + Math.max(leftRes[1], rightRes[1])};
    }
}
