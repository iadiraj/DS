package graph;

import java.util.ArrayList;

public class Graph {
    int n;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int n){
        this.n = n;
        adj = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int i, int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    public void print(){
        for(int i = 0; i < adj.size(); i++){
            System.out.print(i + "-> ");
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j));
                if(j == adj.get(i).size()-1) continue;
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}
