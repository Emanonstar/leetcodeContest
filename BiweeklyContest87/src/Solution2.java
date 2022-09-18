import java.util.Arrays;

class Solution2 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i = 0, j = 0;
        int ans = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                ans += 1;
                i += 1;
            }
            j += 1;
        }
        return ans;
    }
}
