class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
        set.add(num);
        }
        int output =0;
        for(int num: set){
           if(!set.contains(num-1)){
             int current = num;
             
             int count =1;

             while(set.contains(current + 1)){
               current++;
               count++;
             }
             output = Math.max(output, count);
           }
        }
        return output;
    }
}