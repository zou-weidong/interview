package paixu;

/**
 * 希尔排序：
 * 建立在插入排序之上，为了解决插入排序的最明显缺点.
 * 加大插入排序中元素之间的间隔，并对这些间隔元素进行插入排序，
 */
public class Shell {
    public static void sort(int[] array) {
        int temp = 0;
        int lenth = array.length;
        int incre = array.length;

        while (true) {
            incre = incre / 2;

            for (int k = 0; k < incre; k++) {    //根据增量分为若干子序列

                for (int i = k + incre; i < lenth; i += incre) {

                    for (int j = i; j > k; j -= incre) {
                        if (array[j] < array[j - incre]) {
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }

            TestSort.disPlay(array);
        }
    }
}
