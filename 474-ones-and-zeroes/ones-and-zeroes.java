class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        Integer[][][] memo = new Integer[length][m+1][n+1];
        return dfs(strs, 0, m, n, memo);
    }
    private int dfs(String[] strs,int index, int m, int n, Integer[][][] memo){
        if(index == strs.length) return 0;

        if(memo[index][m][n]!= null) return memo[index][m][n];
        int zeros =0, onces =0;
        for(char ch: strs[index].toCharArray()){
           if(ch == '0') zeros++;
           else onces++;
        }
        int skip = dfs(strs,index + 1, m, n,memo);

        int take =0;
        if(m >= zeros && n >= onces){
           take = 1+ dfs(strs,index + 1, m -zeros, n-onces,memo);
        }
        memo[index][m][n] = Math.max(skip, take);
        return memo[index][m][n] ;
    }
}