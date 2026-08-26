class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
    int ones = 0;
    String result = "";

    for (int right = 0; right < s.length(); right++) {

        if (s.charAt(right) == '1') {
            ones++;
        }

        // Shrink the window while it contains more than k ones
        while (ones > k) {
            if (s.charAt(left) == '1') {
                ones--;
            }
            left++;
        }

        // If window contains exactly k ones
        while (ones == k && left <= right) {

            String current = s.substring(left, right + 1);

            // Remove leading zeros to get the shortest possible substring
            if (s.charAt(left) == '0') {
                left++;
                continue;
            }

            // Compare with the current answer
            if (result.isEmpty()
                    || current.length() < result.length()
                    || (current.length() == result.length()
                        && current.compareTo(result) < 0)) {
                result = current;
            }

            // Try to shrink further
            if (s.charAt(left) == '1') {
                ones--;
            }
            left++;
        }
    }

    return result;
    }
}