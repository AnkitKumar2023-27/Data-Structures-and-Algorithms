public class Leetcode {
    //  leetcode easy problem
    public static int NoOfSteps(int  num, int  steps){
         if(num==0){
            return steps;
         };
        
        
        if(num%2==0){
           return NoOfSteps( num/2,steps+1);
          }else {
            return NoOfSteps(num-1,steps+1);
          }
    }
    public static void main(String[] args) {
        
        System.out.println(NoOfSteps(14,0));
    }
    
}
