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

// Queue solution
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = serializeRec(root, new StringBuilder());
        System.out.println(result.toString());
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] characters = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(String s : characters){
            queue.add(s);
        }
        return deserializeRec(queue);
    }

    public StringBuilder serializeRec(TreeNode node, StringBuilder res){
        if (node == null){
            res.append("N");
            return res;
        }

        res.append(String.valueOf(node.val));
        res.append(",");
        serializeRec(node.left, res);
        res.append(",");
        serializeRec(node.right, res);

        return res;

    }

    public TreeNode deserializeRec(Queue<String> queue){
        if(!queue.isEmpty()){
            String node = queue.poll();
            if(node.equals("N")){
                return null;
            }

            TreeNode res = new TreeNode(Integer.valueOf(node));
            res.left = deserializeRec(queue);
            res.right = deserializeRec(queue);

            return res;
        } else {
            return null;
        }
    }

}
