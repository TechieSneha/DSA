class Solution {
    public int minimumDifference(int[] nums, int k) {
        if( k<= 1) return 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;
       for(int i=0;i+k-1<n;i++){
          int diff = nums[i+k-1] - nums[i];
          minDiff = Math.min(minDiff, diff);
       }
       return minDiff;
    }
}