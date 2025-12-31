class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean dfs(int i, int j, int n, int m, int[][] grid){
        if (i == n - 1) return true; // reached bottom row

        grid[i][j] = 2; // mark visited

        for (int k = 0; k < 4; k++){
            int x = i + dir[k][0];
            int y = j + dir[k][1];

            if (check(x, y, n, m) && grid[x][y] == 0){
                if (dfs(x, y, n, m, grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(int x, int y, int n, int m){
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public boolean possible(int day, int row, int col, int[][] cells){
        int[][] grid = new int[row][col];

        // flood cells for given day
        for (int i = 0; i < day; i++){
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        // try DFS from top row
        for (int j = 0; j < col; j++){
            if (grid[0][j] == 0){
                if (dfs(0, j, row, col, grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1, r = cells.length;
        int days = 0;

        while (l <= r){
            int mid = l + (r - l) / 2;
            if (possible(mid, row, col, cells)){
                days = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return days;
    }
}