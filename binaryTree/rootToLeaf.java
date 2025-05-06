import java.util.ArrayList;

public class rootToLeaf {

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

    public static void rootToLeafNode(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.data);

        if (root.left == null && root.right == null) {
            print(list);
        }

        rootToLeafNode(root.left, list);
        rootToLeafNode(root.right, list);
        list.remove(list.size() - 1);
    }

    public static void print(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(11);
        rootToLeafNode(root, list);
    }
}