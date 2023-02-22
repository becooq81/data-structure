import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> {
	private Node<E> head, tail=null; // having tail pointer can potentially improve efficiency
	private int size = 0;

	// node inner class
	class Node<E> {
		E data;
		Node<E> next;
		public Node() {
			data = null;
			next = null;
		}
		public Node(E data) {
			this.data = data;
			next = null;
		}
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public void setData(E data) {
			this.data = data;
		}
		public E getData() {
			return this.data;
		}
		public Node<E> getNext(){
			return this.next;
		}
	}

	/*
	Iterator helper class
	 */
	class IteratorHelper implements Iterator<E> {

		Node<E> index;

		public IteratorHelper() {
			index = head;
		}
		@Override
		public boolean hasNext() {
			return (index != null);
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E val = index.data;
			index = index.next;
			return val;
		}
	}

	/*
	add node at head
	- no boundary conditions
	 */
	public void addFirst(E data) {
		Node<E> node = new Node(data);
		if (size == 0) {
			head = tail = node;
			size++;
			return;
		}
		node.setNext(head);
		head = node;
		size++;
	}

	/*
	add node at tail
	- if the linked list is empty, adding node at tail is the same as adding node at head
	 */
	public void addLast(E data) {
		if (size==0) {
			addFirst(data);
			return;
		}
		Node<E> node = new Node(data);
		tail.setNext(node);
		tail = node;
		size++;
	}

	/*
	remove node at head
	- if the linked list is empty, error
	- if the linked list has one node, linked list becomes empty
	 */
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		E value = head.getData();
		if (head == tail) {
			head = tail = null;
			return value;
		}
		head = head.getNext();
		size--;
		return value;
	}

	/*
	remove node at tail
	- if the linked list is empty, error
	- if the linked list has one node, linked list becomes empty
	- else-wise, find the tail and its previous node and set the tail's previous nodes' next pointer to null
	 */
	public E removeLast() {
		if (size == 0) {
			return null;
		}
		E value = tail.getData();
		if (head == tail) {
			head = tail = null;
			return value;
		}
		Node<E> temp = head, prev = null;
		while (temp != tail) {
			prev = temp;
			temp = temp.getNext();
		}
		prev.setNext(null);
		tail = prev;
		size--;
		return value;
	}

	/*
	search data
	- cast data to compare the data to the nodes' data
	 */
	public boolean contains(E data) {
		Node<E> temp = head;
		while (temp != null) {
			if (((Comparable<E>)data).compareTo(temp.getData())==0) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	public String toString() {
		Node<E> temp = head;
		String result = "";
		while (temp != null) {
			result += " -> "+temp.getData();
			temp = temp.getNext();
			
		}
		return result;
	}

	/*
	search and remove data
	 */
	public E remove(E data) {
		Node<E> temp = head, prev = null;
		while (temp != null) {
			if (((Comparable<E>)data).compareTo(temp.getData())==0) {
				if (temp == head) {
					return removeFirst();
				}
				if (temp == tail) {
					return removeLast();
				}
				prev.setNext(temp.getNext());
				size--;
				return temp.getData();
			}
			prev = temp;
			temp = temp.getNext();
		}
		return null;
	}
	public E peekFirst() {
		if (head == null) {
			return null;
		}
		return head.getData();
	}
	public E peekLast() {
		if (tail == null) {
			return null;
		}
		return tail.getData();
	}

	/*
	Iterator
	 */
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.addFirst(i);
		}
		System.out.println("[1] "+list);
		for (int i = 0; i < 10; i += 2) {
			list.remove(i);
		}
		System.out.println("[2] "+list);
	}
}
