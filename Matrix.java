
// import java.util.Scanner;

 public class Matrix {

     public static void SpiralSearch(int array[][]){
        int row=0;
        int col=0;
        int lastRow=array.length-1;
       int lastCol=array[0].length-1;
        while(row<=lastRow && col<=lastCol){

            //Top
            for(int j=col;j<=lastCol;j++){
                System.out.println(array[row][j]+" ");
            };


    
            //Right
            for(int i=row+1;i<=lastRow;i++){
                System.out.println(array[i][lastCol]+" ");
            };

            //bottom
            for(int j=lastCol-1;j>=col;j--){
                if(row==lastRow){
                    break;
                }
                System.out.println(array[lastRow][j]+" ");
            };

              //Left
              for(int i=lastRow-1;i>=row+1;i--){
                if(col==lastCol){
                    break;
                }
                System.out.println(array[i][col]+" ");
            };
          row++;
          col++;
          lastCol--;
          lastRow--;   
            
        }
        System.out.println();
     }

     
     public static int sumofDigonal(int array[][]){
        int n =array.length;
       
        int sum=0;
        for(int i=0;i<n;i++){
            for( int j=0;j<array[0].length;j++){
                if(i==j){
                    sum+=array[i][j];
                }else if((i+j)==n-1){
                    sum+=array[i][j];
                }
            }
        } 
        return sum;
        

     }
   
 public static void main(String[] args) {
    //        int matris[][]=new int[3][3];
    //        int n=matris.length;
    //    int m=matris[0].length;
    //    try (Scanner sc = new Scanner(System.in)) {
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //              matris[i][j]=sc.nextInt();
    //                 }
    //        }
    // }
    //    for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){

    //         System.out.print( matris[i][j]+" ");
          
    //             }
    //             System.out.println();  
                
                
    //    }

       int array[][]={{30,32,34},
                    {35,36,38},
                {40,42,46}};
   
        // SpiralSearch(array); 
      System.out.println(sumofDigonal(array));   
    }

}
