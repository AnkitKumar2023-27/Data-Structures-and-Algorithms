public class STofMax {

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
    public static void main(String[] args) {

        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        init(n);
        STofMaxNode(arr, 0, n-1, 0);

         for( int i=0; i<tree .length;i++){
             System.out.print( tree[i]+" ");
         }
        
    }
    
}
