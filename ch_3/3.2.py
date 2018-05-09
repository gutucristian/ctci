class StackNode:
  def __init__(self, value=None, next=None, min=None):
    self.value = value
    self.next = next
    self.min = min

"""A stack is linear data structure that uses last in first out ordering (LIFO). Unlike arrays,
stacks do not offer constant-time access to the ith item. However, it does allow constant-time adds
and removes, as it does not require shifting elements around. The following is a stack implementation
using linked lists.
"""
class Stack:
  def __init__(self):
    self.top = None
    self.current_minimum = None

  # remove from front
  def pop(self):
    if self.top is None:
      return None
    value = self.top.value
    self.top = self.top.next
    return value

  # add to front
  def push(self, value):           
    if self.current_minimum is None or value < self.current_minimum.value:
      t = StackNode(value, self.top)
      t.min = self
      self.current_minimum = t
    else:  
      t = StackNode(value, self.top, self.current_minimum)    
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
stack.push(0).push(3).push(1).push(9)
print(stack)
print(stack.current_minimum.value)
stack.pop()
stack.pop()
print(stack.current_minimum.value)
print(stack)