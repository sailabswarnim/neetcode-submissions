class Solution {
    // Top Down
    HashMap<String, Integer> memo;
    public int minDistance(String word1, String word2) {
        memo = new HashMap<>();
        return distRec(word1, word2, 0, 0);
    }

    public int distRec(String word1, String word2, int w1, int w2){
        String key = w1 + "-" + w2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(w2 == word2.length()){
            memo.put(key, word1.length() - w1);
            return word1.length() - w1;
        }

        if(w1 == word1.length()){
            memo.put(key, word2.length() - w2);
            return word2.length() - w2;
        }

        if(word1.charAt(w1) == word2.charAt(w2)){
            memo.put(key, distRec(word1, word2, w1 + 1, w2 + 1));
            return distRec(word1, word2, w1 + 1, w2 + 1);
        }

        int smallestChanges = 0;
        smallestChanges = Math.min(1 + distRec(word1, word2, w1 + 1, w2), 1 + distRec(word1, word2, w1, w2 + 1));
        smallestChanges = Math.min(smallestChanges, 1 + distRec(word1, word2, w1 + 1, w2 + 1));
        memo.put(key, smallestChanges);
        return smallestChanges;

    }
}
