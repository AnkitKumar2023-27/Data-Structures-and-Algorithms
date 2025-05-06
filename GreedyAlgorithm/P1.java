import java.util.ArrayList;

public class P1 {

    public static void main(String[] args) {
        int start[]={10,12,20};
        int end[]={20,25,30};
         ArrayList<Integer> ans=new ArrayList<>();

        int MaxJob=1;
        int endTime=end[0];
        
        ans.add(0);
            for(int i=1;i<end.length;i++){
               while (endTime<=start[i]) {
                ans.add(i);
                MaxJob++;
                endTime=end[i];
            
         }  
            }
            System.out.println("max DoneJobs= "+MaxJob);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
   System.out.println();


   
    }
    
}