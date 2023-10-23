package graph;

import java.util.List;

//  G-11. Detect a Cycle in an Undirected Graph using DFS | C++ | Java
public class DetectCycleUndirectedDFS {
    boolean detectCycle(int V, List<List<Integer>> adj) {
        boolean[] isVis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!isVis[i]){
                if(detectCycle(i, adj, isVis, -1)) return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(int src, List<List<Integer>> adj, boolean[] isVis, int parent){
        isVis[src] = true;
        for(int i : adj.get(src)){
            if(!isVis[i]){
                if(detectCycle(i, adj, isVis, src)) return true;
            }else if(i != parent){
                return true;
            }
        }
        return false;
    }
}
