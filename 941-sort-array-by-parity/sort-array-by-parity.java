class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int idx =0;
        for(int num: nums){
          if(num % 2 == 0){
           result[idx++] = num;
          }
        }
         for(int num: nums){
          if(num % 2 != 0){
           result[idx++] = num;
          }
        }
        return result;
    }
}