package a7;

public interface Prioritized<V>  extends Comparable<Prioritized<V>> {
	V getValue();
	int getPriority();
    int compareTo(Prioritized<V> other);
}
