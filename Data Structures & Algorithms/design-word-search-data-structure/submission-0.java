class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(curr.children[i] == null){
                curr.children[i] = new TrieNode();
            }

            curr = curr.children[i];
        }

        curr.endOfWord = true;

    }

    public boolean search(String word) {
        TrieNode curr = root;

        return searchRec(word, curr, 0);
    }

    public boolean searchRec(String word, TrieNode node, int start){
        if(node == null){
            return false;
        }

        if(start == word.length()){
            return node.endOfWord;
        }

        char c = word.charAt(start);
        if(c != '.'){
            if(searchRec(word, node.children[c-'a'], start + 1)){
                return true;
            };
        } else {
            for(int i = 0; i < 26; i++){
                if(searchRec(word, node.children[i], start + 1)){
                    return true;
                }
            }
        }

        return false;
    }
}

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}
