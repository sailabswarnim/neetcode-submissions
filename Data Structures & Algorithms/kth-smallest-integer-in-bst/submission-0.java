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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, k);
        return result.get(result.size() - 1);
    }

    public void dfs(TreeNode node, List<Integer> result, int k){
        if(node == null){
            return;
        }

        dfs(node.left, result, k);

        if(result.size() < k){
           result.add(node.val); 
        }

        dfs(node.right, result, k);

    }
}
