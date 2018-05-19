class Node:
  def __init__(self, value, next=None):
    self.value = value
    self.next = next

class AnimalShelter:
  def __init__(self):
    self.head = self.tail = None

  def enqueue(self, value):
    if self.tail is None:
      self.tail = Node(value)
      self.head = self.tail
    else:
      self.tail.next = Node(value)
      self.tail = self.tail.next
    return self

  def dequeue_any(self):
    v = self.head.value
    self.head = self.head.next
    return v

  def dequeue(self, animal_type):
    current = self.head
    while current and current.value != animal_type:
      current = current.next
    if current and current.next:      
      current.value = current.next.value
      current.next = current.next.next
    elif current:
      current = None
    return self

  def __iter__(self):
    current = self.head
    while current:
      yield current
      current = current.next

  def __str__(self):
    values = [node.value for node in self]
    return ' -> '.join(values)

queue = AnimalShelter()
# queue.enqueue('dog').enqueue('cat').enqueue('dog').enqueue('cat').enqueue('cat')
queue.enqueue('dog').enqueue('dog').enqueue('dog')
print(queue)
queue.dequeue('dog')
print(queue)