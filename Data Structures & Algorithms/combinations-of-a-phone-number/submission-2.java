class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList();
        }
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', List.of('a', 'b', 'c'));
        graph.put('3', List.of('d', 'e', 'f'));
        graph.put('4', List.of('g', 'h', 'i'));
        graph.put('5', List.of('j', 'k', 'l'));
        graph.put('6', List.of('m', 'n', 'o'));
        graph.put('7', List.of('p', 'q', 'r', 's'));
        graph.put('8', List.of('t', 'u', 'v'));
        graph.put('9', List.of('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        List<Character> curr = new ArrayList<>();
        backTrack(digits, graph, 0, curr, result);

        return result;
    }

    public void backTrack(String digits, HashMap<Character, List<Character>> graph, int start, List<Character> curr, List<String> result){
        if(start == digits.length()){
            StringBuilder res = new StringBuilder();
            for(Character c : curr){
                res.append(c);
            }
            result.add(res.toString());
            return;
        }

        Character c = digits.charAt(start);
        for(Character letter : graph.get(c)){
            curr.add(letter);
            backTrack(digits, graph, start + 1, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}
