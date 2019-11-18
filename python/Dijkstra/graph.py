from min_heap import MinHeap

class Graph:
  def __init__(self, nodes = []) :
    self.nodes = nodes  

  def dijkstra(self, start):
    seen = set()
    heap = MinHeap()

    heap.push(start, start.val)
    seen.add(start)

    while not heap.is_empty():
      top, priority = heap.pop()

      for neighbor, distance in top.neighbors.items():
        tmp_distance = distance + priority
        if tmp_distance < neighbor.val:
          neighbor.prev = top
          neighbor.val = tmp_distance
          if neighbor in seen:
            heap.update_priority(neighbor, neighbor.val)
          else:
            heap.push(neighbor, neighbor.val)