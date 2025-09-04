import java.util.LinkedList;
import java.util.Queue;


public  class NineNineFour {
 public static class pair{
    int row;
     int col;
      int tm;
      public pair( int row, int col , int tm){
         this.row=row;
         this.col=col;
         this.tm=tm;
      }
 }

     public static int orangesRotting(int[][] grid) {
        int n=grid.length;
         int m=grid[0].length;
        int vis[][]= new int[n][m];
        Queue<pair>q=new LinkedList<>();
        for( int i=0;i<n;i++){
            for( int j=0;j<m;j++){
                if(grid[i][j]==2){
                   q.add(new pair(i, j, 0));
                   vis[i][j]=2;
            
                }else{
                    vis[i][j]=0;
                }
            }
        }

        int row[]={-1,0,1,0};

        int col[]={0,-1,0,1};

          int t=0;


        while (!q.isEmpty()) {
            pair e=q.remove();
            int r=e.row;
             int c=e.col;
             t=e.tm;
             for( int i=0;i<4;i++){
               
                    int nrow=r+row[i];
                    int ncol=c+col[i];
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1){
                        q.add(new pair(nrow, ncol, t+1));
                        vis[nrow][ncol]=2;
                    
                }
            }
                   }

       for( int i=0;i<n;i++){
            for( int j=0;j<m;j++){
                if(vis[i][j]!=2&&grid[i][j]==1){
                    return -1;

                }  
            }
        }
        return t;


        
    }

public static void main(String[] args) {
     int grid[][] ={{2,1,1},{1,1,0},{0,1,1}};

     System.out.println(orangesRotting(grid));

    
}
    
}
