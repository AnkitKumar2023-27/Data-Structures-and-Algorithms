public class UpdateInMaxST {


    static int tree[];
    public static void init( int n){
         tree= new int [n*4];
    }


 public static void STofMaxNode( int arr[], int start,int end ,int i){
    if (start==end) {
       tree[i]=arr[start] ;
       return;
   

    }

    int mid=( start + end)/2;
     STofMaxNode(arr, start, mid,2*i+1);
     STofMaxNode(arr, mid+1, end,2*i+2);
     tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
 }

 public static int getMax( int arr[],int qi, int qj){
    int n=arr.length;
   return  getMaxUtil( 0,0,n-1,qi,qj);
 }

 public static int  getMaxUtil(int i, int si, int sj, int qi, int qj){
    if (qj<=si||sj<qi) {
         return Integer.MIN_VALUE;
        
    }else if( qi<=si&&qj>=sj){
        return tree[i];
    }else{
         int mid=( si+sj)/2;
        int leftAns=getMaxUtil(2*i+1,si,mid, qi, qj);
         int rightAns=getMaxUtil(2*i+2, mid+1, sj, qi, qj);
         return Math.max(leftAns, rightAns);
    }

 }

  public static void UpdateST(int arr[],int idx,int newVal){

    arr[idx]=newVal;
     int n =arr.length;
     UpdateSTUtil(0,0,n-1 , idx, newVal);
      

  }

   public static  void UpdateSTUtil( int i , int si, int sj, int idx, int newVal){
     if( idx<si|| idx> sj){
          return;

     }
 if( si==sj){
     tree[i]=newVal;  // at end  if we waana to to change max then we change full value
 }
   if(si!=sj){
     tree[i]=Math.max(tree[i], newVal);
      int mid=( si+sj)/2;
      UpdateSTUtil(2*i+1, si, mid, idx, newVal);
      UpdateSTUtil(2*i+2, mid+1, sj, idx, newVal);
   }
   }
    public static void main(String[] args) {

        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        init(n);
        STofMaxNode(arr, 0, n-1, 0);

        //  for( int i=0; i<tree .length;i++){
        //      System.out.print( tree[i]+" ");
        //  }

        System.out.println( getMax(arr, 2, 5));

        UpdateST(arr,2,20);
         System.out.println( getMax(arr, 2, 5));


       
        
    }
    
}


    

    

