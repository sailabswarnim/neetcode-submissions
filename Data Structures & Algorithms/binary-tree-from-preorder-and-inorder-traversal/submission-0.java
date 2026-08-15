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
    // brute force
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRec(preorder, inorder, 0, 0, inorder.length -1);
    }

    public TreeNode buildTreeRec(int[] preorder, int[] inorder, int rootIdx, int inOrderStart, int inorderEnd){
        if(rootIdx >= preorder.length){
            return null;
        }

        if(inOrderStart < 0 || inOrderStart >= inorder.length){
            return null;
        }

        if(inorderEnd < 0 || inorderEnd >= inorder.length){
            return null;
        }

        if(inOrderStart > inorderEnd){
            return null;
        }

        int rootInInorder = 0;
        for(int i = inOrderStart; i <= inorderEnd; i++){
            if(inorder[i] == preorder[rootIdx]){
                rootInInorder = i;
                break;
            }
        }

        TreeNode left = buildTreeRec(preorder, inorder, rootIdx + 1, inOrderStart, rootInInorder -1);
        int leftSize = rootInInorder - inOrderStart;

        TreeNode right = buildTreeRec(preorder, inorder, rootIdx + 1 + leftSize, rootInInorder + 1, inorderEnd);

        TreeNode rootNode = new TreeNode(preorder[rootIdx], left, right);

        return rootNode;
    }
}
