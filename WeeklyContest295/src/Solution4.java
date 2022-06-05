import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution4 {
    public int minimumObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int size = row * col;

        int[] grid1D = new int[size];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid1D[rcTo1D(i, j, col)] = grid[i][j];
            }
        }

        int[] distTo = new int[size];
        for (int i = 0; i < size; i += 1) {
            distTo[i] = Integer.MAX_VALUE;
        }

        int s = 0;
        int t = size - 1;
        distTo[s] = 0;
        PriorityQueue<Node> fringe = new PriorityQueue<>();
        fringe.add(new Node(s, distTo[s]));
        while (!fringe.isEmpty()) {
            int p = fringe.poll().grid;
            for (int w: adj(p, row, col)) {
                int newDist = distTo[p] + grid1D[w];
                if (newDist < distTo[w]) {
                    distTo[w] = newDist;
                    fringe.add(new Node(w, distTo[w]));
                    if (w == t) {
                        return distTo[t];
                    }
                }
            }
        }
        return distTo[t];
    }

    private int rcTo1D(int r, int c, int col) {
        return r * col + c;
    }

    private Iterable<Integer> adj(int v, int row, int col) {
        int r = v / col;
        int c = v % col;
        TreeSet<Integer> neighbors = new TreeSet<>();
        if (r - 1 >= 0) {
            neighbors.add(rcTo1D(r - 1, c, col));
        }
        if (r + 1 < row) {
            neighbors.add(rcTo1D(r + 1, c, col));
        }
        if (c - 1 >= 0) {
            neighbors.add(rcTo1D(r, c - 1, col));
        }
        if (c + 1 < col) {
            neighbors.add(rcTo1D(r, c + 1, col));
        }
        return neighbors;
    }

    private static class Node implements Comparable<Node>{
        int grid;
        int length;

        Node(int grid, int length) {
            this.grid = grid;
            this.length = length;
        }

        @Override
        public int compareTo(Node n){
            return length - n.length;
        }
    }
}
