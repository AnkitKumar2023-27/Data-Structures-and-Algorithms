import java.util.PriorityQueue;

public class WeakestSoldier {
    public static class Soldier implements Comparable<Soldier>{
        int  soldiers;
        int i;
        public Soldier(int soldiers,int i){
            this.soldiers=soldiers;
            this.i=i;
        }

 @Override
 public int compareTo(Soldier R2){
    if(this.soldiers==R2.soldiers){
        return this.i-R2.i;

    }else{
         return   this.soldiers-R2.soldiers;
    }
 }       
    }


    public static void main(String[] args) {

      
        int soldiers[][]={{1,0,0,0},
                         {1,1,1,1},
                        {1,0,0,0,0},
                        {1,0,0,0,0}};
        PriorityQueue<Soldier> pq = new PriorityQueue<>();

              int k=2;
              for ( int i=0;i<soldiers.length;i++){
                int count=0;
                for (int j=0;j<soldiers[0].length;j++){

                    count+=soldiers[i][j]==1?1:0;


                } 
                pq.add(new Soldier(count, i));
              }  
              
              for(int i =0;i<k;i++){
                System.out.println("R"+pq.remove().i);
              }
        
    }
    
}
