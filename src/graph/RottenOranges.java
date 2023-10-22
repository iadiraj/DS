package graph;
import java.util.LinkedList;
import java.util.Queue;

//  Rotten Oranges | C++ | Java
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair2> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair2(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        int ans = 0;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};
        int cnt = 0;
        while(!q.isEmpty()){
            Pair2 node = q.poll();
            int row = node.x;
            int col = node.y;
            int t = node.t;
            ans = t;
            for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0){
                    q.add(new Pair2(nRow, nCol, t+1));
                    vis[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return ans;

    }
}
class Pair2{
    int x;
    int y;
    int t;
    Pair2(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}


//  994. Rotting Oranges

//  You are given an m x n grid where each cell can have one of three values:
//  0 representing an empty cell,
//  1 representing a fresh orange, or
//  2 representing a rotten orange.
//  Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//  Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

//  Example 1:
//  Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//  Output: 4

//  Example 2:
//  Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//  Output: -1
//  Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

//  Example 3:
//  Input: grid = [[0,2]]
//  Output: 0
//  Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

//  Constraints:
//  m == grid.length
//  n == grid[i].length
//  1 <= m, n <= 10
//  grid[i][j] is 0, 1, or 2.