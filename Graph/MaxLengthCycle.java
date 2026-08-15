package Graph;

import java.util.*;

 class MaxLengthGraph {
    private int[] parent;
    private int[] rank;
    MaxLengthGraph(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py){
            return false;
        }
        if(rank[px]<rank[py]){
            parent[px]=py;
        }else if(rank[px]>rank[py]){
            parent[py]=px;
        }else {
            parent[py]=px;
            rank[px]++;
        }
        return true;
    }
    int get(HashMap<Integer,List<Integer>> adj,int src,int des){
        HashSet<Integer> vis=new HashSet<>();
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0});
        vis.add(src);
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int va=cur[0];
            int dist=cur[1];
            if(va==des){
                return dist;
            }
            for(int a:adj.get(va)){
                if(!vis.contains(a)){
                    q.add(new int[]{a,dist+1});
                    vis.add(a);
                }
            }
        }
        return -1;
    }
}
public class MaxLengthCycle {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        MaxLengthGraph g=new MaxLengthGraph(8);
        int[][] arr={
                {0,1},
                {1,3},
                {3,5},
                {5,6},
                {6,7},
                {4,5},
                {2,4},
                {0,2},
                {8,6}
        };
        int max=0;
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        for(int[] e:arr){
            int x=e[0];
            int y=e[1];
            if(g.union(x,y)){
               adj.putIfAbsent(x,new ArrayList<>());
               adj.putIfAbsent(y,new ArrayList<>());
               adj.get(x).add(y);
               adj.get(y).add(x);
            }else{
                int dist= g.get(adj,x,y);
                if(dist!=-1){
                    max=Math.max(dist,max);
                }
            }
        }
        System.out.println(max);
    }
}
