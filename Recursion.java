

public class Recursion {
//  Factorial
    public  static int fact(int n){
        if(n==0){
            return 1;

        }
         int fact=n*fact(n-1);
         return fact;
    }

//Sum of n numbers

    public  static int sum(int n){
        if(n==1){ return 1;}
        int S=n+sum(n-1);
        return S;
    }
    
    //Fibbonacci
    public  static int fib(int n){
        if(n==1||n==0){
             return n;
        }
        int S=fib(n-1)+fib(n-2);
        return S;
    }

    //Check Array Is sorted or not

 public  static Boolean IsSorted(int Arr[],int i){
    if(i==Arr.length-1){
         return true;
    }
else if(Arr[i]>Arr[i+1]){
    return false;

}
    return IsSorted(Arr, i+1);
}

//Calculate X  to power n

   public  static int Power(int x,int n){
    if(n==1){
         return x;
    }
    int Answer=x*Power(x, n-1);
    return Answer;
}

//problem 9 TILLING PROBLEM

public  static int tilling(int n){
    if(n==1||n==0){
         return 1;
    }
    int horizontal=tilling(n-1);
    int vertical =tilling(n-2);
    int totalWays=horizontal+vertical;
    return  totalWays;
}


public  static void binaryString(int n,int lastPlace, String str){
    if(n==0){
         System.out.println(str);
         return;
    }
    //this condition hit both time if lastplace digit 0 is or 1
    binaryString(n-1, 0, str+"0") ;
    if(lastPlace==0){// this condtion hit when last digit is 0  then both condtion are hitting but  condition of add one binary when last place is 0
        binaryString(n-1, 1, str+"1") ; 
    }
    
}




    public static void main(String[] args) {
        
        // System.out.println(fact(5));
    //    System.out.println(sum(100));
    //    System.out.println(5);

    // int arr[]={1,2,9,3,7};
    // System.out.println(IsSorted(arr,0));
    // System.out.println(Power(2,5));
    // System.out.println(tilling(2));
        binaryString(3, 0, "");
    }
    
}
