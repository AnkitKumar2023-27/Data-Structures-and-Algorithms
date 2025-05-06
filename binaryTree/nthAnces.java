public class nthAnces {
    
    public static class Node {
            int data;
            Node left;
            Node right;
    
            public Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }

          
    
        }

        public static int nthAnces(Node root,int n,int k){

            if(root==null){
                return -1;
            }
             if(root.data==n){
               return 0;
             }

            int lefAnce=nthAnces(root.left, n, k);
            int rightAnces=nthAnces(root.right, lefAnce, k);
            int max=Math.max(lefAnce, rightAnces);
            if(max+1==k){
               System.out.println(root.data);
            }
         return max+1;

       }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right .left= new Node(7);
        root.right = new Node(2);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n=7;
        int k=2;

        nthAnces(root,n,k);
        
    }
    
}
