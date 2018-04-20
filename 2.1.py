class Node:
  def __init__(self, data, next):
    self.data = data
    self.next = next

class LinkedList():
  set = set()

  def __init__(self):
    self.head = None

  def add(self, item):
    tmp = Node(item, self.head)    
    self.head = tmp  

  def print(self):
    cur = self.head
    while cur != None:
      print('{} '.format(cur.data), end='')
      cur = cur.next    

   # O(n) space, O(1) time
  def remove_dups(self):
    cur = self.head
    prev = None
    while cur != None:
      if cur.data in self.set:
        prev.next = cur.next        
      else:
        self.set.add(cur.data)
        prev = cur
      cur = cur.next

    self.existing_nodes = set()
    return self.head

  # O(1) space, O(n^2) time
  def remove_dups_1(self):
    cur = self.head
    runner = None
    prev = None
    while cur != None:
      runner = cur.next
      prev = cur
      while runner != None:
        if runner.data == cur.data:
          prev.next = runner.next
        else:
          prev = runner
        runner = runner.next
      cur = cur.next

    return self.head

  # reverse linked list
  def reverse(self):
    current = self.head
    previous = None

    while current:
      next = current.next
      current.next = previous
      previous = current
      current = next

    self.head = previous
      
lst = LinkedList()

lst.add(8)
lst.add(490)
lst.add(234)

lst.print()
# lst.remove_dups_1()
print()
lst.reverse()
lst.print()