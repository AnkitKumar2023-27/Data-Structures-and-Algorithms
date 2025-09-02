import java.util.Stack;

public class eightFour {
    public static int Histogram(int hight[]){
        int maxArea=0;
        int nsr[]=new int[hight.length];
        int nsl[]=new int[hight.length];


         Stack<Integer>s=new Stack<>();
         for (int i = hight.length - 1; i >= 0; i--){
            while (!s.isEmpty()&&hight[s.peek()]>=hight[i]) {
                s.pop();
                
            }
            if(s.isEmpty()){
                nsr[i]=hight.length;

            }else{
                nsr[i]=s.peek();

            }
            s.push(i);

         }
            s=new Stack<>();
           for( int i=0;i<hight.length;i++){
            while (!s.isEmpty()&&hight[s.peek()]>=hight[i]) {
                s.pop();
                
            }
            if(s.isEmpty()){
                nsl[i]=-1;

            }else{
                nsl[i]=s.peek();

            }
            s.push(i);

         }
         for( int i=0;i<hight.length;i++){
            int ht=hight[i];
            int width=nsr[i]-nsl[i]-1;
            int area=ht*width;
            maxArea=Math.max(maxArea, area);
         }
         return maxArea;
         
    }
    public static void main(String[] args) {
     int   heights[] = {2,1,5,6,2,3};
     System.out.println(Histogram(heights));
    }
}
