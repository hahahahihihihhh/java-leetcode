package Problem;

public class T12 {

    public String intToRoman(int num) {
        char[][] roman = {{'V', 'I'}, {'L', 'X'}, {'D', 'C'}, {' ', 'M'}};
        StringBuilder ans = new StringBuilder();
        for (int i = 3; i >= 0; i --) {
            int c = (num / (int) Math.pow(10, i)) % 10;
            if (c < 4) {
                for (int j = 1; j <= c; j ++) {
                    ans.append(roman[i][1]);
                }
            } else if (c == 4) {
                ans.append(roman[i][1]);
                ans.append(roman[i][0]);
            } else if (c == 9) {
                ans.append(roman[i][1]);
                ans.append(roman[i + 1][1]);
            } else {
                ans.append(roman[i][0]);
                for (int j = 6; j <= c; j ++) {
                    ans.append(roman[i][1]);
                }
            }
        }
        return ans.toString();
    }

}
