class Node:
	def __init__(self, value=None, next=None):
		self.value = value
		self.next = next

# node_1 and node_2 are the heads of two separate linked lists
def sum_lists(node_1, node_2):
	carry = 0
	head = tail = None
	while node_1 or node_2:
		sum = carry
		if node_1:
			sum += node_1.value
			node_1 = node_1.next
		if node_2:
			sum += node_2.value
			node_2 = node_2.next

		rem = sum % 10
		carry = sum // 10  # gives how many times 10 fits into sum

		if head:
			tail.next = Node(rem)
			tail = tail.next
		else:
			head = tail = Node(rem)

	if carry: tail.next = Node(carry)

	return head

n6 = Node(1)
n5 = Node(0, n6)
n4 = Node(0, n5)

n2 = Node(9)
n1 = Node(9, n2)

res = []
node = sum_lists(n1, n4)

while node is not None:
  if node.next != None:
    res.append(str(node.value) + ' -> ')
  else:
    res.append(str(node.value))
  node = node.next

print(''.join(res))