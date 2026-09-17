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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = serializeRec(root, new StringBuilder());
        System.out.println(result.toString());
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Boolean[] visited = new Boolean[vals.length];
        Arrays.fill(visited, false);
        return deserializeRec(vals, 0, visited);
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

    public TreeNode deserializeRec(String[] data, int start, Boolean[] visited){
        if(start == data.length){
            return null;
        }

        if(data[start].equals("N")){
            visited[start] = true;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(data[start]));
        visited[start] = true;
        node.left = deserializeRec(data, start + 1, visited);
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false){
                node.right = deserializeRec(data, i, visited);
                break;
            }
        }

        return node;
    }

}
