public class Segment_A {

    static int tree[];
     public static  void init( int n){
        tree=new int[4*n];
     }
  public static int segmentTree(int arr[], int i, int start, int end) {
      if( start== end){
        tree[i]=arr[start];
        return arr[start];

      }
       int mid =(start+end)/2;
       segmentTree(arr, 2*i+1,start, mid);
       segmentTree(arr, 2*i+2, mid+1, end);
       tree[i]= tree[2*i+1]+tree[2*i+2];
       return tree[i];
      
       


    }
 public static  int getSumUtil(int arr [], int qi,int qj){
    int n=arr.length;
  return  getSum(0, qi, qj,0,n-1);
 }

public static int getSum(int i, int qi, int qj,int si , int sj){
   if (qj < si || qi > sj) 
{
        return 0;
    }else if (qi<=si&&qj>=sj) {
        return tree[i];
    } else {
        int mid=(si+sj)/2;
     int leftSum=   getSum(2*i+1, qi, qj, si,mid);
     int rightSum=   getSum(2*i+2, qi, qj, mid+1, sj);
      return leftSum+rightSum;

    }
}

public static void updateUtl(int arr[],int val,int  idx){
     int differ=val-arr[idx];
     int n =arr.length;
     arr[idx]=val;
     update(0,differ, idx, 0, n-1);


}

public static void  update(int i , int  differ,int idx,int si , int sj){
    if(idx< si ||idx>sj){
        return;

    }
    tree[i]+=differ;
    if( si!=sj){
        int mid=(si+sj)/2;
        update(2*i+1, differ, idx, si,mid);
        update(2*i+2, differ, idx, mid+1, sj);

    }

}


    public static void main(String[] args) {

         int arr[]={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

           init(arr.length);
         segmentTree(arr,0,0,arr.length-1);
            System.out.println("Segment tree ");

         for ( int i=0;i<tree.length;i++){
        
            System.out.print( " " +tree[i]);
         }
         System.out.println();
     System.out.println("Segment tree sum After update");    
     System.out.println(  getSumUtil(arr,2,5));

     updateUtl(arr, 2, 3);
 System.out.println("Segment tree After update"); 
     System.out.println(getSumUtil(arr,2,5));

     

         for ( int i=0;i<tree.length;i++){
        
            System.out.print( " " +tree[i]);
         }
       
    }



    
}