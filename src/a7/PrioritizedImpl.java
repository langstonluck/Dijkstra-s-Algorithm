package a7;

public class PrioritizedImpl<V> implements Prioritized<V>{

	private V _value;
	private int _priority;
	
	public PrioritizedImpl(V value, int priority) {
		_value = value;
		_priority = priority;
	}
	
	@Override
	public V getValue() {
		return _value;
	}

	@Override
	public int getPriority() {
		return _priority;
	}
	
	@Override
	public int compareTo(Prioritized<V> other) {
		
		if (this.getPriority() < other.getPriority())
			return -1;
		else if (this.getPriority() == other.getPriority())
			return 0;
		else 
			return 1;
		
	}

}
