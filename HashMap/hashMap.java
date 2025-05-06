import java.util.*;

public class hashMap {
    public static void main(String[] args) {
        
     HashMap <String,Integer> hm=new HashMap<>();
    hm.put("Ankit",19);
    hm.put("Aditya",15 );
    hm.put("Anmaika", 18);
    hm.put("Anchal",18 );

    System.out.println(hm);
    System.out.println(hm.get("Ankit")); 
    // System.out.println(hm.remove("Anchal"));S
    System.out.println( hm.size());
    System.out.println(hm.isEmpty());
   // itration on  Hashmap
    
   Set<String>Keys=hm.keySet();
    System.out.println(Keys);


    for(String k:Keys){
        System.out.println("Keay ="+k +" Vlues="+hm.get(k));
    }
   
 


}

    
} 