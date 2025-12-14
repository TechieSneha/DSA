class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
        long windowSum = 0;
        long maxSum = 0;
        int left = 0;
     
      for (int right = 0; right < nums.length; right++) {
            // If duplicate exists, shrink window from left
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }

            // Add current element
            set.add(nums[right]);
            windowSum += nums[right];

            // If window size exceeds k, shrink it
            if (right - left + 1 > k) {
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }

            // Check if valid window of size k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}