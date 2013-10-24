package sorting;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MergeSortParalell implements Sort {
    @Override
    public int[] sort(int[] unsortedList) {
        final int[] copyUnsorted = Arrays.copyOf(unsortedList, unsortedList.length);

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.invoke(new MergeSortTask(copyUnsorted, 0, unsortedList.length - 1));

        return copyUnsorted;
    }



    private static class MergeSortTask extends RecursiveAction {
        private static final long serialVersionUID = 1L;
        private final int[] array;
        private final int startIndex;
        private final int endIndex;

        public MergeSortTask(int[] array, int startIndex, int endIndex) {
            super();
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }


        @Override
        protected void compute() {
            if (endIndex - startIndex < 1) {
                return;
            }

            int middleIndex = (endIndex + startIndex) / 2;

            MergeSortTask left = new MergeSortTask(array, startIndex, middleIndex);
            MergeSortTask right = new MergeSortTask(array, middleIndex + 1, endIndex);
            invokeAll(left, right);
            merge(array, startIndex, middleIndex, middleIndex + 1, endIndex);
        }

        private void merge(final int[] array, final int startIndex1, final int endIndex1, final int startIndex2,
                final int endIndex2) {
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
}
