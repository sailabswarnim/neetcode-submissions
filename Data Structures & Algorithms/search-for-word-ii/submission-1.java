class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    List<String> res = new ArrayList<>();
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        for(String word : words){
            TrieNode curr = trie;
            for(int i = 0; i < word.length(); i++){
                Character c = word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isWordEnd = true;
        }
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, visited, i,j, trie, new StringBuilder());
            }
        }
        

        return res;
    }

    public void dfs(char[][] board, boolean[][] visited, int row, int col, TrieNode node, StringBuilder curr){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || node == null){
            return;
        }


        visited[row][col] = true;
        char c = board[row][col];
        TrieNode next = node.children[c-'a'];
        curr.append(c);

        if(next != null && next.isWordEnd){
            next.isWordEnd = false;
            res.add(curr.toString());
        }



        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length ||  visited[nr][nc]){
                continue;
            }
            dfs(board, visited, nr, nc, next, curr);
        }
        curr.deleteCharAt(curr.length()-1);
        visited[row][col] = false;

        return;
    }

    public class TrieNode {
        boolean isWordEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}
