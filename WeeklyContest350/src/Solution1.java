class Solution1 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5 && additionalTank > 0) {
            mainTank -= 5;
            ans += 5;
            additionalTank -= 1;
            mainTank += 1;
        }
        ans += mainTank;
        return ans * 10;
    }
}
