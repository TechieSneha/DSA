class Solution {
    List<List<String>> ans= new ArrayList<>();
    public List<List<String>> partition(String s) {
       helper(s, new ArrayList<>());
       return ans; 
    }
    public void helper(String s, List<String> currentPartitions){
       if(s.isEmpty()){
          ans.add(new ArrayList<>(currentPartitions));
          return;
       }
       for(int partition =1;partition<=s.length();partition++){
         String prefix = s.substring(0,partition);
         String remaining = s.substring(partition);
         if(isPalindrome(prefix)){
           currentPartitions.add(prefix);
           helper(remaining, currentPartitions);
           currentPartitions.removeLast();
         }
       }
    }
   public boolean isPalindrome(String str){
     int l =0, r = str.length() -1;
     while(l < r){
       if(str.charAt(l) != str.charAt(r)) return false;
       l++;
       r--;
     }
     return true;
   }
}