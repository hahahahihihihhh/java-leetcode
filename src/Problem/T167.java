package Problem;

public class T167 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        for (; l < n; l ++) {
            while (r > l && numbers[l] + numbers[r] > target) r --;
            if (numbers[l] + numbers[r] == target)  return new int[]{l + 1, r + 1};
        }
        return new int[]{0, 0};
    }

}
