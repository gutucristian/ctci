class Node:
	def __init__(self, value=None, next=None):
		self.value = value
		self.next = next

def is_palindrome(head):
	reversed = reverse_and_clone(head)
	return is_equal(head, reversed)

def reverse_and_clone(node):
	head = None
	while node:
		n = Node(node.value)
		n.next = head
		head = n
		node = node.next
	return head

def is_equal(n1, n2):
	while n1 or n2:
		if n1.value != n2.value:
			return False
		n1 = n1.next
		n2 = n2.next
	return n1 == None and n2 == None

n1_a = Node('a')
n1_b = Node('b')
n1_c = Node('a')

n1_a.next, n1_b.next = n1_b, n1_c

print(is_palindrome(n1_a))