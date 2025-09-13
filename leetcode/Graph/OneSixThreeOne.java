import java.util.Arrays;
import java.util.PriorityQueue;

public  class OneSixThreeOne {
   public  static  class pair implements Comparable<pair>{
        int row; int col; 
         int diff;
          public pair ( int r, int c, int d){
            this.row=r;
             this.col=c;
              this.diff=d;
          }
      public int compareTo(pair p){
        return this.diff-p.diff;
      }  
        }
     public static int minimumEffortPath(int[][] heights) {
          int n=heights.length;
           int m=heights[0].length;
            int res[][]=new int[n][m];
            for( int i=0; i<n;i++){
                Arrays.fill(res[i],Integer.MAX_VALUE);
            }

            res[0][0]=0;
            PriorityQueue<pair>pq=new PriorityQueue<>();
            pq.add(new pair(0, 0, 0));
            int dr[]={-1,0,1,0};
             int dc[]={0,-1,0,1};

             while (!pq.isEmpty()) {
                pair p=pq.remove();
                int r=p.row;
                 int c=p.col;
                  int d=p.diff;

               if(r==n-1&&c==m-1){
                return d;
               }
                for( int i=0;i<4;i++){
                    int nr=r+dr[i]; 
                    int nc=c+dc[i];

                    if(nr>=0&&nr<n&&nc>=0&&nc<m){
                        int newEfforts=Math.max(Math.abs(heights[r][c]-heights[nr][nc]),d);
                        if(newEfforts<res[nr][nc]){
                            res[nr][nc]=newEfforts;
                            pq.add(new pair(nr, nc,newEfforts));

                        }
                    }
                }
               
          
          
          
            }
     
  return 0;
       
        
       }

        
    
    public static void main(String[] args) {
           int[][] heights = {
        {1, 2, 2},
        {3, 8, 2},
        {5, 3, 5}
    };

    System.out.println("Minimum Effort Path = " + minimumEffortPath(heights));
    }
}
