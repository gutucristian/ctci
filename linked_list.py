class Node():
  def __init__(self, value, next = None, previous = None):
    self.value = value
    self.next = next
    self.previous = previous

class LinkedList:
  def __init__(self, values = None):
    self.head = None
    self.tail = None
    if values is not None:
      self.add_multiple(values)

  def __iter__(self):
    current = self.head
    while current:
      yield current
      current = current.next

  def __str__(self):
    values = [str(x) for x in self]
    return ' -> '.join(values)

  def __len__(self):
    length = 0
    current = self.head    
    while current:
      length += 1
      current = current.next
    return length

  # add to end
  def add(self, value):
    if self.head is None:
      self.tail = self.head = Node(value)
    else:
      self.tail.next = Node(value)
      self.tail = self.tail.next
    return self.tail    