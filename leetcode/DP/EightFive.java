import java.util.Stack;

public class EightFive {

        public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n]; 
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
           
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
           
            maxArea = Math.max(maxArea, Histogram(heights));
        }
        return maxArea;
    }

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
              char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };

        System.out.println(maximalRectangle(matrix));
        
    }
    
}
