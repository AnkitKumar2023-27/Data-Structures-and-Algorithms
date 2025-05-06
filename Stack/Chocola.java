import java.util.*;

public class Chocola {
    public static void main ( String args[]){
        // int n=5;
        // int m=4;


        Integer costVer[]={2,1,3,1,4};
       Integer  costHor[]={4,1,2};

       Arrays.sort(costHor,Collections.reverseOrder());


       Arrays.sort(costVer,Collections.reverseOrder());
    //      for ( int i=0;i<costVer.length;i++){
    //         System.out.print(costVer[i]);
    //      }

       int cost=0;   
        int h=0;// total no of cut in statrting  after cutting
        int v=0;
        int hp=1;
        int vp=1;

        while (h<costHor.length &&v<costVer.length) {
            if (costHor[h]>=costVer[v]){
                cost+=(costHor[h]*vp);
                hp++;
                 h++;


            }else{
                cost=(costVer[v]*hp);
                vp++;
                v++;
            

            }
            

            
        }
        while (h<costHor.length) {
                
                
            cost+=(costHor[h]*vp);
            hp++;
             h++;
        }
        while( v<costVer.length){
            cost=(costVer[v]*hp);
            vp++;
            v++;

        }
         System.out.println("total  cost = " +cost);


    }


    
}
