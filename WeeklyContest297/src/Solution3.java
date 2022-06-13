class Solution3 {
    int answer = Integer.MAX_VALUE;
    int[] cookies;
    public int distributeCookies(int[] cookies, int k) {
        this.cookies = cookies;
        int[] children = new int[k];
        for (int i = 0; i < k; i++) {
            children[i] = 0;
        }
        distributeCookiesHelper(0, children);
        return answer;
    }

    private void distributeCookiesHelper(int index, int[] children) {
        if (index == cookies.length) {
            int max = Integer.MIN_VALUE;
            for (int child : children) {
                if (child > max) {
                    max = child;
                }
            }
            if (max < answer) {
                answer = max;
            }
            return;
        }

        for (int child : children) {
            if (child > answer) {
                return;
            }
        }

        for (int i = 0; i < children.length; i++) {
            children[i] += cookies[index];
            distributeCookiesHelper(index + 1, children);
            children[i] -= cookies[index];
        }
    }
}
