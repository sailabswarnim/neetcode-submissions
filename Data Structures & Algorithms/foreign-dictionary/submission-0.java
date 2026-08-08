class Solution {
    // topological sort
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> inDegree = new HashMap<>();
      Queue<Character> sources = new LinkedList<>();
      StringBuilder res = new StringBuilder();
      for(String word : words){
        for(Character c : word.toCharArray()){
            graph.putIfAbsent(c, new HashSet<>());
            inDegree.putIfAbsent(c, 0);
        }
      }

      // make the graph
      for(int i = 0; i < words.length - 1; i++){
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
                    inDegree.put(word2.charAt(j), inDegree.get(word2.charAt(j)) + 1);
                }
                break;
            }
        }

      }

      for(Character c : inDegree.keySet()){
        if(inDegree.get(c) == 0){
            sources.add(c);
        }
      }

      while(!sources.isEmpty()){
        Character c = sources.poll();
        res.append(c);

        for(Character nbr : graph.get(c)){
            inDegree.put(nbr, inDegree.get(nbr) - 1);
            if(inDegree.get(nbr) == 0){
                sources.add(nbr);
            }
        }
      }

      if(res.length() != inDegree.size()){
        return "";
      }

      return res.toString();
    }
}
