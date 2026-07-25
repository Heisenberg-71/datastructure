public class Path_with_Maximum_Gold {
    static int n;
    static int m;
    static int res=0;
    public static int getMaximumGold(int[][] grid) {
        m=grid[0].length;
        n=grid.length;
        // vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    backtrack(i,j,grid,0,new boolean[n][m]);
                }
            }
        }
        return res;
    }
    static void backtrack(int i,int j,int[][] mat,int curSum,boolean[][] vis){
        res=Math.max(res,curSum);
        if(i<0 || i>=n || j<0 || j>=m || mat[i][j]==0 || vis[i][j]){
            return;
        }
        vis[i][j]=true;
        backtrack(i+1,j,mat,curSum+mat[i][j],vis);
        backtrack(i,j+1,mat,curSum+mat[i][j],vis);
        backtrack(i,j-1,mat,curSum+mat[i][j],vis);
        backtrack(i-1,j,mat,curSum+mat[i][j],vis);
        // vis[i][j]=false;
    }
  public static void main(String[] args) {
      int[][] arr={{34,0,1,0,0,0},{0,0,2,0,1,0},{5,4,3,7,4,2},{0,0,5,0,1,4},{0,0,5,0,2,3}};
      System.out.println(getMaximumGold(arr));
  }
}