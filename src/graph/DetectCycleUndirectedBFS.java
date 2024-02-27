package graph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  G-11. Detect a Cycle in an Undirected Graph using BFS | C++ | Java
public class DetectCycleUndirectedBFS {
    boolean detectCycle(int V, List<List<Integer>> adj) {
        boolean[] isVis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!isVis[i]){
                if(detectCycle(i, adj, isVis)) return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(int src, List<List<Integer>> adj, boolean[] isVis){
        Queue<Pair3> q = new LinkedList<>();
        isVis[src] = true;
        q.add(new Pair3(src, -1));
        while(!q.isEmpty()){
            Pair3 p = q.poll();
            int curr = p.curr;
            int prev = p.prev;
            for(int i : adj.get(curr)){
                if(!isVis[i]){
                    isVis[i] = true;
                    q.add(new Pair3(i, curr));
                }else if(i != prev){
                    return true;
                }
            }
        }
        return false;
    }
}
class Pair3{
    int curr;
    int prev;
    public Pair3(int curr, int prev) {
        this.curr = curr;
        this.prev = prev;
    }
}
