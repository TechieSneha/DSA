class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        // Mark lowercase and uppercase appearances
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            } else if (Character.isUpperCase(ch)) {
                upper[ch - 'A'] = true;
            }
        }

        // Count special characters
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count; 
    }
}