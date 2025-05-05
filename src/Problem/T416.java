package Problem;

import java.util.*;

public class T416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1)    return false;
        int tar = sum / 2;
        boolean[][] can = new boolean[2][tar + 1];
        Arrays.sort(nums);
        can[0][0] = true;
        for (int num : nums) {
            for (int j = 0; j + num <= tar; j ++) {
                if (can[0][j]) {
                    can[1][j + num] = true;
                }
            }
            for (int j = 0; j <= tar; j ++) {
                can[0][j] = can[1][j] | can[0][j];
                can[1][j] = false;
            }
        }
        return can[0][tar];
    }

}
