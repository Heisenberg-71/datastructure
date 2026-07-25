import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Graph{
    class Edge{
        int node;
        int weight;
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return node+" "+weight;
        }
    }
   private Map<Integer,List<Edge>> g=new HashMap<>();
    public void addEdges(int src,int des,int weight){
        addNode(src);
        addNode(des);
        g.get(src).add(new Edge(des, weight));
        g.get(des).add(new Edge(src, weight));
    }
    public void addNode(int n){
        g.putIfAbsent(n, new ArrayList<>());
    }
    public int spanningTree(int src){
        PriorityQueue<Edge> p=new PriorityQueue<>((a,b)->a.weight-b.weight);
        HashSet<Integer> vis=new HashSet<>();
        int totalWeight=0;
        p.add(new Edge(src,0));
        while(!p.isEmpty()){
            Edge cur=p.poll();
            if(vis.contains(cur.node)){
                continue;
            }
            vis.add(cur.node);
            totalWeight+=cur.weight;
            for(Edge e:g.get(cur.node)){
                if(!vis.contains(e.node)){
                    p.add(new Edge(e.node, e.weight));
                }
            }
        }
        return totalWeight;
    }
}


public class Prims {
    public static void main(String[] args) {
        int[][] arr={
            {1,3,2},
            {1,2,7},
            {3,4,3},
            {2,4,8},
            {4,5,4},
            {5,7,8},
            {7,8,2},
            {5,8,5},
            {5,6,2},
            {6,9,3},
            {9,10,4},
            {0,1,3}
        };
        Graph g=new Graph();
        for(int[] a:arr){
            g.addEdges(a[0], a[1], a[2]);
        }
        System.out.println("Total Weight : "+g.spanningTree(arr[0][0]));
        
    }
}