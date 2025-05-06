package Problem;

public class T75 {

    void swap(int l, int r, int[] a) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    int cal(int l, int d, int[] a) {
        int n = a.length;
        int l1 = l, l2;
        while (true) {
            while (l1 < n && a[l1] == d) l1 ++;
            l2 = l1;
            while (l2 < n && a[l2] != d) l2 ++;
            if (l2 == n)    break;
            swap(l1, l2, a);
        }
        return l1;
    }

    public void sortColors(int[] nums) {
        int cur = 0, nxt = 1;
        int n = nums.length;
        cal(cal(0, 0, nums), 1, nums);
    }

}
