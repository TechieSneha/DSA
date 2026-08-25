class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
         set.add(num); 
        }
        int missingElement =k;
        while(set.contains(missingElement)){
             missingElement += k;
        }
        return missingElement;
    }
}