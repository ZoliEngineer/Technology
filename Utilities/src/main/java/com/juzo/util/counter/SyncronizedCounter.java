package counter;

public class SyncronizedCounter implements Counter {
    private int counter = 0;

    @Override
    public synchronized void increment() {
        counter++;
    }

    @Override
    public synchronized int get() {
        return counter;
    }

}
