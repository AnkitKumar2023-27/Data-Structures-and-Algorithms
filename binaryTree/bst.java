
public class bst {

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

    public static Node createBst(Node root,int values){
        if(root==null){
            root=new Node(values);
            return  root;
        };
          if(root.data>values){
            root.left=createBst(root.left, values);
          }else{
            root.right=createBst(root.right, values);

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

       

            int values[]={1,3,2,6,8};
            Node root=null;
            for (int i=0;i<values.length;i++){
                root = createBst(root,values[i]); // Assign the returned Node to root
    
            }
            inOrder(root);
    
    
        

        
    }

    
    
}

