class Node:
  def __init__(self, name, val):    
    self.val = float('inf')
    self.neighbors = {}
    self.prev = None
    self.name = name