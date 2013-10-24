package sorting;

import java.util.Arrays;

//91.631
//2.081.270
public class QuickSortInPlace implements Sort {

    @Override
    public int[] sort(final int[] unsortedList) {
        final int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);
        return sortSublistRecursive(copyUnsorted, 0, unsortedList.length - 1);
    }

    public int[] sortSublistRecursive(final int[] array, final int startIndex, final int endIndex) {
        if (endIndex - startIndex < 1) {
            return array;
        }
        final int pivot = processPartition(array, startIndex, endIndex);

        sortSublistRecursive(array, startIndex, pivot - 1);
        sortSublistRecursive(array, pivot + 1, endIndex);

        return array;
    }

    private final int processPartition(final int[] array, final int startIndex, final int endIndex) {
        final int pivotIndex = (startIndex + endIndex) / 2;
        final int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, endIndex); // move pivot to the end

        int highIndex = endIndex;
        for (int lowIndex = startIndex; lowIndex < highIndex; lowIndex++) { // move lowIndex towards the highIndex
            if (array[lowIndex] > pivotValue) {
                while (array[highIndex] >= pivotValue && lowIndex < highIndex) { // move highIndex towards the lowIndex
                    highIndex--;
                }
                swap(array, lowIndex, highIndex);
            }

        }
        swap(array, endIndex, highIndex); // move pivot back to its final place
        return highIndex;
    }

    private final void swap(final int[] array, final int pos1, final int pos2) {
        final int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
