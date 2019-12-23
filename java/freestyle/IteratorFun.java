import java.util.Iterator;

class Main { 
  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.add(4);
    ll.add(9);
    ll.add(3);
    for (Integer num: ll) {
      System.out.print(num + ", ");
    }
   }
}

class Node<T> {
  public T data;
  public Node<T> next;
  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList<T> implements Iterable<T> {
  Node<T> head, tail;

  public void add(T data) {
    Node<T> node = new Node<>(data);
    if (head == null) {
      head = tail = node;
    } else {
      node.next = head;
      head = node;
    }
  }

  public Iterator<T> iterator() {
    return new ListIterator<T>(this);
  }
}

class ListIterator<T> implements Iterator<T> {
  Node<T> current;

  public ListIterator(LinkedList<T> linkedList) {
    current = linkedList.head;
  }

  public boolean hasNext() {
    return true ? current != null : false;
  }

  public T next() {
    T data = current.data;
    current = current.next;
    return data;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}
