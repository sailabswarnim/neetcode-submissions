class Solution {
    private List<Character> res = new ArrayList<>();
    // dfs
    public String foreignDictionary(String[] words) {
      HashMap<Character, HashSet<Character>> graph = new HashMap<>();

      for(String word : words){
        for(Character c : word.toCharArray()){
            graph.putIfAbsent(c, new HashSet<>());
        }
      }

      for(int i = 0 ; i < words.length - 1; i++){
        String word1 = words[i];
        String word2 = words[i+1];
        int minLen = Math.min(word1.length(), word2.length());

        if(word1.length() > word2.length() && word1.substring(0, minLen).equals(word2)){
            return "";
        }

        for(int j = 0; j < minLen; j++){
            if(word1.charAt(j) != word2.charAt(j)){
                if(!graph.get(word1.charAt(j)).contains(word2.charAt(j))){
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                }
                break;
            }
        }
      }

      int[] state = new int[26];
      for(Character c : graph.keySet()){
        if(dfs(graph, c, state, res)){
            return "";
        }
      }

      Collections.reverse(res);
      StringBuilder result = new StringBuilder();
      for(Character c : res){
        result.append(c);
      }
      return result.toString();
    }

    public boolean dfs(HashMap<Character, HashSet<Character>> graph, Character c, int[] state, List<Character> res){
        if(state[c-'a'] == 2){
            return false;
        }

        if(state[c-'a'] == 1){
            return true;
        }

        state[c-'a'] = 1;
        for(Character nbr : graph.get(c)){
            if(dfs(graph, nbr, state, res)){
                return true;
            }
        }

        state[c-'a'] = 2;
        res.add(c);
        return false;
    }
}
