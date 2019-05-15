package paixu;

public class TestSort {
    public static void main(String[] args) {
        int[] ints = {1, 3, 55, 3, 56, 100, 56, 434, 2, 66};
//        BubbleSort.sort(ints);
//        StraightSelectionSort.sort(ints);
//        InsertSort.sort1(ints);
//        Shell.sort(ints);
        disPlay(ints);
        QuickSort.sort(ints, 0, ints.length - 1, ints[ints.length - 1]);
        disPlay(ints);

    }


    public static void disPlay(int[] a) {
        System.out.print("[");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
    }

}
