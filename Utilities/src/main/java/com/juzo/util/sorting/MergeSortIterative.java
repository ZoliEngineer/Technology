package sorting;

import java.util.Arrays;

//125.156
//3.133.918
public class MergeSortIterative implements Sort {
    @Override
    public int[] sort(final int[] unsortedList) {
        final int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);
        return mergeSort(copyUnsorted);
    }

    private int[] mergeSort(final int[] unsortedList) {
        for (int i = 1; i < unsortedList.length; i *= 2) {
            for (int j = 0; j < unsortedList.length; j += (i * 2)) {
                merge(unsortedList, j, j + i - 1, j + i, Math.min((j + (i * 2) - 1), unsortedList.length - 1));
            }
        }
        return unsortedList;
    }

    private void merge(final int[] array, final int startIndex1, final int endIndex1, final int startIndex2, final int endIndex2) {
        final int length = endIndex2 - startIndex1 + 1;
        final int[] temp = new int[length];
        int firstPointer = startIndex1;
        int secondPointer = startIndex2;
        for (int i = 0; i < length; i++) {
            if (firstPointer < startIndex2 && (secondPointer > endIndex2 || array[firstPointer] < array[secondPointer])) {
                temp[i] = array[firstPointer++];
            } else {
                temp[i] = array[secondPointer++];
            }
        }
        System.arraycopy(temp, 0, array, startIndex1, length);
    }
}
