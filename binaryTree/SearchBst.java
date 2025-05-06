public class SearchBst {

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


   public static boolean searcNode(Node root,int n){
        if(root==null){
            return false;
        }
        if(root.data==n){
             return true;
        }
        if (root.data>n) {
          return   searcNode(root.left,n);
        }else{
        return searcNode(root.right,n) ;
        }


        }


        public static  Node DeleteNode(Node root,int n){
            if(root==null){
                return null;
            }
            if(root.data>n){
            root.left= DeleteNode(root.left, n);
            } else if(root.data<n){
                root.right= DeleteNode(root.right, n);
            }

            else {
                    if(root.left==null && root.right == null){
                 return null ;
            };
            if(root.left==null){
                    return root.right;
            }else if(root.right==null) {
                    return root.left;
            }
            Node IS=inorderSuccer(root.right);
            root.data=IS.data;
            root.right= DeleteNode(root.right,IS.data);
            }
            return root;


        }

 public static Node inorderSuccer(Node root)
 {
    while (root.left!=null){
        root=root.left;
    }
    return root;
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


        System.out.println("Search for 5: " + searcNode(root,5 ));
        System.out.print("Inorder traversal before deletion: ");
        inOrder(root);
        System.out.println();

        root = DeleteNode(root, 5);
        System.out.print("Inorder traversal after deleting 5: ");
        inOrder(root);
        System.out.println();

        System.out.println("Search for 5 after deletion: " + searcNode(root, 5));

        root = DeleteNode(root, 10);
        System.out.print("Inorder traversal after deleting 10: ");
        inOrder(root);
        System.out.println();

        root = DeleteNode(root, 3);
        System.out.print("Inorder traversal after deleting 3: ");
        inOrder(root);
        System.out.println();
    }


}