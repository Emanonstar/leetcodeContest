class Solution1 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int l = energy.length;
        int energyNeed = 1;
        int experienceNeed = 1;
        int totalExperience = 1;
        for (int i = 0; i < l; i++) {
            energyNeed += energy[i];
        }

        for (int i = 0; i < l; i++) {
            if (totalExperience <= experience[i]) {
                experienceNeed += (experience[i] + 1 - totalExperience);
                totalExperience = experience[i] + 1;
            }
            totalExperience += experience[i];
        }

        return Integer.max(energyNeed - initialEnergy, 0) + Integer.max(experienceNeed  - initialExperience, 0);
    }
}
