package a7;

public class LabeledVertex implements Vertex {

	private String _label;
	private Vertex _path_from_source;
	private int _distance_from_source;
	
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
			// Null result used to indicate we are at the source.
			return null;
		}
		
		return _path_from_source;
	}

	@Override
	public void setPathFromSource(Vertex v) {
		_path_from_source = v;
		if (v != null) {
			if (v == this) {
				_distance_from_source = 0;
			} else {
				_distance_from_source = v.getDistanceFromSource()+1;
			}
		} else {
			_distance_from_source = -1;
		}			
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
}
