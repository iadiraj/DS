package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Graph{
    ArrayList<Integer> ans;
    Queue<Integer> q;
    boolean[] vis;
    BreadthFirstSearch(int n) {
        super(n);
        ans = new ArrayList<>();
        q = new LinkedList<>();
        vis = new boolean[n+1];
    }
    public void bfs(){
        q.add(1);
        vis[1] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);
            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        for(Integer it : ans){
            System.out.print(it + " ");
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch g = new BreadthFirstSearch(5);
        g.addEdge(1, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(5, 4);
//        g.print();
        g.bfs();
    }
}
