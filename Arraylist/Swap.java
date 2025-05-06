import java.util.ArrayList;

public class Swap {
    static ArrayList<Integer>list=new ArrayList<Integer>();

    
  public static void swap(ArrayList<Integer>list, int idx1, int idx2) {
   int temp = list.get(idx1);
   list.set(idx1, list.get(idx2));
   list.set(idx2, temp);
}


 //MAX IN ARRAYLIST
public static void MaxinList(ArrayList<Integer> list) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < list.size(); i++) {
        if (max < list.get(i)) {
            max = list.get(i);
        }
    }
    System.out.println("Maximum element: " + max);
}






    public static void main(String[] args) {
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
     System.out.println(list);
     swap(list,1,3);
     System.out.println(list);
     MaxinList(list);
    }
    
}
