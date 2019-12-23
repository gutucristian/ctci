import java.util.Iterator;

class Node<T> {
  public Node next;
  public Node prev;
  public T data;

  public Node(T data) {
    this.data = data;
  }
}

class CustomList<T> implements Iterable<Node> {
  private T first;
  private T last;

  public CustomList() {
    first = last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void push(T data) {
    Node tmp = new Node(data);

    if (first == null) {
      first = last = tmp;
    } else {
      tmp.next = first;
      first = tmp;
    }
  }

  public Iterator<T> iterator() {
    return new ListIterator(first);
  }
}

class ListIterator implements Iterator<E> {
  private Node current;

  public ListIterator(Node first) {
    current = first;
  }

  public boolean hasNext() {
    return current != null;
  }

  public E next() {
    Node temp = current;
    current = current.next;
    return temp.data;
  }
}

class Main {
  public static void main(String[] args) {
    CustomList<Node> list = new CustomList<Node>();
    list.push(new Node(2));
    list.push(new Node(1));
    list.push(new Node(5));
    for (Node x: list) {
      System.out.println(x);
    }
  }
}