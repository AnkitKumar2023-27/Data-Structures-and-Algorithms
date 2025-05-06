import java.util.HashSet;

public class uniounAndIntersection {

    public static void main(String[] args) {
         int arr1[]={4,3,3,5,6,6,8,9};
         int arr2[]={3,5,78,9,6,5,4,6,6,7};

         HashSet<Integer>intersection=new HashSet<>();




         HashSet<Integer>set=new HashSet<>();


         for(int i=0;i<arr1.length;i++){
             set.add(arr1[i]);
             intersection.add(arr1[i]);
         }
         
         for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        System.out.println( "union of Arrays size is ="+set.size());
          System.out.println( " element of the union is "+ set);
       

        //     now  we check element one by one if it exits then we print element that printet elemnt aeree is equal to intesection of both arrays
 int count=0;
        for(int i=0;i<arr2.length;i++){

           
            if(intersection.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
                System.out.print(arr2[i]+" ");
            }

            

          
        }
        System.out.println();
  System.out.print(" Size of the intersection element ="+ count);
    }
    
}
