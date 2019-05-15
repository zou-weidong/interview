package paixu;

/**
 * 直接选择排序 复杂度O(n~2) 不稳定
 * 大部分已排好较好
 */
public class StraightSelectionSort {
    public static void sort(int[] a) {
        int k, tmp;
        for (int i = 0; i < a.length - 1; i++) { //遍历的次数
            k = i;                  //变量k指向最小的数的下标，从0开始
            for (int j = i + 1; j < a.length; j++) { //从前向后遍历，然后用k指向最小的元素的下标
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            tmp = a[i];         //每一趟从第一位开始排序
            a[i] = a[k];
            a[k] = tmp;
        }
        TestSort.disPlay(a);
    }
}
