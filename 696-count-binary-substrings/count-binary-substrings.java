class Solution {
    public int countBinarySubstrings(String s) {
        int prevGroup = 0;
        int currGroup = 1;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {

            // same character → increase current group
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                // group changed
                result += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        // add last comparison
        result += Math.min(prevGroup, currGroup);

        return result;
    }
}