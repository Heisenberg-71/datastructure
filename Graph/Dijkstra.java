import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

class DijkstraGraph {
    private class Edge{
        int node;
        int weight;
        public Edge(int node, int weight) {
            this.node=node;
            this.weight = weight;
        }
    }
    private HashMap<Integer,ArrayList<Edge>> g;
    public DijkstraGraph() {
        this.g = new HashMap<>();
    }
    private void addNodes(int x){
        g.putIfAbsent(x, new ArrayList<>());
    }
    public void addEdges(int src,int des,int weight){
        addNodes(src);
        addNodes(des);
        g.get(src).add(new Edge( des, weight));
        g.get(des).add(new Edge( src, weight));
    }
    public void shortestPath(int n){
        int[] s=new int[n+1];
        Arrays.fill(s, Integer.MAX_VALUE);
        s[1]=0;
        HashSet<Integer> vis=new HashSet<>();
        PriorityQueue<Edge> p=new PriorityQueue<>((a,b)->a.weight-b.weight);
        p.add(new Edge(1,0));
        while (!p.isEmpty()) {
            Edge cur=p.poll();
            vis.add(cur.node);
            for(Edge e:g.get(cur.node)){
                if(!vis.contains(e.node)){
                if(cur.weight+e.weight<s[e.node]){
                    s[e.node]=cur.weight+e.weight;
                    p.add(new Edge(e.node, s[e.node]));
                }
            }
            }
        }
        System.out.println(Arrays.toString(s));
    }
}
public class Dijkstra {
    public static void main(String[] args) {
        int[][] arr={
        {1,3,7},
        {1,2,3},
        {2,4,2},
        {2,3,1},
        {3,4,2},
        {3,5,6},
        {4,5,4}};
        DijkstraGraph g=new DijkstraGraph();
    for(int[] a:arr){
        g.addEdges(a[0], a[1], a[2]);
    }
    g.shortestPath(5);
    }
}
