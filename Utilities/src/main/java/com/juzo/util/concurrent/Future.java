
public class Future<T> {
    T content = null;

    public synchronized void put(T content) {
        this.content = content;
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (content == null) {
            wait();
        }
        return content;
    }

}
