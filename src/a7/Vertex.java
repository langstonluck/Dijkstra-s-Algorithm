package a7;


public interface Vertex extends Comparable<Vertex>{

	Vertex getPathFromSource();
	boolean setPathFromSource(Vertex v, int weight); 
	default void clearPathToSource() {
		setPathFromSource(null, 0);
	}
	boolean hasPathFromSource();
	boolean hasProcessed();
	void setProcessed(boolean processed);
	int getDistanceFromSource();
	int compareTo(Vertex other);
	
}

