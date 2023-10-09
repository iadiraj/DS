package graph;

import java.util.ArrayList;

public class DepthFirstSearch extends Graph{
    ArrayList<Integer> ans;
    boolean[] vis;
    DepthFirstSearch(int n){
        super(n);
        ans = new ArrayList<>();
        vis = new boolean[n+1];
    }
    public void dfs(){
        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                dfs(i);
            }
        }
        for(Integer it : ans){
            System.out.print(it + " ");
        }
    }
    public void dfs(int x){
        vis[x] = true;
        ans.add(x);
        for(Integer it : adj.get(x)){
            if(!vis[it]){
                dfs(it);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(5);
        g.addEdge(1, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(5, 4);
//        g.print();
        g.dfs();
    }
}
