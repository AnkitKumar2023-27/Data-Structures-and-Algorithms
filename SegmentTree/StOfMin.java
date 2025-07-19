public class StOfMin {
   static int tree[];
    public  static void  init(  int n){
         tree= new int[n*4];

    };
      
   public static void  MinST( int  i, int start , int end,int arr[]){
    if ( start == end) {
        tree[i]=arr[start];  
        return;     
    }

     int mid=( start+end)/2;
     MinST(2*i+1, start,mid, arr);
     MinST(2*i+2, mid+1, end, arr);
     tree[i]=Math.min(tree[2*i+1],tree[2*i+2]);
   };

   public static  int  getMin1( int arr[],int qi, int qj){
     int n =arr.length;
      return getMin(0, 0, n-1, qi, qj);
   }


   
   public static  int  getMin( int i , int si , int sj , int qi, int qj){
    if(qi>=sj||si>=qj){
         return Integer.MAX_VALUE;
    }
   
   else if(si<=qi&&sj>=qj){
     return tree[i];


   }else{
     int mid=(si+sj)/2;
     
      int leftAns=getMin(2*i+1,si,mid,qi,qj);
      int rightAns=getMin(2*i+2,mid+1,mid,qi,qj);
        int  ans=Math.min(leftAns, rightAns);
         return ans;
   }
}

 public static  void update( int arr[], int idx, int newVal){
      int n= arr.length;
     updateutil(0,0,n-1,idx, newVal);
 };
   public static void updateutil( int i,int si,int sj,int idx, int newVal){
    if(idx<si||idx>sj){
         return;
    }
    if(si==sj){
        tree[i]=newVal;
    }

    if(si!=sj){
        tree[i]=Math.min(tree[i], newVal);
        int mid=(si+sj)/2;
        updateutil(2*i+1, si, mid, idx, newVal);
        updateutil(2*i+2,mid+1, sj, idx, newVal);
    }
     
   }



    public static void main(String[] args) {

         int arr[]={6,8,-1,12,17,1,3,2,4};
          int n = arr.length;
          init(n);
          MinST(0,0, n-1,arr);

           for( int i=0;i<tree.length;i++){
             System.out.print(tree[i]+" ");
        }

         System.out.println();
   
         System.out.println( "Min ="+getMin1(arr,2,5));

         update(arr,2, -2);

         System.out.println();
          System.out.println( "New Min ="+getMin1(arr,2,5));
      
    };


    
}
