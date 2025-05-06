

public class SubTree {


    public static class node {
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    public static boolean isSubtree(node root,node SubRoot){
        if(root==null){
            return false;

        }
        if(root.data==SubRoot.data){
            if(isIdentical(root, SubRoot)){
                return true;
            }
        }

       return isSubtree(root.left,SubRoot)||isSubtree(root.right,SubRoot);
    }
      public static boolean isIdentical(node root,node SubRoot){
        if(root==null&& SubRoot==null){
            return true;

        }else if(root==null||SubRoot==null||root.data!=SubRoot.data){
            return false;
        
        }
        if(!isIdentical(root.left, SubRoot.left)){
          return false;  
        }
        
        if(!isIdentical(root.right, SubRoot.right)){
             return false;
        }
        return true;
     
      }
      
      
    


    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right = new node(3);
        root.right.left = new node(6);
        root.right.right = new node(7);


        node SubRoot = new node(3);
        SubRoot.left = new node(6);
        SubRoot.right=new node(7);

        System.out.println(isSubtree(root, SubRoot));
    }
    
}
