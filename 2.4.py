from linked_list import LinkedList

ll = LinkedList([45, 5, 8, 13, 27, 2, 7, 25])
node = ll.add(11)

def partition(ll, ref_node):
  # find ref_node and swap with first node
  for node in ll:
    if node.value == ref_node.value:
      tmp = ll.head.value
      ll.head.value = node.value
      node.value = tmp
      break
  
  runner = ll.head.next
  border = ll.head

  while runner is not None:
    if runner.value < ll.head.value:
      tmp = border.next.value
      border.next.value = runner.value
      runner.value = tmp
      border = border.next    
    runner = runner.next    

  tmp = border.value
  border.value = ll.head.value
  ll.head.value = tmp

  # 8, 5, 2, 13, 27, 45, 25
  # 
  

print(ll)
partition(ll, node)
print(ll)