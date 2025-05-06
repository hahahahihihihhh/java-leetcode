package Problem;

public class T670 {

    void swap(StringBuilder sb, int x, int y) {
        char c = sb.charAt(x);
        sb.setCharAt(x, sb.charAt(y));
        sb.setCharAt(y, c);
    }

    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        int max = num;
        for (int i = 0; i < sb.length(); i ++) {
            for (int j = i + 1; j < sb.length(); j ++) {
                swap(sb, i, j);
                int cur = Integer.parseInt(sb.toString());
                max = Math.max(cur, max);
                swap(sb, i, j);
            }
        }
        return max;
    }

}
