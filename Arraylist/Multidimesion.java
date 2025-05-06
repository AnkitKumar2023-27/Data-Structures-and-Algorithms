import java.util.ArrayList;

public class Multidimesion {

  static ArrayList<ArrayList<Integer>>mainList=new ArrayList<>();
    static ArrayList<Integer>list1=new ArrayList<>();
    static  ArrayList<Integer>list2=new ArrayList<>();
  
    public static void Multidimension(ArrayList<ArrayList<Integer>> mainlist) {
        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList<Integer> currList = mainlist.get(i); // Fetch the current sublist
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " "); // Print elements of the sublist
            }
            System.out.println(); // New line after each sublist
        }
    }

     
         public static void main(String[] args) {
             list1.add(1);
             list1.add(2);
             list1.add(3);
             list1.add(4);
             list2.add(4);
             list2.add(5);
             list2.add(6);
             list2.add(7);
             mainList.add(list1);
             mainList.add(list2);
             System.out.println(mainList);
             Multidimension(mainList);
             
             
    }
}
