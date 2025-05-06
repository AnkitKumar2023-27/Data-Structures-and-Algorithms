public class HeapSort {
    public static void Heapsort(int arr[]){
        int n=arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
             arr[0]=arr[i];
            arr[i]=temp;
              

            heapify(arr,0,i);
        }

    }  
    
    public static void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int  right=2*i+2;
         
         int maxidx=i;
         if(left<size&& arr[left]>arr[maxidx]){
            maxidx=left;
         };
         if(right<size&& arr[right]>arr[maxidx]){
            maxidx=right;

         }
           

         if(maxidx!=i){
            int temp=arr[i];
            arr[i]=arr[maxidx ];
             arr[maxidx]=temp;
             heapify(arr,maxidx,size);
        
        }

    }

    public static void main(String[] args) {
        int arr[]={1,2,4,3,5};
        Heapsort(arr);

        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        }
}
