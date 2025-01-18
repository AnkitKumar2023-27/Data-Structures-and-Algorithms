package backtrackingProblem;

public class TourofNight {
    public static boolean night(int grid[][],int row ,int col,int n,int Expected){
          
        if(row<0||row>=n||col<0||col>=n||grid[row][col]!=Expected){
            return false;
        }
        else if(Expected==n*n-1) {
               return true;
        };

     boolean Ans1= night(grid, row-2, col+1, n, Expected+1);
     boolean Ans2=night(grid, row-1, col+2, n, Expected+1);
     boolean Ans3=night(grid, row+1, col+2, n, Expected+1);
     boolean Ans4=night(grid, row+2, col+1, n, Expected+1);
     boolean Ans5=night(grid, row+2, col-1, n, Expected+1);
     boolean Ans6=night(grid, row+1, col-2, n, Expected+1);
     boolean Ans7=night(grid, row-1, col-2, n, Expected+1);
     boolean Ans8=night(grid, row-2, col-1, n, Expected+1);

    return Ans1||Ans2||Ans3||Ans4||Ans5||Ans6||Ans7||Ans8;

    }
    public static void main(String[] args) 
    {
        
              int grid[][]={{0,3,6},
                            {5,8,1},
                           {2,7,4}} ;

         
          System.out.println( night(grid, 0, 0, grid.length, 0));
    }
    
}
