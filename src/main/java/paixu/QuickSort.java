package paixu;

public class QuickSort {
    public static void sort(int[] a, int left, int right, int point) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (leftPtr < rightPtr && a[++leftPtr] < point) ;
            while (rightPtr > leftPtr && a[--rightPtr] > point) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                int tmp = a[rightPtr];
                a[rightPtr] = a[leftPtr];
                a[leftPtr] = tmp;
            }
        }
        int tmp = a[right];
        a[right] = a[leftPtr];
        a[leftPtr] = tmp;
    }


}
