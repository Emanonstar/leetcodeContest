import java.util.Arrays;

class Solution2 {
    public long dividePlayers(int[] skill) {
        int l = skill.length;
        Arrays.sort(skill);
        long ans = 0;
        int sum = skill[0] + skill[l - 1];
        for (int i = 0; i < l / 2; i++) {
            if (skill[i] + skill[l - 1 - i] != sum) {
                return -1;
            } else {
                ans += (long) skill[i] * skill[l - 1 - i];
            }
        }
        return ans;
    }
}
