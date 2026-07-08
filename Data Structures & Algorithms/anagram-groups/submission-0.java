class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();


        for(String s : strs){
            String original = s;
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> existingAnagrams = map.getOrDefault(key, new ArrayList<>());
            existingAnagrams.add(original);
            map.put(key, existingAnagrams);
        }

        return new ArrayList<>(map.values());
    }
}
