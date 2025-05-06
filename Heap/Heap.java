import java.util.ArrayList;

public class Heap {

   
        ArrayList<Integer>heap=new ArrayList<>();

        public  void add(int data) {
        heap.add(data);

        int x=heap.size()-1;
        int parent=(x-1)/2;
        while(heap.get(x)<heap.get(parent)){
            int temp=heap.get(parent);
            heap.set(parent, heap.get(x));
            heap.set(x, temp);
        }
        
       
    }

    public int peek(){
        return heap.get(0);
        
    }

    public int remove(){

        int data=heap.get(0);
        int temp=heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.set(heap.size()-1, temp);

        heap.remove(heap.size()-1);

      

        heapify(0);
        return data;
       
    }
    public void heapify(int i){
        int left=2*i+1;
        int right=2*i+2;
        int minIdx=i;

        if( left<heap.size()-1  &&heap.get(minIdx)>heap.get(left)){
            minIdx=left;
        };
        if(right<heap.size()-1 && heap.get(minIdx)>heap.get(right)){
            minIdx=right;
        }

        if(minIdx!=i){
         int temp=heap.get(i);
         heap.set(i, heap.get(minIdx));
         heap.set(minIdx, temp);
        heapify(minIdx);

        }
    }
    public boolean isEmpty(){
        return heap.size()==0;
    }

    public static void main(String[] args) {
       Heap h=new  Heap();

        h.add(1);
        h.add(4);
        h.add(2);
        h.add(7);
        h.add(5);

        while (!h.isEmpty()){
            System.out.print(h.peek()+" ");
            h.remove();

            
        }

     
    }
}
