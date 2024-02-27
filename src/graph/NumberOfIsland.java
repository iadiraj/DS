package graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
//  G-8. Number of Islands | Number of Connected Components in Matrix | C++ | Java
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVis = new boolean[n][m];
        int count = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(!isVis[row][col] && grid[row][col] == '1'){
                    count++;
                    bfs(row, col, grid, isVis);
                }
            }
        }
        return count;
    }
    public static void bfs(int row, int col, char[][] grid, boolean[][] isVis){
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        isVis[row][col] = true;
        q.add(new Pair(row, col));
        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair index = q.poll();
            int ro = index.row;
            int co = index.col;

            for (int i = 0; i < 4; i++) {
                int newRow = ro + deltaRow[i];
                int newCol = co + deltaCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !isVis[newRow][newCol] && grid[newRow][newCol] == '1') {
                    q.add(new Pair(newRow, newCol));
                    isVis[newRow][newCol] = true;
                }
            }
        }
    }
}

//  200. Number of Islands

//  Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

//  Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//  ]
//  Output: 3

//  Constraints:

//  m == grid.length
//  n == grid[i].length
//  1 <= m, n <= 300
//  grid[i][j] is '0' or '1'.