package counter;

public class NonBlockingCounter implements Counter {
    private int[] counter = new int[];


    @Override
    public void increment() {
        counter++;
    }

    @Override
    public int get() {
        return counter;
    }

}
