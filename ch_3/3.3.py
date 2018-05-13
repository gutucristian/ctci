from stack import Stack

class SetOfStacks:
  def __init__(self, threshold):
    self.threshold = threshold
    self.stacks = []

  def get_last_stack(self):
    return self.stacks[-1] if len(self.stacks) > 0 else None

  def is_full(self, stack):
    return self.threshold == len(stack)

  def push(self, value):
    last = self.get_last_stack()
    if last is None or self.is_full(last):
      stack = Stack().push(value)
      self.stacks.append(stack)
    else:
      last.push(value)
    return self

  def pop(self):
    last = self.get_last_stack()
    if last is None: raise Exception('Empty stack exception')
    v = last.pop()
    if len(last) == 0: del self.stacks[-1]
    return v

  def pop_at(self, index):
    if index >= len(self.stacks):
      raise Exception('Index out of bound exception')
    cur_stack = self.stacks[index]
    v = cur_stack.pop()
    if cur_stack.is_empty(): 
      del self.stacks[index]
    # add to current stack and remove from next        
    for i in range(index, len(self.stacks) - 1):
      cur_stack, next_stack = self.stacks[i], self.stacks[i+1]
      cur_stack.push(next_stack.pop())      
      if next_stack.is_empty(): del self.stacks[i+1]
    return v

  def __str__(self):
    values = [stack.__str__() for stack in self.stacks]
    return ' | '.join(values)

stack = SetOfStacks(3)
stack.push(3).push(4).push(1)
stack.push(-9).push(3).push(8)
stack.push(2).push(5).push(27)
stack.push(12).push(51).push(87)
print(stack)
stack.pop_at(1)
print(stack)