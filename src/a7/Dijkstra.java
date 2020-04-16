package a7;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;



public class Dijkstra {

	public static boolean repeatVertex(Vertex x, Vertex y) {
		
		Vertex prior = x.getPathFromSource();

		while (prior != null) {
			if (prior== y) {
				return true;
			}
			
			prior = prior.getPathFromSource();
		}
		return false;
	}
	public static Map<Vertex, List<DirectedEdge>> SSSP(DirectedGraph g, Vertex src) {

		Set<Vertex> vertex_set = g.getVertices();
		for (Vertex v : vertex_set) {
			v.clearPathToSource();
		}
		
		
		src.setPathFromSource(src, 0);		
		Prioritized<Vertex> z= new PrioritizedImpl<Vertex>(src, src.getDistanceFromSource());

		
		Queue<Prioritized<Vertex>> vq = new PriorityQueue<Prioritized<Vertex>>();
		vq.add(z);
		
		
		while (vq.size() > 0) {
			Prioritized<Vertex> nextZ = vq.remove();
			Vertex next = nextZ.getValue();
			if (next.hasProcessed())
				continue;
			next.setProcessed(true);
			Vertex[] adjacent = g.getAdjacent(next);
			
			
			for (Vertex adj_vertex : adjacent) {
				
				    
				    if (repeatVertex(next,adj_vertex))
				    	continue;
				    
					DirectedEdge e1 = g.findEdge(next, adj_vertex);
					int weight = e1.getWeight();
					
					boolean didUpdate = adj_vertex.setPathFromSource(next, weight);
					
					if (didUpdate) {
						Prioritized<Vertex> z2= new PrioritizedImpl<Vertex>(adj_vertex, adj_vertex.getDistanceFromSource());
						vq.add(z2);
					}
						
				//} 
			}			
		}
		
		Map<Vertex, List<DirectedEdge>> map = new HashMap<>();
		
		for(Vertex v: vertex_set) {
			List<DirectedEdge> edges = new LinkedList<DirectedEdge>();
			Vertex end = v;
			
			if (end.hasPathFromSource()) {
				Vertex start = end.getPathFromSource();
				while (start != null) {
					DirectedEdge e = g.findEdge(start, end);
					edges.add(0, e);
					
					end = start;
					start = end.getPathFromSource();
				}
				map.put(v, edges);
			}
		}
		
		return map;
		
	}
}