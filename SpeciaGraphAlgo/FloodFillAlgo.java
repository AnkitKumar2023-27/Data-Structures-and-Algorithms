public class FloodFillAlgo {

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return; 
        boolean[][] visited = new boolean[image.length][image[0].length];
        fill(image, sr, sc, newColor, originalColor, visited);
    }

 private static void fill(int[][] image, int sr, int sc, int newColor, int originalColor, boolean[][] visited) {

        if  (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ||
            visited[sr][sc] || image[sr][sc] != originalColor) {
            return;
        }

        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        
         fill(image, sr + 1, sc, newColor, originalColor, visited);
        fill(image, sr - 1, sc, newColor, originalColor, visited);
         fill(image, sr, sc + 1, newColor, originalColor, visited);
        fill(image, sr, sc - 1, newColor, originalColor, visited);
    }


    public static void printImage(int[][] image) {
        for (int i=0;i<image.length;i++) {
            for (int j=0;j<image[i].length;j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        System.out.println("Original Image:");
        printImage(image);

        floodFill(image, sr, sc, newColor);

        System.out.println("\nImage After Flood Fill:");
        printImage(image);
    }
}
