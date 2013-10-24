package sorting;

import java.util.Arrays;

//129.346
//2.800.076
public class MergeSortRecursive implements Sort {

    @Override
    public int[] sort(int[] unsortedList) {
        final int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);
        return mergeSortRecursive(copyUnsorted, 0, unsortedList.length - 1);
    }

    private int[] mergeSortRecursive(int[] array, int startIndex, int endIndex) {
        if (endIndex - startIndex < 1) {
            return array;
        }

        int middleIndex = (endIndex + startIndex) / 2;

        mergeSortRecursive(array, startIndex, middleIndex);
        mergeSortRecursive(array, middleIndex + 1, endIndex);
        merge(array, startIndex, middleIndex, middleIndex + 1, endIndex);

        return array;
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
