


public class searching {

  public static  void leanesr_searching(int numbers[],int num){
       for(int i=0;i<numbers.length;i++){
         if(numbers[i]==num){
            System.out.println(num +" was found on index "+(i+1));
    }

   }   System.out.println("number is not found");
      
        
    
        }
        
  public static  void find_largest(int numbers[],int num){
    for(int i=0;i<numbers.length;i++){
      if(numbers[i]>=num){
         num=numbers[i];

 }else{

    
 }

}   System.out.println("number is not found");
   
     
 
     }
 

     
  public static  void binary_searching(int numbers[],int num){
       int start=0;
      int end=numbers.length;
      
      while(start<=end){

        int mid=(start+end)/2;
        if(numbers[mid]==num){
            System.out.println("index of the founded Number " + num + " is " +mid);
        }

        if(numbers[mid]<num){


          start=mid+1;

        }else{
          end=mid-1;
        }
      }
      }

      //MEARGE SORT*******************************************************************************


 public static  void mearSort(int arr[],int si,int ei){
                 if(si>=ei){
                  return ;
                 }
                  int mid=si+(ei-si)/2;
                   mearSort(arr, si,mid);
                   mearSort(arr, mid+1, ei);
                   mearge(arr,si,ei,mid);

 }
 public static void mearge(int arr[],int si,int ei,int mid){
                  int temp[]=new int[ei-si+1];
                   int i=si;
                   int j=mid+1;
                   int k=0;
                   while(i<=mid&&j<=ei){
                       if ( arr[i]<arr[j]){
                      temp[k]=arr[i];
                      i++;
                    }else{
                      temp[k]=arr[j];
                      j++;
                    }
                    k++;
                  }
                 
                    while(i<=mid){
                      temp[k++]=arr[i++];
                    }
                    while(j<=ei){
                      temp[k++]=arr[j++];
                    }
                    for(k=0,i=si;k<temp.length;k++,i++){
                      arr[i]=temp[k];
                    }
                    
                 }
   public static  void PrintArr(int arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.print(" "+arr[i]);
    }
   }    
   
   ///////////////////////  QUICK SORT    ################################################################
   


public static void quickSort(int arr[],int si,int ei){

  if (si>=ei){
    return;
  }
   int pIdx=partition(arr,si,ei);
   quickSort(arr, si,pIdx-1);
   quickSort(arr, pIdx+1, ei);

   
}
public static int  partition(int arr[],int si,int ei){
  int pivot=arr[ei];
  int i=si-1;  //it is alaways a low index then array  
  for(int j=si;j<ei;j++){
    if(arr[j]<=pivot){
      i++;
      int temp=arr[j];
      arr[j]=arr[i];
      arr[i]=temp;
    }
  }
  i++;
  //swaping of pivot element
   int temp=pivot;
   arr[ei]=arr[i];
   arr[i]=temp;
   return i;
}


  


 //SEARCH IN ROTetED SORT ARRAY @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 
 
 public static int serachInSortedArray(int arr[], int tar ,int si,int ei){
    int mid=si+(ei-si)/2;

 if (arr[mid]==tar){
  return mid;
 }
  if(arr[si]<=arr[mid]){
                if(arr[si]<=tar&& tar<=arr[mid]){

                  //LEFT SIDE KE LIA
                  return serachInSortedArray(arr, tar, si, mid-1);
                  }else{
                    //RIGHT SIDE KE LIA HUMNE STARTING KO MID+1 AND END KO EI LIA HAI
                    return serachInSortedArray(arr, tar, mid+1, ei);
                  }
                  //case 2 whwn element found on line 2
  }else{
                if(arr[mid]<=tar && tar<=arr[ei]){

                  //RIGHT SIDE KE LIA
                  return serachInSortedArray(arr, tar, mid+1, ei);
                    }else{
                    //LEFT SIDE KE LIA HUMNE STARTING KO MID+1 AND END KO EI LIA HAI
                    return serachInSortedArray(arr, tar, si, mid-1);
                    }

  }
  

 }

  public static void main(String args[] ) {
        
  //           Scanner sc = new Scanner(System.in)) {//
  //           // Prompt user to enter rows and columns
  //           int numbers[]={2,4,6,8,10,12,15,16,18,19,26};
  //          int n=Integer.MIN_VALUE;
  //         // int numbers=sc.nextInt();
  //       // binary_searching(numbers, num);
  //         // leanesr_searching(numbers, n);  

  
        int arr[]={4,5,6,7,0,8,-8,7,6};

 //mearge sort       
        // mearSort(arr, 0, arr.length-1);
        // PrintArr(arr);

//QUICK SORT
    quickSort(arr, 0, arr.length-1);
      PrintArr(arr);      

//serch in sorted Array
        // int tar=7;
        // int tarIDX=serachInSortedArray(arr, tar, 0, arr.length-1);
        // System.out.println("index of the founded Number " + tar + " is on " + tarIDX);
      
         
  }
    }
    

