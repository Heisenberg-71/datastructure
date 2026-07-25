import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KruskalGraph {
    class Edge implements Comparable<Edge>{
        int src;
        int des;
        int weight;
        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge other){
            return Integer.compare(this.weight,other.weight);
        }
    }
    private int[] parent;
    private int[] rank;
    private List<Edge> edges;
    public KruskalGraph(int n) {
        this.parent=new int[n+1];
        this.rank=new int[n+1];
        this.edges=new ArrayList<>();
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
    }
    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    private boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py){
            return false;
        }
            if(rank[px]<rank[py]){
                parent[px]=py;
            }
            else if(rank[px]>rank[py]){
                parent[py]=px;
            }
            else{
                parent[py]=px;
                rank[py]++;
            }
        return true;
    }
    public void addEdges(int src,int des,int weight){
        edges.add(new Edge(src, des, weight));
    }
    public void buildMST(){
        Collections.sort(edges);
        ArrayList<Edge> res=new ArrayList<>();
        for(Edge edge:edges){
            if(union(edge.src, edge.des)){
                res.add(edge);
            }
        }
        int totalWeight=0;
        for(Edge edge:res){
            System.out.println(edge.src+" - "+edge.des+" = "+edge.weight);
            totalWeight+=edge.weight;
        }
        System.out.println("Total Weight= "+totalWeight);
    }
}


public class Kruskal{
    public static void main(String args[]){
        KruskalGraph g=new KruskalGraph(11);
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
        for(int[] a:arr){
            g.addEdges(a[0], a[1], a[2]);
        }
        g.buildMST();
    }
}