  import java.util.*;
  
  public class basic{

    public static void pattern_half_pyramid_of_pascals_triangle(int n){
        
         for( int i=1; i<=n;i++){
        for(int j=1;j<=i;j++) {
           int sum=i+j;
            if((sum%2)==0){

                System.out.print(" 1");
            }else{
                
                System.out.print(" 0");}
          
         }    
        
     System.out.println();
        }
    }
              

              public static void solid_rohumbus(int n){
        
                for( int i=1; i<=n;i++){
               for(int j=1;j<=n-i;j++) {
                //spaces
                 System.out.print("  ");
                }
                 //Stars
                 for(int j=1;j<=n;j++) {
                    System.out.print(" *"); 
                }
                    System.out.println();
                    
                }    
            
               }

               public static void hollow_rohumbus(int n){
        
                for( int i=1; i<=n;i++){
               for(int j=1;j<=n-i;j++) {
                //spaces
                 System.out.print("  ");
                }
                 //Star
                 for(int j=1;j<=n;j++){
                 if(i==1||j==1||i==n||j==n){ 
                    System.out.print(" *"); 
                }
                else{
                    System.out.print("  ");
                }
              
                   
            } 
              System.out.println();
      }    
            
  }
             

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Prompt user to enter rows and columns
            System.out.print("Enter value of n: ");
            int n = sc.nextInt();
           
        //    pattern_half_pyramid_of_pascals_triangle(n);
        // solid_rohumbus(n);/

        hollow_rohumbus(n);
            
           
        }

 
    }
}