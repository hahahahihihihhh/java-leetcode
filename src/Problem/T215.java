package Problem;

public class T215 {

    int qselect(int[] a, int l, int r, int k) {
        System.out.println(l + " " + r  + " " + k);
        if (l == r) return a[k];
        int i = l - 1, j = r + 1;
        int x = a[l];
        while (i < j) {
            do i ++; while (a[i] < x);
            do j --; while (a[j] > x);
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        if (j >= k) {
            return qselect(a, l, j, k);
        } else {
            return qselect(a, j + 1, r, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return qselect(nums, 0, n - 1, n - k);
    }

}
