class Solution3 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] marked1 = new boolean[n];
        boolean[] marked2 = new boolean[n];
        int[] nodeFrom1 = new int[n];
        int[] nodeFrom2 = new int[n];


        for (int i = 0; i < n; i++) {
            nodeFrom1[i] = -1;
            nodeFrom2[i] = -1;
        }

        nodeFrom1[node1] = 0;
        nodeFrom2[node2] = 0;
        marked1[node1] = true;
        marked2[node2] = true;
        int p = node1;
        int d = 1;
        while(edges[p] != -1 && !marked1[edges[p]]) {
            int next = edges[p];
            marked1[next] = true;
            nodeFrom1[next] = d;
            p = next;
            d += 1;
        }

        p = node2;
        d = 1;
        while(edges[p] != -1 && !marked2[edges[p]]) {
            int next = edges[p];
            marked2[next] = true;
            nodeFrom2[next] = d;
            p = next;
            d += 1;
        }

        int minOfMax = Integer.MAX_VALUE;
        int rst = -1;
        for (int i = 0; i < n; i++) {
            if (nodeFrom1[i] != -1 && nodeFrom2[i] != -1) {
                int tmp = Integer.max(nodeFrom1[i], nodeFrom2[i]);
                if (tmp < minOfMax) {
                    minOfMax = tmp;
                    rst = i;
                }
            }
        }
        return rst;
    }
}
