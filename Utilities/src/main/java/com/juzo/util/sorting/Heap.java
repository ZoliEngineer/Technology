package sorting;

public interface Heap {
    int getMin();

    void delete(int i);

    void insert(int i);

    int[] getLowerThan(int i);

    int getSorted();
}
