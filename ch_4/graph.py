class Vertex:
	def __init__(self, name):
		self.name = name
		self.neighbors = []

	def add_neighbor(self, vertex):
		if vertex not in self.neighbors:
			self.neighbors.append(vertex)
			return self

class Graph:
	def __init__(self):
		self.vertices = {}

	def add_vertex(self, vertex):
		if isinstance(vertex, Vertex) and vertex.name not in self.vertices:
			self.vertices[vertex.name] = vertex
			return vertex
		return None
	
	def add_edge(self, v1, v2):
		if v1 in self.vertices and v2 in self.vertices:
			self.vertices[v1.name].add_neighbor(v2)
			self.vertices[v2.name].add_neighbor(v1)
			return True
		return False

	def __str__(self):
		graph = []
		for (name, vertex) in self.vertices.items():
			neighbors = ', '.join([str(vertex.name) for vertex in vertex.neighbors])
			graph.append(str(name) + ': ' + neighbors)
		return ' | '.join(graph)

graph = Graph()
v0 = Vertex(0)
v1 = Vertex(1)
v2 = Vertex(2)
v3 = Vertex(3)
graph.add_vertex(v0).add_neighbor(v1)
graph.add_vertex(v1).add_neighbor(v2)
graph.add_vertex(v2).add_neighbor(v0).add_neighbor(v3)
graph.add_vertex(v3).add_neighbor(v2)
print(graph)