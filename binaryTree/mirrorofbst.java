public class mirrorofbst {

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

    

      public  static Node mirrorOfBst(Node root){
        if(root==null){
            return null;

        }

     Node lefts=  mirrorOfBst(root.left);
     Node rightSub=mirrorOfBst(root.right);
     root.left=rightSub;
     root.right=lefts;
     return root;
        

      }

      public static void preorder(Node root){
        if( root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
      }



      public static void main(String[] args) {
        

        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preorder(root);

        System.out.println();
        mirrorOfBst(root);
        preorder(root);
    }
    
}
