package sorting;

import java.util.Arrays;

public class HeapSort implements Sort {
    @Override
    public int[] sort(final int[] unsortedList) {
        final int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);
        return heapSort(copyUnsorted);
    }

    protected int[] defensiveCopy(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    protected int[] heapSort(final int[] array) {
        heapify(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, end, 0);
            end--;
            shiftDown(array, 0, end);
        }

        return array;
    }

    protected int[] heapify(final int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shiftDown(array, i, array.length - 1);
        }
        return array;
    }

    protected void shiftDown(int[] array, int start, int end) {

        int root = start;
        while (root * 2 + 1 < end) {
            int child = root * 2 + 1;
            int swap = root;
            if (array[swap] < array[child]) {
                swap = child;
            }
            if (child + 1 <= end && array[swap] < array[child + 1]) {
                swap = child + 1;
            }
            if (swap != root) {
                swap(array, root, swap);
                root = swap;
            } else {
                return;
            }
        }
    }

    protected void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

}
