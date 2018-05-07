class StackNode:
  def __init__(self, value=None, next=None):
    self.value = value
    self.next = next

# stack implementation using linked list
class Stack:
  def __init__(self):
    self.top = None

  def pop(self):
    if self.top is None:
      return None
    value = self.top.value
    self.top = self.top.next
    return value

  def push(self, value):
    t = StackNode(value, self.top)    
    self.top = t
    return self # return reference object reference to enable chaining
  
  def peek(self):
    return self.top.value if self.top else None

  def is_empty(self):
    return self.top is None

  def __iter__(self):
    current = self.top
    while current:
      yield current
      current = current.next

  def __str__(self):
    values = [str(node.value) for node in self]
    return ' -> '.join(values)  

stack = Stack()
stack.push('a').push('b').push('c')
print(stack)
stack.pop()
print(stack)