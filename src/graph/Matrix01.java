package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair4> q = new LinkedList<>();
        boolean[][] isVis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j < m; j++){
                row.add(0);
                if(mat.get(i).get(j) == 1){
                    q.add(new Pair4(i, j, 0));
                    isVis[i][j] = true;
                }
            }
            ans.add(row);
        }
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};
        while(!q.isEmpty()){
            Pair4 node = q.poll();
            int row = node.x;
            int col = node.y;
            int dist = node.d;
            ans.get(row).set(col, dist);
            for(int i = 0; i < 4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !isVis[nRow][nCol]){
                    isVis[nRow][nCol] = true;
                    q.add(new Pair4(nRow, nCol, dist+1));
                }
            }
        }
        return ans;
    }
}
class Pair4{
    int x;
    int y;
    int d;
    public Pair4(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
