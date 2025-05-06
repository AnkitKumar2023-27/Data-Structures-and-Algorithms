import java.util.HashMap;
import java.util.Set;

public class majorityElement {

    public static void main(String[] args) {
        HashMap<Integer,Integer>hm=new HashMap<>();

        int num[]={1,3,2,3,1,1,3,1};
        for(int i=0;i<num.length;i++){
            int val=num[i];
            if(hm.containsKey(val)){
                    hm.put(val, hm.get(val)+1);
            }
            else{
                hm.put(val,1);
            };
        }
     
      Set<Integer>keys=hm.keySet();
        System.out.println(keys);

        System.out.println();

        for(Integer k:keys){
            System.out.println("For "+ k+"  its repetetion is " +hm.get(k));
        }
    }
    
}
