
public class DeadLock {
    public static void main(String[] args) {

        Integer a = new Integer(1000);
        Integer b = new Integer(1000);

        Bank bank1 = new Bank("A", a, b);
        Bank bank2 = new Bank("B", b, a);

        new Thread(bank1).start();
        new Thread(bank2).start();

    }

    protected static class Bank implements Runnable {
        private final Integer a;
        private final Integer b;
        private final String name;

        public Bank(String name, Integer a, Integer b) {
            this.name = name;
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                transfer(10, a, b);
                System.out.println(name + " " + a + " " + b);
            }
        }

        public void transfer(int amount, Integer from, Integer to) {
            synchronized (from) {
                Thread.yield();
                synchronized (to) {
                    from -= amount;
                    to += amount;
                }
            }
        }

    }


}
