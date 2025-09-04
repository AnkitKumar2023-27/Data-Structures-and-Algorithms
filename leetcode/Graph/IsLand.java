import java.util.LinkedList;
import java.util.Queue;

public class IsLand {
     public static class pair{
    int row;
     int col;
      
      public pair( int row, int col ){
         this.row=row;
         this.col=col;
        
      }
 }

 public static void bfs( int row , int col, int grid[][],boolean vis[][]){
     Queue<pair>q=new LinkedList<>();
     q.add(new pair(row,col));
     vis[row][col]=true;
        
           int n=grid.length;
         int m=grid[0].length;
        int r1[]={1,0,-1,0};
        int c1[]={0,-1,0,1};
        


        while (!q.isEmpty()) {
            pair e=q.remove();
            int r=e.row;
             int c=e.col;
   // for four direction
   for( int i=0; i<4;i++){
       int nrow=r+r1[i];
       int ncol=c+c1[i];
   if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&!vis[nrow][ncol]&&grid[nrow][ncol]==1){
                    q.add(new pair(nrow, ncol));
                    vis[nrow][ncol]=true;

                        


           //for 8 dirctions
            //  for( int i=-1;i<=1;i++){
            //     for( int j=-1;j<=1;j++){
            //          int nrow=r+i;
            //          int ncol=c+j;
               
                    }
               
                   
                    
                    
                 
                    
                }
            }
                   

     


 }

     public static int TotalIsland(int[][] grid) {
        int n=grid.length;
         int m=grid[0].length;
          boolean vis[][]= new  boolean[n][m];
         int count=0;
        for( int i=0;i<n;i++){
            for( int j=0;j<m;j++){
                if(!vis[i][j]&&grid[i][j]==1){
                    bfs(i,j,grid,vis);
                    count ++;
            
                }
            }
          
        }

          return count;
    }
    //   public void dfs(char[][] grid, int row, int col){
    //     if(row>=grid.length||col>=grid[0].length||row<0||col<0||grid[row][col]=='0'){
    //         return;
    //     }
    //     grid[row][col]='0';
    //     dfs(grid,row+1,col);
    //     dfs(grid,row-1,col);
    //     dfs(grid,row,col+1);
    //     dfs(grid,row,col-1);
    // }
    // public int numIslands(char[][] grid) {
    //     int cnt=0;
    //     for(int i=0;i<grid.length;i++){
    //         for(int j=0;j<grid[0].length;j++){
    //             if(grid[i][j]=='1'){
    //                 dfs(grid,i,j);
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;
    // }
// ?????????????????????????????????????    dfs method     ///////////////////////////////

    // Directions for 4-dir
// int[] dr = {-1, 1, 0, 0};
// int[] dc = {0, 0, -1, 1};

// // Directions for 8-dir (include diagonals)
// // int[] dr = {-1,-1,-1,0,0,1,1,1};
// // int[] dc = {-1,0,1,-1,1,-1,0,1};

// public void dfs(int r, int c, int[][] grid, boolean[][] vis) {
//     int n = grid.length, m = grid[0].length;
//     vis[r][c] = true;

//     for (int i = 0; i < dr.length; i++) {
//         int nr = r + dr[i];
//         int nc = c + dc[i];

//         if (nr >= 0 && nr < n && nc >= 0 && nc < m 
//             && !vis[nr][nc] && grid[nr][nc] == 1) {
//             dfs(nr, nc, grid, vis);
//         }
//     }
// }

    public static void main(String[] args) {
//       int[][] grid = {
//     { 1, 1, 0, 0, 0 },
//     { 0, 1, 0, 0, 1 },
//     { 1, 0, 0, 1, 1 },
//     { 0, 0, 0, 0, 0 },
//     { 1, 0, 1, 1, 0 }
// };
// output is 5
int[][] grid = {
    {1, 1, 1, 1, 0},
    {1, 1, 0, 1, 0},
    {1, 1, 0, 0, 0},
    {0, 0, 0, 0, 0}
};

        System.out.println(TotalIsland(grid));
        
    }
    
}
