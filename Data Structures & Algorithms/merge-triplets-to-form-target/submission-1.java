class Solution {
    
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] ignore = new boolean[triplets.length];

        boolean first = false;
        boolean second = false;
        boolean third = false;

        for(int i = 0; i < triplets.length; i++){
            int[] triplet = triplets[i];
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                if(triplet[0] == target[0]){
                    first = true;
                }

                if(triplet[1] == target[1]){
                    second = true;
                }

                if(triplet[2] == target[2]){
                    third = true;
                }
            }
        }

        return first && second && third;
    }
}
