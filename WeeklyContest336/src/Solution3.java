import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public long beautifulSubarrays(int[] nums) {
        int l = nums.length;
        int[] Xors = new int[l + 1];
        Xors[0] = 0;
        for (int i = 0; i < l; i++) {
            Xors[i + 1] = Xors[i] ^ nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int Xor: Xors) {
            map.put(Xor, map.getOrDefault(Xor, 0) + 1);
        }
        long ans = 0;
        for (int k: map.keySet()) {
            int v = map.get(k);
            ans += (long)v * (v - 1) / 2;
        }
        return ans;
    }
}
