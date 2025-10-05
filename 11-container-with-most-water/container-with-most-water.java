class Solution {
    public int maxArea(int[] input) {
      int output =0;
      int left =0;
      int right = input.length-1;
      while(left < right){
       output = Math.max(output, Math.min(input[left], input[right])* (right-left));
       if(input[left] < input[right]){
          left++;
       }else{
          right--;
       }
      }  
      return output;  
    }
}