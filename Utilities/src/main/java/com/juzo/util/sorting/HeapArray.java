package sorting;

public class HeapArray extends HeapSort implements Heap{
    private static final int DEFAULT_SIZE = 8;

    private int[] queue;
    private int endIndex;


    public HeapArray() {
        this(DEFAULT_SIZE);
    }

    public HeapArray(int initSize) {
        queue = new int[initSize];
        endIndex = 0;
    }

    public HeapArray(int[] initArray) {
        this.queue = heapify(defensiveCopy(initArray));
        endIndex = initArray.length;
    }

    // /////////////////
    @Override
    public
    int getMin(){
    int minElement = queue[0];
    swap(queue, 0, endIndex-1);
    shiftDown(...);
    endIndex--;
//TODO: call delete instead
    return minElement;

    }

    int readMin() {
        return queue[0];
    }

    @Override
    void delete(int i) {
    }

    @Override
    void insert(int i){
    addToEnd(i);
    swap(queue, 0, endIndex-1);
    shiftDown(...);
}

    int[] getLowerThan(int i, boolean sorted) {
    }

    @Override
    public int[] getSorted() {
        return sort(queue);
    }

    // /////////////////
    private void addToEnd(int newElement) {
        if (endIndex == queue.length) {
            resize();
        }
        queue[endIndex++] = newElement;
    }

    private void resize() {
        int[] newQueue = new int[queue.length * 2];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        queue = newQueue;
    }
}
