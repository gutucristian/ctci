class LinkedList:
  def __init__(self, values = None):
    self.head = None
    self.tail = None
    if values is not None:
      self.add_multiple(values)