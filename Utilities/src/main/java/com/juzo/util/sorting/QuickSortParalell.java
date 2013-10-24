package sorting;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//6.363.937
//527.950.899
public class QuickSortParalell implements Sort {

    @Override
    public int[] sort(int[] unsortedList) {
        int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);

        ForkJoinPool pool = new ForkJoinPool(4);
        SortTask bigTask = new SortTask(copyUnsorted, 0, unsortedList.length - 1);
        pool.invoke(bigTask);
        try {
            bigTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return copyUnsorted;
    }

    private static class SortTask extends RecursiveTask {
        final int[] array;
        final int startIndex;
        final int endIndex;

        public SortTask(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        protected int[] compute() {
            if (endIndex - startIndex < 1) {
                return array;
            }
            int pivot = processSublist(array, startIndex, endIndex);
            SortTask task1 = new SortTask(array, startIndex, pivot - 1);
            SortTask task2 = new SortTask(array, pivot + 1, endIndex);
            try {
                task1.fork();
                task2.fork();
                task1.get();
                task2.get();
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return array;
        }

        private int processSublist(int[] array, int startIndex, int endIndex) {
            int pivotIndex = (startIndex + endIndex) / 2;
            int pivotValue = array[pivotIndex];
            swap(array, pivotIndex, endIndex);

            int highPosition = endIndex;
            for (int lowPosition = startIndex; lowPosition < highPosition; lowPosition++) {
                if (array[lowPosition] > pivotValue) {
                    while (array[highPosition] >= pivotValue && lowPosition < highPosition) {
                        highPosition--;
                    }
                    swap(array, lowPosition, highPosition);
                }

            }
            swap(array, endIndex, highPosition);
            return highPosition;
        }

    }

    private static void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
