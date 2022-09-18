class Solution4 {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        Node root = new Node(-1);
        for (String w: words) {
            int l = w.length();
            Node node = root;
            for (int j = 0; j < l; j++) {
                int p = w.charAt(j) - 'a';
                if (node.array[p] == null) {
                    node.array[p] = new Node(1);
                } else {
                    node.array[p].val += 1;
                }
                node = node.array[p];
            }
        }

        for (int i = 0; i < n; i++) {
            String w = words[i];
            int l = w.length();
            Node node = root;
            for (int j = 0; j < l; j++) {
                int p = w.charAt(j) - 'a';
                node = node.array[p];
                ans[i] += node.val;
            }
        }
        return ans;
    }

    static class Node {
        int val;
        Node[] array;

        Node (int v) {
            val = v;
            array = new Node[26];
        }
    }
}
