public class SegmentTree{
static int tree[];
public static void init( int n){
    tree=new int[4*n];
};

public static int buitST(int i, int start,int end,int arr[]){
    if(start==end){
        tree[i]=arr[start];
        return arr[start];
    }

    int mid=(start+end)/2;

  
        buitST(2*i+1, start,mid, arr);
        buitST(2*i+2, mid+1, end, arr);

        tree[i]=tree[2*i+1]+tree[2*i+2];
         return tree[i];

    
   
}




    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        buitST(0,0, n-1, arr);
        for( int i =0; i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        
    }


}