package graph;

//  G-7. Number of Provinces | C++ | Java | Connected Components
public class Provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVis = new boolean[n];
        int province = 0;
        for(int i = 0; i < n; i++){
            if(!isVis[i]){
                province++;
                dfs(i, isConnected, isVis);
            }
        }
        return province;
    }
    public static void dfs(int v, int[][] isConnected, boolean[] isVis){
        isVis[v] = true;
        for(int i = 0; i < isConnected[v].length; i++){
            if(!isVis[i] && isConnected[v][i] == 1){
                isVis[i] = true;
                dfs(i, isConnected, isVis);
            }
        }
    }
}

//  547. Number of Provinces

//  There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
//  A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//  You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//  Return the total number of provinces.

//  Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//  Output: 2

//  Constraints:
//  1 <= n <= 200
//  n == isConnected.length
//  n == isConnected[i].length
//  isConnected[i][j] is 1 or 0.
//  isConnected[i][i] == 1
//  isConnected[i][j] == isConnected[j][i]