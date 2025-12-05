class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
          prefixSum[i] = prefixSum[i-1] + nums[i];
        }

       int count =0;
        int totalSum = prefixSum[n-1];
        for(int k=0;k<n-1;k++){
        int firstSum = prefixSum[k];
        int lastSum = totalSum -firstSum; 
         if(Math.abs(firstSum -lastSum) % 2 ==0){
          count++;
          }
        }
        return count; 
    }
}