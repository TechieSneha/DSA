class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for(int i=0;i<n;i++){
          int original = nums.get(i);
          int ans = -1;
          int bitmask = 1;
          while((original & bitmask) != 0){
            ans = original - bitmask;
            bitmask <<= 1;
          }
          result[i] = ans;
        }
        return result;
    }
}