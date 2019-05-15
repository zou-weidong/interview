package paixu;

/**
 * 冒泡的平均时间0(n~2),最差也是这样，比较稳定，n较小时比较好
 * <p>
 * 从后向前查找最小数
 */
public class BubbleSort {


    public static void sort(int[] a) {
        TestSort.disPlay(a);
        int tmp;
        for (int i = 0; i < a.length - 1; i++) { //遍历的次数
            for (int j = a.length - 1; j > i; j--) { //从后向前遍历移动小的数
                if (a[j - 1] > a[j]) {
                    tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }

        TestSort.disPlay(a);
    }
}
