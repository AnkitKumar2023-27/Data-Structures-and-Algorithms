public class Max_Min_seg {
    static int tree[];
    public static void init( int n){
        tree=new int[4*n];
    }

    public static  int  MaxSegment(  int arr[],int i , int si , int sj){
        if(si==sj){
            tree[i]=arr[si];
            return tree[i];
        }

         int mid=(si+sj)/2;
         MaxSegment(arr,2*i+1, si, mid);
         MaxSegment(arr, 2*i+2, mid+1, sj);

         tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
          return tree[i];
    }
   public  static int Max_In_SEG_Util(  int arr[], int qi, int qj){
    int n=arr.length;
   return Max_in_Seg( 0,  qi, qj, 0, n-1);

    }

     public static int Max_in_Seg(int i, int qi, int qj, int si, int sj){
        if(qi>sj||qj<si){
            return Integer.MIN_VALUE;

        }else if(qi<=si&&qj>=sj){
            return tree[i];
        }else {
            int mid=(si+sj)/2;
            int leftmax=Max_in_Seg(2*i+1,qi,qj,si,mid);
            int rightmax=Max_in_Seg(2*i+2,qi,qj,mid+1,sj);
             return Math.max(leftmax, rightmax);

        }
      




     }

     
// update in max and min segment 
 public static void Updateutiil(int arr[], int val , int idx){
    
     arr[idx]=val;

      int n = arr.length;
      update( 0, idx, val , 0, n-1);
 }
  public static  void  update(  int  i,int idx, int val , int si,  int sj){
    if( idx<si|| idx>sj){
         return;
          
    }

     if(si==sj){
           tree[i]=val;


     }

     tree[i]= Math.max(val,tree[i]);
     if(si!=sj){
         int mid= ( si+sj)/2;
         update(2*i+1, idx, val, si, mid);
          update ( 2*i+2,idx,val ,mid+1, sj);
     }
      
  }

    
    
   
    public static void main ( String args[]){
        int arr[]={1,2,-1,4,5,6,7,8};
        int n=arr.length;
        init(n);
        MaxSegment(arr,0,0,n-1);
        for( int i=0 ; i <tree.length;i++){
            System.out.print(tree[i]+" ");
        }

        System.out.println();
     System.out.println(" Max in the araay is ="+Max_In_SEG_Util(arr,2,5));
      System.out.println(" After update the segment tree is ");

       Updateutiil(arr, 20, 3);
        System.out.println(" Max in the araay is ="+Max_In_SEG_Util(arr,2,5));
    }
    
}
