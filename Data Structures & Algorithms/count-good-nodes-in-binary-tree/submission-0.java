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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode node, int maxSoFar){
        if(node == null){
            return 0;
        }

        
        int leftGoodNodes = goodNodes(node.left, Math.max(maxSoFar, node.val));
        int rightGoodNodes = goodNodes(node.right, Math.max(maxSoFar, node.val));
    
        if(maxSoFar > node.val){
            return leftGoodNodes + rightGoodNodes;
        }

        return 1 + leftGoodNodes + rightGoodNodes;
    }
}
