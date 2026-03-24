class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
       int[][] result = new int[n][m]; 
       int suffix =1;
       for(int  i=n-1;i>=0;i--){
         for(int j=m-1;j>=0;j--){
            result[i][j] = suffix;
            suffix = (int)((1L * suffix * grid[i][j]) % MOD);
         }
       }
       int prefix =1;
       for(int i=0;i<n;i++){
        for(int j =0;j<m;j++){
           result[i][j] = (int)((1L * prefix * result[i][j]) % MOD);
            prefix = (int)((1L * prefix * grid[i][j]) % MOD);
        }
       }
       return result;
    }
}