import java.util.*;

public class NearByCarr {

    public static class Point implements Comparable<Point> { // Changed 'Points' to 'Point' and added 'static'
        int X;
        int y;
        int disSq;
        int i;

        public Point(int x, int y, int disSq, int i) { // Consistent indentation
            this.X = x;
            this.y = y;
            this.disSq = disSq;
            this.i = i;
        }

        @Override
        public int compareTo(Point p2) { // Changed 'Points' to 'Point'
            return this.disSq - p2.disSq; // Removed extra space
        }
    }

    public static void main(String[] args) {
        int[][] pts = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>(); // Changed 'Points' to 'Point'

        for (int i = 0; i < pts.length; i++) {
            int disSq = (pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1]);
            pq.add(new Point(pts[i][0], pts[i][1], disSq, i)); // Changed 'Points' to 'Point'
        }
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().i);
        }
    }
}