// Binary Search optimised
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if(A.length > B.length){
            int[] temp = A;
            A = B;
            B = temp;
        }

        int m = A.length;
        int n = B.length;

        int l = 0;
        int r = A.length;

        while(l <= r){
            int i = l + (r-l)/2;
            int j = (m + n)/2 - i;

            int Aleft = (i <= 0) ? Integer.MIN_VALUE : A[i-1];
            int Aright = (i >= m) ? Integer.MAX_VALUE : A[i];
            int Bleft = (j <= 0) ? Integer.MIN_VALUE : B[j-1];
            int Bright = (j >= n) ? Integer.MAX_VALUE : B[j];

            if(Aleft <= Bright && Bleft <= Aright){
                if((m + n) % 2 == 0){
                    return (double) (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
                } else {
                    return (double) Math.min(Aright, Bright);
                }
            } else if (Aleft > Bright){
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return 0.0;
    }
}
