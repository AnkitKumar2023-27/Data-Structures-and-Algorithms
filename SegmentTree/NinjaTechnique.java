public class NinjaTechnique {

    public static int ninja(int arr[][], int day, int last ){
        if(day==0){
            int max=0;
            for( int i=0;i<=2;i++){
                if(i!=last){
                max= Math.max(max,arr[0][i]);
                }
            }
            return max;
        }
   int max =0;
   for(int i=0;i<=2;i++){
    if(i!=last){
   int  point=arr[day][i]+ninja(arr, day-1,i);

   max=Math.max(max, point);
   }
   }

   return max;
    }



    public static void main(String[] args) {
  // day 2 is the  size total days index ;;
//     kyuki work bosr last day se le rhe hm islia \


         int arr[][]={{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
         System.out.println(ninja(arr, 2, 3));
    }
    
}
