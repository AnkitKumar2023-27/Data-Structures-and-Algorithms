import java.util.*;

public class Mostwater {
   static ArrayList<Integer>list=new ArrayList<>();
       
    public static void ContainerBox(ArrayList<Integer>list){
        int maxWater=0;
        for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                int ht=Math.min(list.get(i), list.get(j));
                int width=j-i;
               int currWater=ht*width;
                maxWater=Math.max(currWater,maxWater);
               
                }

        }
        System.out.println(maxWater);

    } 

// $$$$  AAPROCH FOR MAKE IT MORE GOOD AND TIME COMPLEXCITY BECOME O[n]
    public static void ContainerBox2(ArrayList<Integer>list){
        int maxWater=0;
        int right=list.size()-1;
        int left=0;
        while ((left<right)) {
            int ht=Math.min(list.get(left), list.get(right));
            int width=right-left;
            int currWater=ht*width;
             maxWater=Math.max(maxWater, currWater);
         if(list.get(left)<list.get(right)){
            left++;
         }else{
            right--;
         }
        }
        System.out.println(maxWater);
       
       

    }

    public static void main(String[] args) {
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(7);
        ContainerBox(list);

        System.out.println("Anwer with two pointer approch");
        ContainerBox2(list);
        
    }
    
}
