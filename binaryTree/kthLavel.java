public class kthLavel {

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
    public static void klavel(node root, int n, int k){
        if( root==null){
            return ;
        }
          if(n==k){
            System.out.print(root.data+"  ");
            return; // because we know this is lavel so there ther is no need to go downword;
          }
        klavel(root.left, n+1, k);
        klavel(root.right, n+1, k);


    }

    public static void main(String[] args) {
        
        node root = new node(1);
        root.left = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right = new node(3);
        root.right.left = new node(6);
        root.right.right = new node(7);
        klavel(root,1,3);
    }

    
    
}
