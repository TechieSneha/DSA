class Solution {
    public int minimumDistance(int[] nums) {
        // Map value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        // Process each value group
        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) continue;
            
            // Check consecutive triples
            for (int i = 0; i <= indices.size() - 3; i++) {
                int left = indices.get(i);
                int right = indices.get(i + 2);
                
                int dist = 2 * (right - left);
                minDist = Math.min(minDist, dist);
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}