class Solution1 {
    public boolean haveConflict(String[] event1, String[] event2) {
        double[] times1 = trans(event1);
        double[] times2 = trans(event2);
        if (times1[0] > times2[1] || times1[1] < times2[0]) {
            return false;
        }
        return true;
    }

    private double[] trans(String[] s) {
        double[] time = new double[2];
        time[0] = Double.valueOf(s[0].substring(0, 2)) + Double.valueOf(s[0].substring(3)) / 60.0;
        time[1] = Double.valueOf(s[1].substring(0, 2)) + Double.valueOf(s[1].substring(3)) / 60.0;
        return time;
    }
}
