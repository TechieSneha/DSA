class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();

        int count = 0;
        int start = 0;

        // Split into special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
            else
                count--;
                // Found a balanced special substring
            if (count == 0) {
                // recursively solve inner part
                String inner = makeLargestSpecial(
                        s.substring(start + 1, i));

                list.add("1" + inner + "0");
                start = i + 1;
            }
        }

        // Sort in descending order
        Collections.sort(list, Collections.reverseOrder());

        // Combine result
        StringBuilder result = new StringBuilder();
        for (String str : list)
            result.append(str);

        return result.toString();
    }
}