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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> righNodes = new ArrayList<>();
        dfs(root, righNodes, 0);
        return righNodes;
    }

    public void dfs(TreeNode node, List<Integer> righNodes, int level){
        if(node == null){
            return;
        }

        if(righNodes.size() == level){
            righNodes.add(node.val);
        }

        dfs(node.right, righNodes, level + 1);
        dfs(node.left, righNodes, level + 1);
    }
}
