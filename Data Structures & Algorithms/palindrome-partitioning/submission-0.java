class Solution {
    // Pure Rec
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        partitionRec(s, 0, new ArrayList<>());
        return result;
    }

    public void partitionRec(String s, int start, List<String> curr){
        if(start >= s.length()){
            result.add(new ArrayList<>(curr));
        }

        for(int i = start; i < s.length();i++){
            if(isPalindrome(s, start, i)){
                curr.add(s.substring(start, i+1));
                partitionRec(s, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }

        return;      
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
