from stack import Stack

class SortedStack():
  def __init__(self):    
    self.sorted_stack = Stack()
    self.tmp_stack = Stack()

  def push(self, value):
    if self.sorted_stack.is_empty():
      self.sorted_stack.push(value)
    else:
      while self.sorted_stack.is_empty() is not True and value > self.sorted_stack.peek():
        self.tmp_stack.push(self.sorted_stack.pop())
      self.sorted_stack.push(value)
      while self.tmp_stack.is_empty() is not True:
        self.sorted_stack.push(self.tmp_stack.pop())    
    return self

  def pop(self):
    return self.sorted_stack.pop()

  def peek(self):
    return self.sorted_stack.peek()

  def is_empty(self):
    return self.sorted_stack.is_empty()

  def __str__(self):
    return self.sorted_stack.__str__()

stack = SortedStack()
stack.push(3).push(1).push(5)
print(stack.pop())
print(stack.sorted_stack)
stack.push(19)
print(stack.sorted_stack)