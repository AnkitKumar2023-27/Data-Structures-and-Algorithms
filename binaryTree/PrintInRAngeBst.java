public class PrintInRAngeBst {

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


     public  static void PrintInRAngeBst(Node root,int n1,int n2){
        if(root==null){
            return ;
        }
        if(root.data>=n1 && root.data<=n2){
            PrintInRAngeBst(root.left,n1,n2);
            System.out.print(root.data+" ");
            PrintInRAngeBst(root.right, n1, n2);

        }else if(root.data<n1){
            PrintInRAngeBst(root.left,n1,n2);
        }else{
            PrintInRAngeBst(root.right, n1, n2);
        }

        
         
     }
     public static void inOrder(Node root ){
        if (root==null){
            return ;
        }
    
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    
    
    }


    
     

    public static void main(String[] args) {

        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right=new Node(10);
        root.right.left= new Node(9);
        root.right.right= new Node(11);
         int n1=3;
         int n2=9;

         inOrder(root);

        PrintInRAngeBst(root,n1,n2);
    }
    
}
