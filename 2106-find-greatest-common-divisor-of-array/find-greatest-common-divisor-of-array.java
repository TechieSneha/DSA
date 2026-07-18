class Solution {
  public static int gcd(int a, int b){
    int divisor = a, dividend =b;
    int remainder = dividend % divisor;
    while(remainder != 0){
       dividend = divisor;
         divisor= remainder; 
         remainder = dividend % divisor;
    }
    return divisor;
  }
    public int findGCD(int[] nums) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for(int i=0;i<nums.length;i++){
        if(nums[i] < min){
          min = nums[i];
        }
        if(nums[i] > max){
          max = nums[i];
        }
      }
      int result = gcd(min, max);
      return result;
    }
}