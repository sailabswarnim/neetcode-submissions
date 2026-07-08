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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair nodePair = queue.poll();
            TreeNode node = nodePair.node;
            Integer level = nodePair.level;
            if(result.size() == level){
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            if(node.left != null)
                queue.add(new Pair(node.left, level + 1));
            if(node.right != null)
                queue.add(new Pair(node.right, level + 1));
        }

        return result;
    }

    public class Pair {
        TreeNode node;
        Integer level;
        Pair(TreeNode node, Integer level){
            this.level = level;
            this.node = node;
        }
    }
}
