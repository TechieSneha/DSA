class Solution {
    public long minimumTime(int[] d, int[] r) {
        long d1 =  d[0], d2= d[1], r1=r[0], r2=r[1];
        long low = d1 + d2;
        long high = 2 * (d1 + d2);
        long ans = high;
        while(low <= high){
         long target = low + (high - low) /2;
         if(isPossible(target,d1, d2, r1,r2)){
           ans = target;
           high = target -1;
         }else{
            low = target + 1;
         }
        }
        return ans;
    }
    public boolean isPossible(long time,long d1,long d2,long r1,long r2){
       long a1 = time  - (time/r1);
       long a2 = time  - (time/r2);
       long lcm = lcm(r1, r2);
       long cf = time /  lcm;

       long a3 = time - (time/r1 +time/r2 -cf);

       long d3 = a1 + a2 -a3;
       return (d1 <=  a1 && d2 <= a2 && d1 + d2 <= d3);
    }
    private long lcm(long a, long b){
        return a /gcd(a, b) * b;
    }
    private long gcd(long a, long b){
       return b==0 ? a: gcd(b, a%b); 
    }
}