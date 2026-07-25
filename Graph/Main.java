import java.util.Arrays;
class MainGraph {
    private int[] parent;
    private int no_com;
    MainGraph(int n){
        this.parent=new int[n];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        this.no_com=n;
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(py==px){
            return true;
        }
        parent[py]=px;
        no_com-=1;
        return false;
    }
    public int getNo_com(){
        return no_com;
    }
}
public class Main{
    public static void main(String args[]){
        MainGraph g=new MainGraph(3);
        int[] arr=new int[2];
        if(g.union(1,2)) {
            arr[0]=1;
            arr[1]=2;
        } if(g.union(1,3)) {
            arr[0]=1;
            arr[1]=3;
        } if(g.union(2,3)) {
            arr[0]=2;
            arr[1]=3;
        }
        System.out.println(Arrays.toString(arr));
    }
}