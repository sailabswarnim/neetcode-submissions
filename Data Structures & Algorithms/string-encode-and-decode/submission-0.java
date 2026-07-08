class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for(String s : strs){
            encoded.append(s.length()).append('#').append(s) ;
        }

        System.out.println(encoded.toString());
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
    int n = str.length();
    if (n == 0) return result;

    for (int i = 0; i < n; i++) {
        int j = i;

        // find '#' safely (with bound check)
        while (j < n && str.charAt(j) != '#') {
            j++;
        }
        // if '#' not found, encoded string malformed -> stop or throw
        if (j >= n) {
            throw new IllegalArgumentException("Invalid encoded string: missing '#'");
        }

        // parse length from i..j-1
        int length;
        try {
            length = Integer.parseInt(str.substring(i, j));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid length field: " + str.substring(i, j));
        }

        // compute start and end of the actual string content
        int start = j + 1;
        int end = start + length;
        if (end > n) {
            throw new IllegalArgumentException("Invalid encoded string: truncated content");
        }

        // extract substring and add to result
        String sub = str.substring(start, end);
        result.add(sub);

        // set i so that the for-loop's i++ lands at 'end' (start of next segment)
        i = end - 1;
    }
    return result;
}
}