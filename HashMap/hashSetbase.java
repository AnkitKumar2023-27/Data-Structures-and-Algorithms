import java.util.*;

public class hashSetbase {

    public static void main(String[] args) {
        HashSet<Integer>hs=new HashSet<>();
          hs.add(4);
          hs.add(45);
          hs.add(6);
          hs.add(7);
          hs.add(4);


          System.out.println(hs);
          System.out.println("totsl no of distict element in Set is ="+ hs.size());
          Iterator it=hs.iterator();
          while (it.hasNext()) {
            System.out.print(it.next()+" ");
            
          }



    }
    
}
