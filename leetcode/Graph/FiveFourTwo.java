import java.util.LinkedList;
import java.util.Queue;

public class FiveFourTwo {

    public static class pair {
         int row;
          int col;
          int dis;
          public pair( int r, int c,int d){
               this.row=r;
                this.col=c;
                 this.dis=d;

          } 
    
        
    }

     public static int[][] updateMatrix(int[][] mat) {
       int n=mat.length;
       int m=mat[0].length;
       int res[][]=new int[n][m];
       boolean vis[][]= new boolean[n][m];
       Queue<pair>q=new LinkedList<>();
       for( int i=0;i<n;i++){
        for( int j=0; j<m;j++){
            if(!vis[i][j]&&mat[i][j]==0){
                q.add(new pair(i, j,0));
                res[i][j]=0;
                vis[i][j]=true;
            }
        }
       }

       int r1[]={1,0,-1,0};
       int c1[]={0,-1,0,1};

       while (!q.isEmpty()){
        pair p=q.remove();
        int r=p.row;
        int c=p.col;
        int d=p.dis;
        res[r][c]=d;
        for(int i=0;i<4;i++){
            int nrow=r+r1[i];
            int ncol=c+c1[i];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&!vis[nrow][ncol]){
                q.add(new pair(nrow, ncol, d+1));
                
                  vis[nrow][ncol]=true;

            }
        }
        
       }
    

          return res;
    }
  public static void main(String[] args) {
   int grid[][]= {{0,0,0},{0,1,0},{0,0,0}};

    int res[][]=updateMatrix(grid);
  
    
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    
    
  }
    
}
