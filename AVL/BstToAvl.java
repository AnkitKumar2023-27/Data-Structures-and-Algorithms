import java.util.ArrayList;

public class BstToAvl {

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

    public static void inOrder(Node root, ArrayList<Node> inorder) {
        if (root == null) {
            return;
        }

        inOrder(root.left, inorder);
        inorder.add(root);
        inOrder(root.right, inorder);
    }

    public static Node BstToavl(Node root) {

        ArrayList<Node> inorder = new ArrayList<>();
        inOrder(root, inorder);

        return AVL(inorder, 0, inorder.size() - 1);

    }

    public static Node AVL(ArrayList<Node> inorder, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid).data); // Corrected: Create a new node with the data
        root.left = AVL(inorder, st, mid - 1);
        root.right = AVL(inorder, mid + 1, end);
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(12); // Corrected: Removed duplicate assignment

        Node avlRoot = BstToavl(root);
        System.out.println("Preorder traversal of the converted AVL tree:");
        preOrder(avlRoot);
        System.out.println();
    }
}