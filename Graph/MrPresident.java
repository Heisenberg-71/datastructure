package Graph;

import java.util.*;

class MrPresidentGraph {
    class Edge implements Comparable<Edge>{
        int src;
        int des;
        int weight;

        public Edge(int des, int src, int weight) {
            this.des = des;
            this.src = src;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight,o.weight);
        }
        @Override
        public String toString(){
            return this.src+" "+this.des+" "+this.weight;
        }
    }
    private List<Edge> edgeList;
    private int[] p;
    private int[] r;

    public MrPresidentGraph(int n) {
        this.p=new int[n+1];
        this.r=new int[n+1];
        for(int i=0;i<=n;i++){
            p[i]=i;
        }
        this.edgeList=new ArrayList<>();
    }
    public void addEdge(int src,int des,int weight){
        edgeList.add(new Edge(src,des,weight));
    }
    public int find(int x){
        if(p[x]!=x){
            p[x]=find(p[x]);
        }
        return p[x];
    }
    public boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py){
            return false;
        }
        if(r[px]<r[py]){
            p[px]=py;
        }else if(r[px]>r[py]){
            p[py]=px;
        } else{
            p[py]=px;
            r[px]++;
        }
        return true;
    }
    public void buildMst(){
        Collections.sort(edgeList);
        ArrayList<Edge> res=new ArrayList<>();
        int total=0;
        for(Edge e:edgeList){
            if(union(e.src,e.des)){
                res.add(e);
                total+=e.weight;
            }
        }
        System.out.println(total);
    }
}
public class MrPresident {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=3;
        int e=3;
        int k=25;
        int[][] arr={{1,2,10},{2,3,20},{3,1,30}};
        MrPresidentGraph g=new MrPresidentGraph(n);
        for(int[] a:arr){
            g.addEdge(a[0],a[1],a[2]);
        }
        g.buildMst();
    }
}
