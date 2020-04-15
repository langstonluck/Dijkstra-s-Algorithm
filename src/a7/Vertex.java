package a7;

public interface Vertex {

	Vertex getPathFromSource();
	void setPathFromSource(Vertex v);
	default void clearPathToSource() {
		setPathFromSource(null);
	}
	boolean hasPathFromSource();
	
	int getDistanceFromSource();
}
