

import java.util.ArrayList;



public class BasicArrayList{
   static ArrayList<Integer>list=new ArrayList<Integer>();
   public static void ListElement(ArrayList<Integer>list){
      for(int i=0;i<list.size();i++){
         System.out.print(" "+list.get(i));
      }
System.out.println();
   }
//$$$$$$$$$REVERSE LIST)))))))))))))))))))
   public static void RevesreList(ArrayList<Integer>list){
      for(int i=list.size()-1;i>=0;i--){
         System.out.print(" "+list.get(i));
      }

 

   }

   
       public static void main(String[] args) {
          list.add(1);
          list.add(2);
          list.add(3);
          System.out.println(list);
          System.out.println("Get Opretion"+list.get(2));
          list.remove(2);
          System.out.println();
          System.out.println("Remove Opretion"+list);
          list.add(4);
          list.add(7);
          System.out.println();
          System.out.println("Size  "+list.size());
          System.out.println("Element Using Loop ");
          ListElement(list);
          System.out.println();
          System.out.println("Reverse Element Using Loop ");
          RevesreList(list);
        

          
          
     }
}