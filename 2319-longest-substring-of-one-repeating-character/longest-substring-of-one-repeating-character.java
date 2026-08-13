class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
    int n = arr.length;

    // start -> end of each consecutive run
    TreeMap<Integer, Integer> runs = new TreeMap<>();

    // length -> frequency of runs having this length
    TreeMap<Integer, Integer> lengths = new TreeMap<>();

    // Build initial runs
    int start = 0;

    for (int i = 1; i <= n; i++) {
        if (i == n || arr[i] != arr[start]) {
            addRun(runs, lengths, start, i - 1);
            start = i;
        }
    }

    int[] ans = new int[queryIndices.length];

    for (int q = 0; q < queryIndices.length; q++) {

        int index = queryIndices[q];
        char newChar = queryCharacters.charAt(q);

        // If character is already the same, nothing changes
        if (arr[index] == newChar) {
            ans[q] = lengths.lastKey();
            continue;
        }

        // Find the run containing index
        Map.Entry<Integer, Integer> entry =
                runs.floorEntry(index);

        int left = entry.getKey();
        int right = entry.getValue();

        // Remove old run
        removeRun(runs, lengths, left, right);

        // Left part
        if (left < index) {
            addRun(runs, lengths, left, index - 1);
        }

        // Right part
        if (index < right) {
            addRun(runs, lengths, index + 1, right);
        }

        // Update character
        arr[index] = newChar;

        // Add the new single-character run
        addRun(runs, lengths, index, index);

        // Merge with left and right neighbors
        mergeAround(runs, lengths, arr, index);

        // Largest run length
        ans[q] = lengths.lastKey();
    }

    return ans;
    }
    private void addRun(
        TreeMap<Integer, Integer> runs,
        TreeMap<Integer, Integer> lengths,
        int start,
        int end) {

    runs.put(start, end);

    int len = end - start + 1;

    lengths.put(len, lengths.getOrDefault(len, 0) + 1);
}

private void removeRun(
        TreeMap<Integer, Integer> runs,
        TreeMap<Integer, Integer> lengths,
        int start,
        int end) {

    runs.remove(start);

    int len = end - start + 1;

    int count = lengths.get(len);

    if (count == 1) {
        lengths.remove(len);
    } else {
        lengths.put(len, count - 1);
    }
}
private void mergeAround(
        TreeMap<Integer, Integer> runs,
        TreeMap<Integer, Integer> lengths,
        char[] arr,
        int index) {

    // Merge with left
    Map.Entry<Integer, Integer> current =
            runs.floorEntry(index);

    int start = current.getKey();
    int end = current.getValue();

    Map.Entry<Integer, Integer> leftEntry =
            runs.lowerEntry(start);

    if (leftEntry != null) {

        int leftStart = leftEntry.getKey();
        int leftEnd = leftEntry.getValue();

        if (arr[leftEnd] == arr[index]) {

            removeRun(runs, lengths, leftStart, leftEnd);
            removeRun(runs, lengths, start, end);

            start = leftStart;

            addRun(runs, lengths, start, end);
        }
    }

    // Merge with right
    current = runs.floorEntry(index);

    start = current.getKey();
    end = current.getValue();

    Map.Entry<Integer, Integer> rightEntry =
            runs.higherEntry(start);

    if (rightEntry != null) {

        int rightStart = rightEntry.getKey();
        int rightEnd = rightEntry.getValue();

        if (arr[rightStart] == arr[index]) {

            removeRun(runs, lengths, start, end);
            removeRun(runs, lengths, rightStart, rightEnd);

            end = rightEnd;

            addRun(runs, lengths, start, end);
        }
    }
}
}