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
    TreeNode ins;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        insertionPoint(root, val);
        System.out.println(ins);
        if(ins == null){
            return new TreeNode(val);
        }

        if(ins.val < val){
            ins.right = new TreeNode(val);
        } else {
            ins.left = new TreeNode(val);
        }

        return root;
    }

    public void insertionPoint(TreeNode node, int val){
        if(node == null){
            return;
        }

        ins = node;
        if(node.val < val){
            insertionPoint(node.right, val);
        } else {
            insertionPoint(node.left, val);
        }

        return ;
    }
}