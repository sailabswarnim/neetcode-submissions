class Solution {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean endWordPresent = false;
        boolean beginWordPresent = false;
        for(String s : wordList){
            if(s.equals(beginWord)){
                beginWordPresent = true;
            }
            if(s.equals(endWord)){
                endWordPresent = true;
                break;
            }
        }

        if(!endWordPresent){
            return 0;
        }

        int n = wordList.size();
        int m = beginWord.length();
        HashMap<String, List<String>> graph = new HashMap<>();
        
        if(!beginWordPresent){
            wordList.add(beginWord);
        }
        for(String s : wordList){
            graph.put(s, new ArrayList<>());
        }

        for(int i = 0; i < wordList.size(); i++){
            String word1 = wordList.get(i);

            for(int j = i + 1; j < wordList.size(); j++){
                String word2 = wordList.get(j);
                int diffChar = 0;
                for(int itr = 0; itr < m; itr++){
                    if(word1.charAt(itr) != word2.charAt(itr)) {
                        diffChar++;
                    }
                }

                if(diffChar == 1){
                    graph.get(word1).add(word2);
                    graph.get(word2).add(word1);
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(new Pair(beginWord, 1));
        System.out.println(" WORD : " + queue.peek());
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.word;
            visited.add(word);
            if(word.equals(endWord)){
                return p.level;
            }

            for(String nbr : graph.get(word)){
                if(!visited.contains(nbr)){
                    queue.add(new Pair(nbr, p.level + 1));
                }
            }
        }

        return 0;
    }

    public class Pair {
        String word;
        int level;

        Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
}
