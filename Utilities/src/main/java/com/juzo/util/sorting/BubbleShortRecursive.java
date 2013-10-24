package sorting;

import java.util.Arrays;

//398095
public class BubbleShortRecursive implements Sort {
    // public static int counter = 0;// 4950

    @Override
    public int[] sort(int[] unsortedList) {
        int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);
        return recursiveSort(copyUnsorted, copyUnsorted.length);
    }

    private int[] recursiveSort(int[] unsortedList, int unsortedLength) {
        if (unsortedLength <= 1) {
            return unsortedList;
        }
        for (int j = 0; j < unsortedLength - 1; j++) {
            if (unsortedList[j] > unsortedList[j + 1]) {
                swap(unsortedList, j, j + 1);
            }
        }

        return recursiveSort(unsortedList, unsortedLength - 1);
    }

    private void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

}
