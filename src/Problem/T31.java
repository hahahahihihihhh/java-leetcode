package Problem;

public class T31 {

    void swap(int x, int y, int[] a) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    void reverse(int l, int r, int[] a) {
        for (int i = l, j = r; i < j; i ++, j --) {
            swap(i, j, a);
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int r = n - 1;
        while (r > 0 && nums[r] <= nums[r - 1]) {
            r --;
        }
        if (r != 0) {
            for (int i = n - 1; i >= r; i --) {
                if (nums[i] > nums[r - 1]) {
                    swap(i, r - 1, nums);
                    break ;
                }
            }
        }
        reverse(r, n - 1, nums);
    }

}
