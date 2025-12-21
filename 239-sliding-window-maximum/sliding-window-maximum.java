class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n ==0 && k==0) return new int[0];
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int start =0, end=0, idx =0;
        while(end < n){
            // Remove smaller elements from the back
            while(!q.isEmpty() && q.peekLast() < nums[end]){
               q.pollLast();
            }
             q.offerLast(nums[end]);
             // When window size reaches k
             if(end -start + 1 == k){
              ans[idx++] = q.peekFirst();
              // Remove element going out of window
              if(q.peekFirst() == nums[start]){
                q.pollFirst();
              } 
              start++; 
             }
             end++;
        }
        return ans;
    }
}