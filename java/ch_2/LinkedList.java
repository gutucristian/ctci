class LinkedList {
	private Node head;
	private int size;

	static class Node {
		public int data;
		public Node next;
		
		Node (int d) {
			data = d;
			next = null;
		}
	}

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	public Node delete(int index) {
		System.out.println("index = " + index);
		System.out.println("size = " + this.size);
		if (index > this.size || index <= 0) {
			throw new IndexOutOfBoundsException("index out of range");
		}
		Node prev = null;
		Node cur = this.head;
		int count = 1;
		while (cur != null) {
			this.size--;
			if (index == count) {
				if (prev == null) {
					this.head = cur.next;
				} else {
					prev.next = cur.next;
				}
				break;
			}
			count++;
			prev = cur;
			cur = cur.next;
		}
		return cur;
	}

	// Append the specified element to end of list
	public Node add(int data) {
		Node n = new Node(data);
		if (this.head == null) {
			this.head = n;
		} else {
			Node last = this.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = n;
		}
		this.size++;
		return n;
	}

	public boolean add(int index, int data) {
		if (index > this.size || index <= 0) {
			throw new IndexOutOfBoundsException("index out of range");
		}
			
		int count = 1;
	  Node prev = null;
    Node cur = this.head;
	  Node n = new Node(data);
	  while (cur != null) {
	  	if (count == index) {
				this.size++;

				if (prev == null) {
					return addFirst(data);
				}
	  		prev.next = n;
	  		n.next = cur;
	  		return true;
	  	}
	  	prev = cur;
	  	cur = cur.next;
	  	count++;
	  }
		
		return false;
	}

	public boolean addFirst(int data) {
		Node n = new Node(data);
		if (this.head != null) {
			n.next = this.head;
		}
		this.head = n;
		this.size++;
		return true;
	}

	public void addLast(int data) {
		Node n = new Node(data);
		if (this.head == null) {
			this.head = n;
		} else {
			Node tmp = this.head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = n;
		}
		this.size++;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		Node cur = this.head;
		while (cur != null) {
			if (cur.next == null) {
				str.append(cur.data);
			} else {
				str.append(cur.data);
				str.append(" -> ");
			}
			cur = cur.next;
		}
		return str.toString();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(4);
		list.add(6);
		list.add(1);
		list.addLast(89);
		list.addFirst(11);
		list.delete(5);
		System.out.println(list);
	}
}
