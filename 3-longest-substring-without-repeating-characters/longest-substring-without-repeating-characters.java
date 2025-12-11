class Solution {
    public int lengthOfLongestSubstring(String s) {
       int start =0, end =0;
       int ans =0;
       Map<Character, Integer> map = new HashMap<>();
       while(end < s.length()){
          char ch = s.charAt(end);
          map.put(ch, map.getOrDefault(ch,0) + 1);

         while(map.get(ch) > 1){
            char left = s.charAt(start);
             map.put(left, map.get(left) - 1);
            if(map.get(left) == 0) map.remove(map.get(left));
            start++;
         }
         ans = Math.max(ans, end-start +1);
         end++;
       } 
       return ans;
    }
}