class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int start_with_0 = 0;
        int start_with_1 = 0;
        for(int i=0;i<n;i++){
         char expected0 = (i % 2 == 0) ? '0' : '1';
        char expected1 = (i % 2 == 0) ? '1' : '0';

        if (s.charAt(i) != expected0) {
            start_with_0++;
        }

        if (s.charAt(i) != expected1) {
            start_with_1++;
         }
        }
        return Math.min(start_with_0, start_with_1);   
    }
}