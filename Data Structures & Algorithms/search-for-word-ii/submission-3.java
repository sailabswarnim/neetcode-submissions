class Solution {
    // Caching the word in the trie and no visited
    int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    List<String> res = new ArrayList<>();
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
            curr.word = word;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i,j, trie);
            }
        }
        

        return res;
    }

    public void dfs(char[][] board, int row, int col, TrieNode node){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#' || node == null){
            return;
        }


        char c = board[row][col];
        board[row][col] = '#';
        TrieNode next = node.children[c-'a'];

        if(next != null && next.isWordEnd){
            next.isWordEnd = false;
            res.add(next.word);
        }



        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length || board[nr][nc] == '#'){
                continue;
            }
            dfs(board, nr, nc, next);
        }
        board[row][col] = c;

        return;
    }

    public class TrieNode {
        boolean isWordEnd = false;
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}
