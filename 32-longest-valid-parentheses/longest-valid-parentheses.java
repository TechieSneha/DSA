class Solution {
    public int longestValidParentheses(String s) {
        int ans1=0;
        int open =0, close =0;
        //Left to Right traversal
        for(int i=0; i<s.length();i++){
          if(s.charAt(i) == '('){
            open++;
          }else{
           close++;
          }
          if(open == close){
           ans1 = Math.max(ans1, open + close);
          }else if(close > open){
            open = close =0;
          }
        }
        //Right to Left traversal
        open = close = 0;
        int ans2=0;
        for(int i=s.length()-1; i>=0; i--){
          if(s.charAt(i) == '('){
            open++;
          }else{
           close++;
          }
          if(open == close){
           ans2 = Math.max(ans2, open + close);
          }else if(open > close){
            open = close =0;
          }
        }
        int result = Math.max(ans1, ans2);
        return result;
    }
}