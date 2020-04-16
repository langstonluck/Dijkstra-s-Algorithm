package a7;

public class LabeledVertex implements Vertex {

	private String _label;
	private Vertex _path_from_source;
	private int _distance_from_source;
	private boolean _processed;
	
	public LabeledVertex(String label) {
		if (label == null) {
			throw new IllegalArgumentException();
		}
		
		_label = label;		
		_path_from_source = null;
		_distance_from_source = 0;
	}
	
	@Override
	public String toString() {
		return _label;
	}
	
	public String getLabel() {
		return _label;
	}

	@Override
	public Vertex getPathFromSource() {
		if (_path_from_source == null) {
			throw new RuntimeException("No path from source");
		}
		
		if (_path_from_source == this) {
			
			return null;
		}
		
		return _path_from_source;
	}

	@Override
	public boolean setPathFromSource(Vertex v, int weight) {
		
		if (v != null) {
			if (v == this) {
				_distance_from_source = 0;
				_path_from_source = v;
				return true;

			} else {
				
				if (_distance_from_source <= v.getDistanceFromSource() + weight)  {
					return false;
				} else {
					_distance_from_source = v.getDistanceFromSource()+ weight;
					_path_from_source = v;
					return true;

				}
			}
		} else {
			_distance_from_source = Integer.MAX_VALUE;
			return true;
		}			
	}
	@Override
	public void clearPathToSource() {
		setPathFromSource(null, 0);
		setProcessed(false);
		_distance_from_source = Integer.MAX_VALUE;
		
	}

	@Override
	public int getDistanceFromSource() {
		if (_path_from_source == null) {
			throw new RuntimeException("No path from source");
		}
		return _distance_from_source;
	}

	@Override
	public boolean hasPathFromSource() {
		return _path_from_source != null;
	}
	
	public boolean hasProcessed() {
		return _processed;
	}
	
	public void setProcessed(boolean processed) {
		_processed = processed; 
		return;
	}
	
	public int compareTo(Vertex other) {
		if (this.getDistanceFromSource() < other.getDistanceFromSource()) {
			return -1;
		} else if (this.getDistanceFromSource() == other.getDistanceFromSource()) {
			return 0;
		} else return 1;
		
	}
}
