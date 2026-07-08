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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode node = root;
        while(node != null){
            int currVal = node.val;
            if(currVal > p.val && currVal > q.val){
                node = node.left;
            } else if (currVal < p.val && currVal < q.val){
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }
}
