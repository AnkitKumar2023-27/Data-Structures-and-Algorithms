public class searchAvlInBst {
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

    public static class Info {
        boolean isBst;
        int size;
        int min;
        int max;

        public Info(boolean isbst, int size, int min, int max) {
            this.isBst = isbst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBstSize = 0;

    public static Info largestBst(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBst(root.left);
        Info rightInfo = largestBst(root.right);

        int currentMin = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int currentMax = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int currentSize = leftInfo.size + rightInfo.size + 1;

        if (leftInfo.isBst && rightInfo.isBst) {
            if (root.data > leftInfo.max && root.data < rightInfo.min) {
                maxBstSize = Math.max(maxBstSize, currentSize);
                return new Info(true, currentSize, currentMin, currentMax);
            }
        }

        return new Info(false, currentSize, currentMin, currentMax);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        largestBst(root);
        System.out.println("Size of the largest BST in the tree: " + maxBstSize);
    }
}