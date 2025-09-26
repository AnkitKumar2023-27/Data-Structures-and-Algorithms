import java.util.LinkedList;
public  class myHashmap<K ,V> {
 public class Node{
        K key;
        V value;
        public Node(K key,V value){
            this.key=key;
            this.value=value;   
        }

    } 
    
 private int N=4;
private int n=0;
@SuppressWarnings("unchecked")
private LinkedList<Node>Buckets[]=new LinkedList[N];

@SuppressWarnings({ "rawtypes", "unchecked" })
public  myHashmap(){ 
    for( int i=0;i<Buckets.length;i++){
        Buckets[i]=new LinkedList();

    }

}
public  void put(K key, V value){
    int bi=hashfunction(key);
    int di=serchinLL(key,bi);
    if(di!=-1){
        Node node=Buckets[bi].get(di);
        node.value=value;
    }else{
        Buckets[bi].add(new Node(key, value));
        n++;
    }
    double lambda=(double)n/N;
    if(lambda>=2){
        rehash();

    }

}
private int hashfunction(K key){
    int bi=key.hashCode();
    return Math.abs((bi)%N);

}
private int serchinLL(K key, int bi){
    LinkedList<Node>ll=Buckets[bi];
   for(int i=0;i<ll.size();i++){
        Node n=ll.get(i);
        if(n.key==key){
            return  i;
        }
    
   }
   return -1;
}
@SuppressWarnings("unchecked")
private void rehash(){
    LinkedList<Node>oldbucket[]=Buckets;
    Buckets=new LinkedList[N*2];
    N=2*N;
for(int i=0;i<N;i++){
        Buckets[i]=new LinkedList<>();
}
for(int i=0;i<oldbucket.length;i++){
    LinkedList<Node>ll=oldbucket[i];
  for (Node node : ll) {
    put(node.key, node.value);
}

}
}

// contains key fuction
public boolean containskey(K key){
    int bi=hashfunction(key);
    int ni=serchinLL(key, bi);
    if(ni!=-1){
        return true;

    }
    else{
        return false;
    }


}

// Get fuction 
public V get(K key){
     int bi=hashfunction(key);
    int ni=serchinLL(key, bi);
    if(ni!=-1){
        Node node=Buckets[bi].get(ni);
        return node.value;

    }
    else{
        return null;
    }
}
public V remove(K key){
     int bi=hashfunction(key);
    int ni=serchinLL(key, bi);
    if(ni!=-1){
        Node node=Buckets[bi].remove(ni);
         n--;
        return node.value;
      

    }
    else{
        return null;
    }
}
public boolean isEmpty(){
    if(n==0){
        return true;
    }
    else{
        return false;
    }
}
 

public static void main(String[] args) {
myHashmap<String, Integer> map = new myHashmap<>();
map.put("Ankit", 22);
map.put("Rahul", 25);
map.put("Ankit", 30); // update


System.out.println(map.get("Ankit"));
System.out.println(map.containskey("Ankit"));
System.out.println(map.remove("Ankit"));
System.out.println(map.isEmpty());

   
   
}
    
    
}
