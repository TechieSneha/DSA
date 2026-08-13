class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left= 0;
        int result = 0;
        for(int j=0;j<nums.length;j++){
           map.put(nums[j], map.getOrDefault( nums[j],0) +1);
           // Shrink the window if frequency exceeds k
           while(map.get(nums[j]) > k){
            map.put(nums[left], map.get(nums[left])-1);
            left++;
           }
           result = Math.max(result, j-left+1);
        }
        return result;
    }
}