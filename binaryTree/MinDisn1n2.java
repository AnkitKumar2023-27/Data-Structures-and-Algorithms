import java.util.ArrayList;
import java.util.List;

public class MinDisn1n2 {

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

    // Function to find the path from the root to a given node.
    public static boolean getPath(Node root, int n, List<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundPath1 = getPath(root.left, n, path);
        boolean foundPath2 = getPath(root.right, n, path);
        if (foundPath1 || foundPath2) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    // Function to find the Lowest Common Ancestor (LCA) of two nodes.
    public static Node findLCA(Node root, int n1, int n2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();

        //If either n1 or n2 is not present, return null
        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null;
        }

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        //Handles the case where n1 or n2 is the root.
        return path1.get(i - 1);
    }

    // Function to find the distance between two nodes in a tree, given their LCA.
    public static int findDistance(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDistance = findDistance(root.left, n);
        int rightDistance = findDistance(root.right, n);

        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        } else if (leftDistance != -1) {
            return leftDistance + 1;
        } else {
            return rightDistance + 1;
        }
    }

    // Function to find the minimum distance between two nodes in a binary tree.
    public static int minDistance(Node root, int n1, int n2) {
        Node lca = findLCA(root, n1, n2);
        if (lca == null) return -1; //Handle the case where LCA is null

        int distance1 = findDistance(lca, n1);
        int distance2 = findDistance(lca, n2);

        return distance1 + distance2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4;
        int n2 = 6;

        int distance = minDistance(root, n1, n2);
        if(distance == -1){
            System.out.println("One or both nodes are not present in the tree.");
        }
        else{
            System.out.println("Minimum distance between " + n1 + " and " + n2 + " is: " + distance);
        }

        int n3 = 4;
        int n4 = 8; // 8 is not in the tree
        distance = minDistance(root, n3, n4);
        if(distance == -1){
            System.out.println("One or both nodes are not present in the tree.");
        }
        else{
            System.out.println("Minimum distance between " + n3 + " and " + n4 + " is: " + distance);
        }
        
    }
}
