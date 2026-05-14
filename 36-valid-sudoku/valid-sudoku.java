class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
             char num = board[i][j];
             if(num == '.'){
               continue;
             }
             //Rows
             if(!set.add(num  + "row" + i)){
              return  false;
             }
             //Columns
             if(!set.add(num  + "col" + j)){
              return false;
             }
             int boxRow = i/3;
             int boxCol = j/3;

             if(!set.add(num  + "box" + boxRow + "_"+boxCol)){
             return false;
             }
            }
        }
        return true;
    }
}