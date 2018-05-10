# 'import stack' will import entire stack.py module which also contains StackNode
from stack import Stack
from sys import maxsize

class NodeWithMin:
  def __init__(self, value=None, next=None, min=None):
    self.value = value
    self.next = next
    self.min = min

class StackWithMin(Stack):
  def min(self):
    if self.is_empty():
      return maxsize # error value
    return self.peek(return_item=True)

  def push(self, value):
    top = self.peek(return_item=True)
    new_min = min(value, top.min) if top else value
    super(StackWithMin, self).push(custom_node=NodeWithMin(value, self.top, new_min))
    return self

stack = StackWithMin()
stack.push(4).push(2).push(1).push(9)
print(stack)
print(stack.peek(return_item=True).min)
stack.pop()
print(stack)
stack.pop()
print(stack)
print(stack.peek(return_item=True).min)
print(stack)