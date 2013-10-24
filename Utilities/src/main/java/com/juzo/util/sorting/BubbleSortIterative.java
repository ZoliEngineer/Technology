package sorting;

import java.util.Arrays;

//382.730
//249.869.746
public class BubbleSortIterative implements Sort {
    // public static int counter = 0;// 4950
    @Override
    public int[] sort(int[] unsortedList) {
        int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);
        int unsortedLength = unsortedList.length;

        for (int i = 0; i < copyUnsorted.length; i++, unsortedLength--) {
            for (int j = 0; j < unsortedLength - 1; j++) {
                if (copyUnsorted[j] > copyUnsorted[j + 1]) {
                    swap(copyUnsorted, j, j + 1);
                }
            }
        }

        return copyUnsorted;
    }


    private void swap(int[] array, int pos1, int pos2) {
        // array[pos1] = array[pos1] ^ array[pos2];
        // array[pos2] = array[pos1] ^ array[pos2];
        // array[pos1] = array[pos1] ^ array[pos2];
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }


}
