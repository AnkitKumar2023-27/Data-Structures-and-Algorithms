import java.util.*;


public class linkedHashMap {

    public static void main(String[] args) {

       

        HashMap <String,Integer> hm=new HashMap<>();
        hm.put("Ankit",19);
        hm.put("Aditya",15 );
        hm.put("Anmaika", 18);
        hm.put("Anchal",18 );
   

        Set<String>Keys=hm.keySet();
        System.out.println(Keys);
    
    
        for(String k:Keys){
            System.out.println("Keay ="+k +" Vlues="+hm.get(k));
        }

        System.out.println("Output On tha basis of LinkedHasmap");


        LinkedHashMap<String,Integer>lhm=new LinkedHashMap();
       
        lhm.put("Ankit",19);
        lhm.put("Aditya",15 );
       lhm.put("Anmaika", 18);
        lhm.put("Anchal",18 );
    
        Set<String>keys=lhm.keySet();
        System.out.println(keys);
    
    
        for(String k:keys){
            System.out.println("Keay ="+k +" Vlues="+hm.get(k));
        }
   
        System.out.println("Output On basis of tree map");



   TreeMap<String , Integer>thm=new TreeMap<>() ; 
   
    
   thm.put("Ankit",19);
   thm.put("Aditya",15 );
  thm.put("Anamaika", 18);
   thm.put("Anchal",18 );

   Set<String>key=thm.keySet();
   System.out.println(key);


        
    }
    
}
