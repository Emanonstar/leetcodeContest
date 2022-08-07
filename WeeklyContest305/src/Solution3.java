class Solution3 {
//    public boolean validPartition(int[] nums) {
//        int l = nums.length;
//        boolean[] validAt = new boolean[l];
//        validAt[0] = false;
//        validAt[1] = valid2(nums[0], nums[1]);
//        if (l == 2) {
//            return validAt[1];
//        }
//
//        validAt[2] = valid3(nums[0], nums[1], nums[2]);
//        if (l == 3) {
//            return validAt[2];
//        }
//
//        for (int i = 3; i < l; i++) {
//            validAt[i] = (valid2(nums[i - 1], nums[i]) && validAt[i - 2])
//                    || (valid3(nums[i - 2], nums[i - 1], nums[i]) && validAt[i - 3]);
//        }
//        return validAt[l - 1];
//    }
public boolean validPartition(int[] nums) {
    int l = nums.length;
    boolean[] validAt = new boolean[4];
    validAt[0] = false;
    validAt[1] = valid2(nums[0], nums[1]);
    if (l == 2) {
        return validAt[1];
    }

    validAt[2] = valid3(nums[0], nums[1], nums[2]);
    if (l == 3) {
        return validAt[2];
    }

    validAt[3] = (valid2(nums[2], nums[3]) && validAt[1])
            || (valid3(nums[1], nums[2], nums[3]) && validAt[0]);
    for (int i = 4; i < l; i++) {
        for (int j = 0; j < 3; j++) {
            validAt[j] = validAt[j + 1];
        }
        validAt[3] = (valid2(nums[i - 1], nums[i]) && validAt[1])
                || (valid3(nums[i - 2], nums[i - 1], nums[i]) && validAt[0]);
    }
    return validAt[3];
}

    private boolean valid2(int a, int b) {
        return a == b;
    }

    private boolean equals(int a, int b, int c) {
        return (a == b) && (b == c);
    }

    private boolean valid3(int a, int b, int c) {
        return equals(a, b, c) || equals(a, b - 1, c - 2);
    }

}
