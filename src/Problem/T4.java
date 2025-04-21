package Problem;

public class T4 {

    int findKth(int[] nums1, int[] nums2, int l1, int l2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        if (l1 == n1) {
            return nums2[l2 + k - 1];
        }
        if (l2 == n2) {
            return nums1[l1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }
        if (nums1[Math.min(l1 + k / 2 - 1, n1 - 1)] >= nums2[Math.min(l2 + k / 2 - 1, n2 - 1)]) {
            return findKth(nums1, nums2, l1, Math.min(l2 + k / 2, n2), k - Math.min(k / 2,  n2 - l2));
        } else {
            return findKth(nums1, nums2, Math.min(l1 + k / 2, n1), l2, k - Math.min(k / 2,  n1 - l1));
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int m1 = (n1 + n2 + 1) / 2;
        int m2 = (n1 + n2 + 1) / 2 + 1;
        return (n1 + n2) % 2 == 0 ? (findKth(nums1, nums2, 0, 0, m1) + findKth(nums1, nums2, 0, 0, m2)) / 2.0 : findKth(nums1, nums2, 0, 0, m1);
    }

}
