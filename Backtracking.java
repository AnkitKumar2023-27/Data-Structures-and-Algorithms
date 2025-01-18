
public class Backtracking {

// sub set problem 
public static void subset( String str,String ans,int i){
     if(i==str.length()){
        if(ans.length()==0){
            System.out.println("null");
        }else{
            System.out.println(ans);
        }
        return;
}

//when we add that alphabet
      subset(str, ans+str.charAt(i), i+1);

    //   when we  dont want to add that index/
    subset(str, ans, i+1);
     
}


    public static void queen(char[][] board,int row){
            if(row==board.length){
                PrintArr(board);
                count++;
                return;
     }
     for(int j=0;j<board.length;j++){
        if(isSafe(board,row,j)){
             board[row][j]='Q';
         queen(board, row+1);
         board[row][j]='.';
        };
        
     }
    }

     //condition for checking place of queen does not effect by other 
    //  upword //
    public static boolean isSafe(char board[][], int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
 }
// left digonal/
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return  false;
            }
        }

        // right diagonal
        for(int i=row-1,j=col+1;j<board.length&&i>=0;i--,j++){
            if(board[i][j]=='Q'){
                return  false;
            }
        }
        return true;
        
    };
 static int count=0;
    
    public static  void PrintArr(char board[][]){

        System.out.println("-------NEW BOARD----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                 System.out.print(board[i][j]+" ");
                }
         System.out.println();
        }
        
       }    

// @@@@@@@@@@@   SUDOKU PROBLEM ########################################################

public static  boolean sudukoSolver( int suduko[][],int row, int col){
    // base case
        if(row==9) {
            return true;
    
        }


      int nextRow=row;
      int nextCol=col+1;
      if(col+1==9){
        nextCol=0;
        nextRow=row+1;
      }

      if(suduko[row][col]!=0){
       return sudukoSolver(suduko, nextRow, nextCol);
      }

    // kaam 
    for (int digit=1;digit<=9;digit++){
        if(isSafe(suduko ,row,col ,digit)){
            suduko[row][col]=digit;
           if (sudukoSolver(suduko,nextRow,nextCol)) {
             return true;
           } 
            suduko[row][col]=0;

        }
    
    }
     return false;

}
 public static boolean isSafe(int suduko[][],int row, int col,int digit){
    //  colum ke lia col to same rhta hai bs row  bdti jati hai 
    for(int i=0; i<=8;i++){
        if(suduko[i][col]==digit){

            return false;
        }
    }

    //  for row ke lia column hmesh se bdega end tk
    for(int j=0; j<=8;j++){
        if(suduko[row][j]==digit){
            return false;
        }
    }
// / condition 3rd meye hai ki agr bo digit particila  grid me bhji nhi hona chqaaia jisko hm ek trick use krke nikaalenge  


        int sr=(row/3)*3;
        int sc=(col/3)*3;

 for(int i=sr;i<sr+3;i++){
    for(int j=sc;j<sc+3;j++){
       if(suduko[i][j]==digit){
        return false;
       } 
    }
 }
  return true;

 }

 


 public static  void Printsuduko(int suduko[][]){

    
    for(int i=0;i<suduko.length;i++){
        for(int j=0;j<suduko.length;j++){
             System.out.print(suduko[i][j]+" ");
            }
     System.out.println();
    }
    
   }    


    public static void main(String[] args) {
    //   int  n=5;
    //     char board[][]=new char[n][n];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //              board[i][j]='.';
    //         }
    //     }    
    //       queen(board,0); 
    //       System.out.println();   
    //       System.out.println("total no of ways is =>  "+count);
    
     
    // int suduko[][]={{0,0,8,0,0,0,0,0,0},
    //                     {4,9,0,1,5,7,0,0,2},
    //                     {0,0,3,0,0,4,1,9,0},
    //                     {1,8,5,0,6,0,0,2,0},
    //                     {0,0,0,0,2,0,0,6,0},
    //                     {9,6,0,4,0,5,3,0,0},
    //                     {0,3,0,0,7,2,0,0,4},
    //                     {0,4,9,0,3,0,0,5,7},
    //                     {8,2,7,0,0,9,0,1,3}};
    //                 if ( sudukoSolver(suduko, 0, 0)) {
    //                     System.out.println("there is solution  exits ");
    //                     Printsuduko(suduko);

                        
    //                 }   else{
    //                     System.out.println("there is no Any solution of this suduko");
    //                 }
    String s;
   s="abc";
   subset(s,"",0);

    }
  
        
 // #####################Another problem of n queens problem &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    // Que. check is solution exits if exits print that one solution
    
//     public static boolean  queen(char[][] board,int row){
//         if(row==board.length){
//             // PrintArr(board);
//             count++;
//             return true;
//  }
//  for(int j=0;j<board.length;j++){
//     if(isSafe(board,row,j)){
//          board[row][j]='Q';
//      if(queen(board, row+1)){// agar phli baar me n ke lia hi solutionmil jata hai to yhi se true return kr do  
//         // other wise neeche jake change kr do aur other solutin find krne ke lia try kro to humko uske lia space ko blank krna pdega
//         return true;
//      }
//      board[row][j]='.';
//     };
    
//  } return false;
// }

//  //condition for checking place of queen does not effect by other 
// //  upword //
// public static boolean isSafe(char board[][], int row,int col){
//     for(int i=row-1;i>=0;i--){
//         if(board[i][col]=='Q'){
//             return false;
//         }
// }
// // left digonal/
//     for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
//         if(board[i][j]=='Q'){
//             return  false;
//         }
//     }

//     // right diagonal
//     for(int i=row-1,j=col+1;j<board.length&&i>=0;i--,j++){
//         if(board[i][j]=='Q'){
//             return  false;
//         }
//     }
//     return true;
    
// };
// static int count=0;

// public static  void PrintArr(char board[][]){

//     System.out.println("-------NEW BOARD----------");
//     for(int i=0;i<board.length;i++){
//         for(int j=0;j<board.length;j++){
//              System.out.print(board[i][j]+" ");
//             }
//      System.out.println();
//     }
    
//    }    

// public static void main(String[] args) {
//   int  n=5;
//     char board[][]=new char[n][n];
//     for(int i=0;i<n;i++){
//         for(int j=0;j<n;j++){
//              board[i][j]='.';
//         }
//     }    
//     if(queen(board,0))   {
//         System.out.println("solution is exits here");
//        PrintArr(board);
//         System.out.println();   
//       System.out.println("total no of ways is =>  "+count);
//     }
//       System.out.println("soluitin is not Any solution for the value of n"+n);
// }
    
}
