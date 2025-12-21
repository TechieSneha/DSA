class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] visted = new boolean[26];
        for(char ch:s.toCharArray()){
           freq[ch -'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char c :s.toCharArray()){
          int idx = c -'a';
          freq[idx]--;
          if(visted[idx]) continue;
          while(!stack.isEmpty() &&
              stack.peekLast() > c
               && freq[stack.peekLast() -'a'] > 0){
             visted[stack.pollLast() -'a'] = false;
          }
          stack.offerLast(c);
          visted[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: stack){
          sb.append(ch);
        }
        return sb.toString();
    }
}