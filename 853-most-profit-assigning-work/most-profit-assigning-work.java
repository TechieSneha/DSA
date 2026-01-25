class Job{
   int difficulty;
   int profit;
   public Job(int difficulty, int profit){
     this.difficulty = difficulty;
     this.profit = profit;
   } 
}
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
     Arrays.sort(worker);
     int n = difficulty.length;
     Job jobs[] = new Job[n]; 
     for(int i=0;i<n;i++){
       jobs[i] = new Job(difficulty[i], profit[i]);
     }
       Arrays.sort(jobs, new Comparator<Job>(){
         public int compare(Job j1, Job j2){
            return j1.difficulty - j2.difficulty;
         }
       });
       int i = 0;
    int maxProfit = 0;
       PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
       for(int j =0;j <worker.length;j++){
        while(i < n && jobs[i].difficulty <= worker[j]){
          maxPq.offer(jobs[i].profit);
          i++;
        }
        if(!maxPq.isEmpty()){
           maxProfit += maxPq.peek();
        }
       }
     return maxProfit;  
    }
}