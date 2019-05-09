package date20190509;

public class Find {
    /**
     * 二分查找
     *
     * @param args
     */
    public static void main(String[] args) {
        int sort = sort(new int[]{1, 2, 3, 4, 5, 6}, 5);
        System.out.println(sort);
    }

    /**
     * @param arr 版本数组
     * @param a   传入的版本号
     * @return
     */
    public static int sort(int[] arr, int a) {
        int start = 0;
        int end = arr.length;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == a) {
                return mid + 1;
            } else if (arr[mid] < a) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
