
import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;

public class Implementation {

      static class hashMap<k,v>{ public class Node{
        k key;
        v value;
        public Node(k key,v value){
            this.key=key;
            this.value=value;
        }
    }
    private int n;
    private LinkedList<Node>buckets[];
    private int N;

    

@SuppressWarnings({ "unChecked", "unchecked" })
    public hashMap(){
        this.N=4;
        this.n=0;
        this.buckets=new LinkedList[4];
        for(int i=0;i<4;i++){
            this.buckets[i]=new LinkedList<>();
        }
    }
  public  void put(k key,v value){ 
    int bi=hashFunction(key);
    int di=searchinLL(key,bi);
    if(di!=-1){
        Node node=buckets[bi].get(di);
        node.value=value;
    }else{
        buckets[bi].add(new Node(key,value));
        n++;
    }


double lambda=(double)n/N;

if(lambda>2.0){
    rehash();
}
}
    
private int hashFunction(k key){
    int hc=key.hashCode();
    return Math.abs(hc)%N;
}
 private int searchinLL(k key, int bi){
    LinkedList<Node>ll=buckets[bi];
    int di=0;
    for( int i=0;i<ll.size();i++){
        Node node=ll.get(i);
        if(node.key==key){
            return di;
        }
            
        di++;
    }
    return -1;
}
 @SuppressWarnings("unchecked")
private void rehash(){
    LinkedList<Node>OldBuc[]=buckets;
     N=2*N;
    buckets=new LinkedList[N];

   
    for(int i=0;i<buckets.length;i++){
        buckets[i]=new LinkedList<>();

    }
    n=0;
    for(int i=0;i<OldBuc.length;i++){
        LinkedList<Node>ll=OldBuc[i];
        for( int j=0;j<ll.size();j++){
        Node node=ll.remove();
        n--;
        put(node.key, node.value);
        }

    }


 }
 public boolean ContainsKey(k key){
    int bi=hashFunction(key);
    int di=searchinLL(key,bi);
    if(di!=-1){
        return true;
       
    }else{
         return false;
       
    }

 }


 public v getKey(k key){

    int bi=hashFunction(key);
    int di=searchinLL(key,bi);
    if(di!=-1){
        Node node=buckets[bi].get(di);
        return node.value;
       
    }else{
        
        return null;
       
    }

 }

 public v remove( k key){
    
    
    int bi=hashFunction(key);
    int di=searchinLL(key,bi);
    if(di!=-1){
        Node node=buckets[bi].remove(di);
        n--;
        return node.value;
       
    }else{
        
        return null;
       
    }
 }

 public ArrayList<k> keySet(){
    ArrayList<k>keys=new ArrayList<>();
    for(int i =0;i<buckets.length;i++){
        LinkedList<Node>ll=buckets[i];
        for(Node node:ll){
            keys.add(node.key);
        }

    }
    return keys;
 }

 public boolean isEmpty(){
    return n==0;
 }



}
    public static void main(String[] args) {

        hashMap<String,Integer>hm=new hashMap<>();
        hm.put("kanpur",100);
        hm.put("Delhi", 150);
        hm.put("KaimGanj", 90);
        hm.put("Bhakusa", 70);

         System.out.println(hm.ContainsKey("kanpur"));

         ArrayList<String>keys=hm.keySet();
         for(String key:keys){
            System.out.println(key+"/n/n");
         }


         System.out.println(hm.getKey("kanpur"));
         System.out.println(hm.remove("Delhi"));
         System.out.println(hm.isEmpty());
        
    
    }    
}
