import java.util.Arrays;

public class ClimbingStair {

    public static int ClimbingStairWays(int n){
        if(n==0||n==1){
            return 1;

        }

    int ways[]=new int[n+1];
    Arrays.fill(ways,-1);  
    if(ways[n]!=-1){
        return  ways[n];
    }
   ways[n]=ClimbingStairWays(n-1)+ClimbingStairWays(n-2);
   return ways[n];

    }
    public static int ClimbingStairTAb(int n){

         int ways[]=new int[n+1];
         ways[0]=1;
         

         for(int i=1;i<=n;i++){

            if(i==1){
                  ways[i]=ways[i-1];
             
            }else{
                     ways[i]=ways[i-1]+ways[i-2];
            }
           
         }

         return ways[n];
        
    }

    
    public static void main(String[] args) {
        System.out.println(  ClimbingStairWays(4));

        System.out.println(ClimbingStairTAb(5));
      

    }

    
} 