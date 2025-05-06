import java.util.ArrayList;

public class MeargeTwoBst {

    public  static class  Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data=data;
            this.left=null;
            this.right=null;
        
            
        }
    
        
    }

    public static void inorder(ArrayList<Integer>list,Node root){
        if(root==null){
            return;
        }
        inorder(list, root.left);
        list.add(root.data);
        inorder(list, root.right);

    }

    public static Node meargeTwoBst (Node root1,Node root2){
        ArrayList<Integer> arr1=new ArrayList<>();
        inorder(arr1,root1);
        ArrayList<Integer> arr2=new ArrayList<>();
        inorder(arr2,root2);

        ArrayList<Integer>finalArr=new ArrayList<>();
        int i=0;
        int j=0;

        
        while (i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i)<=arr2.get(j)){

            finalArr.add(arr1.get(i));
            i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
            
        }

        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }while ((j<arr2.size())) {
            finalArr.add(arr2.get(j));
                j++;
            
        }

      return CreateBst(0, finalArr.size()-1, finalArr);

    }

    public static void preOrder(Node root){
        if(root==null){
            return ;
        }

        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node CreateBst(int st,int end,ArrayList<Integer>finalarr){
        if(st>end){
            return  null;
        }

        int mid=(st+end)/2;
        Node root=new Node(finalarr.get(mid));
        root.left=CreateBst(st, mid-1, finalarr);
        root.right=CreateBst(mid+1,end, finalarr);
        return root;
    }


    public static void main(String[] args) {
        Node root1=new Node(9);
        root1 .left=new Node(3);
        root1.right=new Node(12);
        Node root2=new Node(2);
         root2.left=new Node(1);
         root2.right= new Node(4);

       Node root=  meargeTwoBst(root1,root2);
         preOrder(root);
        
    }
    
}
