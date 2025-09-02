public class SevenThreeSeven {
 

  public  int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean vis[][]=new boolean[image.length][image[0].length];
     int orgCol=image[sr][sc];
     if(color==orgCol){
        return image;
     }
     helper(image, sr,sc,color, vis,orgCol);
     return image;
        
    }
    public static void helper( int image[][], int sr, int sc, int color , boolean vis[][],int orgCol){
      if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||image[sr][sc]!=orgCol||vis[sr][sc]){
        return ;
      
      }
         vis[sr][sc]=true;
         image[sr][sc]=color;
       
    
     
      helper(image, sr+1, sc, color, vis,orgCol);
      helper(image, sr, sc+1, color, vis,orgCol);
      helper(image, sr, sc-1, color, vis,orgCol);
      helper(image, sr-1, sc, color, vis,orgCol);

    }   
    
    
}
