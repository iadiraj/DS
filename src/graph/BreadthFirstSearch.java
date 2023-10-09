package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Graph{
    BreadthFirstSearch(int n) {
        super(n);
    }
    public void bfs(){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
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
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
//        g.print();
        g.bfs();
    }
}
