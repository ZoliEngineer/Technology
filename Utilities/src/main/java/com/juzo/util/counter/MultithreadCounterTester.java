package counter;

import java.util.concurrent.CountDownLatch;

public class MultithreadCounterTester {
    public static void main(String... args) throws InterruptedException {
        Counter unsafeCounter = new UnsafeCounter();

        final int NUM_OF_THREADS = 5;
        final int LENGTH_OF_TEST = 10000000;
        MultithreadCounterTester tester = new MultithreadCounterTester();

        tester.runTest(unsafeCounter, NUM_OF_THREADS, LENGTH_OF_TEST);
    }

    public void runTest(final Counter counter, final int numberOfThreads, final int testLength) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        Thread[] workers = new Thread[numberOfThreads];
        long startTime, endTime;
        for (int i = numberOfThreads - 1; i >= 0; i--) {
            workers[i] = new Thread(new Worker(counter, testLength, latch));
        }
        startTime = System.nanoTime();
        for (Thread t : workers) {
            t.start();
        }
        latch.await();
        endTime = System.nanoTime();

        System.out.println("Run time in nanos: " + (endTime - startTime));
        System.out.println("Expected counter state: " + (numberOfThreads * testLength));
        System.out.println("Actual counter state: " + (counter.get()));

    }



    private static class Worker implements Runnable {
        private final Counter counter;
        private final int workLength;
        private final CountDownLatch latch;

        public Worker(final Counter counter, final int workLength, final CountDownLatch latch) {
            this.counter = counter;
            this.workLength = workLength;
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i = workLength; i > 0; i--) {
                counter.increment();
            }
            latch.countDown();
        }

    }
}
