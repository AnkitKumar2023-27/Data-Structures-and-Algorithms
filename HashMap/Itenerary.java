import java.util.*;

public class Itenerary {

   public static String getStart(HashMap<String,String>tickets){
    HashMap<String,String>RevHm=new HashMap<>();
    for(String key:tickets.keySet()){
        RevHm.put(tickets.get(key), key);

    };
   
    for(String key:tickets.keySet()){
        if(!RevHm.containsKey(key)){
            return key;
        }


    }
    return null;

   

   }


    public static void main(String[] args) {
        
        HashMap<String,String>destination=new HashMap<>();

        destination.put("Chennai","Bangluru");
        destination.put("Mumbai", "Delhi");
        destination.put("Goa", "Chennai");
        destination.put("Delhi", "Goa");

       String Start=getStart(destination);
       
        System.out.print(Start);
     

        for(String _:destination.keySet()){
            System.out.print("-->>"+destination.get(Start));
            Start=destination.get(Start);

           
            }
    
    
        }




    }
    

