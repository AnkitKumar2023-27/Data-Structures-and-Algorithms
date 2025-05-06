

public class validatebst {



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
    public static boolean Isvalidate(Node root,Node min ,Node max){
        if(root==null){
            return true;
        }

        if(min!=null&& root.data<=min.data){
            return false;
        }
        else if(max!=null&&root.data>=max.data){
            return false;
         }  else{
            return Isvalidate(root.left,min,root)&& Isvalidate(root.right,root,max);

         }

         
       
    }

    public static void main(String[] args) {
        
        
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right=new Node(10);
        root.right.left= new Node(9);
        root.right.right= new Node(11);
        
        System.out.println(Isvalidate(root,null,null));
        
    }
    
}
