package paixu;

public class InsertSort {
    /**
     * 插入排序
     * <p>
     * 思想是n-1个数已经排好序，把第n个数据插入到前面的有序数列中去，使得这n个也是排好序的
     * <p>
     * 缺点是：如果小的数字排列在右侧，那么需要大量的移动
     *
     * @param a
     */
    public static void sort1(int[] a) {
        int tmp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        TestSort.disPlay(a);
    }
}
