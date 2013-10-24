package counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void increment() {
        counter.incrementAndGet();

    }

    @Override
    public int get() {
        return counter.get();
    }

}
