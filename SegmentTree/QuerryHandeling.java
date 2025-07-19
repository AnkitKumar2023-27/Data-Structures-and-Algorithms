public class QuerryHandeling {


    
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

public static  int getSum( int i,int si ,int sj,int qi,int qj ){
    if(qj<=si||qi>=sj){
        return 0;
    }else if (qi<=si&& sj<=qj) {
        return tree[i];
        
    }else{
        int mid= (si+sj)/2;
        int leftAns=getSum(2*i+1, si, mid, qi, qj);
        int rightAns= getSum(2*i+2, mid+1, sj, qi, qj);
        return leftAns+rightAns;
        
    }
}






    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        buitST(0,0, n-1, arr);
        // for( int i =0; i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }
        System.out.println(getSum(0, 0, n-1, 2, 5));
        
    }   
}
