class Node:
	def __init__(self, value=None, next=None):
		self.value = value
		self.next = next

# node_1 and node_2 are the heads of two separate linked lists
def sum_lists(node_1, node_2):
	num_1 = ll_to_num(node_1)
	num_2 = ll_to_num(node_2)
	sum = num_1 + num_2
	sum_str = str(sum)
	head = None
	for char in sum_str:
		head = Node(char, head)
	return head

def ll_to_num(node):
	res = []
	while node != None:
		res.append(str(node.value))
		node = node.next
	res.reverse() # reverses list in place (res[::-1] uses extra space)
	return int(''.join(res))

n6 = Node(1)
n5 = Node(3, n6)
n4 = Node(2, n5)

n3 = Node(8)
n2 = Node(3, n3)
n1 = Node(4, n2)

res = []
node = sum_lists(n1, n4)

while node is not None:
  if node.next != None:
    res.append(str(node.value) + ' -> ')
  else:
    res.append(str(node.value))
  node = node.next

print(''.join(res))