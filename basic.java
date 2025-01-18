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
             
  public static int countNum(int num,int count  ) {
    if(num/10==0){
      return count;
    }
     
   if (num%10==0){
   
   return countNum(num/10,count+1);
   }else{
    return countNum(num/10,count);
   }  
  }
  public static boolean palindrome(int num, int newNum) {
    // Base case: When the number becomes 0
    if (num == 0) {
        return true;
    }

    // Reverse the number by building `newNum` recursively
    newNum = newNum * 10 + (num % 10);
    
    // Recursive call
    return palindrome(num / 10, newNum) && num == newNum;
}

// lenear search return indexof same arrayu with recursion 
public static ArrayList<Integer> search(int arr[], int si, int target, ArrayList<Integer> list) {
    // Base case: If start index reaches the end of the array
    if (si == arr.length) {
        return list;
    }

    // If the target is found, add the index to the list
    if (arr[si] == target) {
        list.add(si);
    }

    // Recursive call for the next index
    return search(arr, si + 1, target, list);
}
 



    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // // Prompt user to enter rows and columns
            // System.out.print("Enter value of n: ");
            // int n = sc.nextInt();
           
        //    pattern_half_pyramid_of_pascals_triangle(n);
        // solid_rohumbus(n);/
// System.out.println(sumofdigit(n));
        // hollow_rohumbus(n);
        
            
        //   System.out.println(countNum(n, 0)); 
        // System.out.println(palindrome(n, 0));
int arr[]={1,2,3,4,4,6};
       
        System.out.println( search(arr, 0, 4,new ArrayList<>()));
        }

 
    }
}