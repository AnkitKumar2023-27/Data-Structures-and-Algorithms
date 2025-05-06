import  java .util.*;

public class SlidingWindow {

    public static class Pair implements Comparable<Pair>{
        int val;
         int i;
         public Pair( int val,int i){
             this.val=val;
             this.i=i;
         }
 @Override
  public  int compareTo(Pair other){ 
     return other.val -this.val;
     }
    }
    public static void main(String[] args) {
        
     int  k=3;


        int arr[]={ 1,3,-1,-3,5,3,6,7};
          
        int res[]=new int[arr.length-k+1];

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for ( int i =0; i <k;i++){
            pq.add( new Pair(arr[i],i));


        }
          res[0]=pq.remove().val;

          for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().i<=i-k){
                pq.remove();

            }

            pq.add(new Pair(arr[i],i));
            res[i-k+1]=pq.peek().val;
          }

          for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
          }

        
    }
    
}
