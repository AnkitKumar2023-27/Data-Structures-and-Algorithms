import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P2 {
    public static void main(String[] args) {
  int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        int acticvities[][]= new int[start.length][3];
        Arrays.sort(acticvities,Comparator.comparingDouble(o->o[2]));
        for(int i=0;i<start.length;i++){
            acticvities[i][0]=i;
            acticvities[i][1]=start[i];
            acticvities[i][2]=end[i];
        }
         ArrayList<Integer> ans=new ArrayList<>();

        int MaxJob=1;
        int endTime=acticvities[0][2];
        
        ans.add(acticvities[0][0]);
            for(int i=1;i<end.length;i++){
               while (endTime<=acticvities[i][1]) {
                ans.add(acticvities[i][0]);
                MaxJob++;
                endTime=acticvities[i][2];
            
         }  
            }
            System.out.println("max DoneJobs without sorting  = "+MaxJob);
            for(int i=0;i<ans.size();i++){
                System.out.print("  A"+ans.get(i));
            }
   System.out.println();


        
    }
}
