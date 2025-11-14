class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      if (nums == null) return res;
      // important: sort to handle duplicates
        Arrays.sort(nums);
      boolean[] visited = new boolean[nums.length];
      backTrack(res, nums, new ArrayList<>(), visited); 
      return res;
    }
    public void backTrack(List<List<Integer>> res,int[] nums,List<Integer> curr, boolean[] visited){
        if(curr.size() == nums.length){
           res.add(new ArrayList<>(curr));
           return;
        }
        for(int i=0;i<nums.length;i++){
           if(visited[i]) continue;
           // Skip duplicates: if the current number is the same as previous and previous
            // hasn't been used in this position, skip to avoid duplicate permutations.
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
           curr.add(nums[i]);
           visited[i] = true;
           backTrack(res,nums,curr, visited);
           curr.remove(curr.size()-1);
           visited[i] = false;
        }
    }
}