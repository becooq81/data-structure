
public class DoublyLinkedList<E> {
	private Node<E> head, tail=null;
	private int size = 0;
	class Node<E> {
		E data;
		Node<E> next, prev;
		public Node() {
			data = null;
			next = null;
			prev = null;
		}
		public Node(E data) {
			this.data = data;
			next = null;
			prev = null;
		}
		public Node(E data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
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
		public Node<E> getPrev(){
			return this.prev;
		}
	}
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
	public void addLast(E data) {
		if (size==0) {
			addFirst(data);
			return;
		}
		Node<E> node = new Node(data);
		tail.setNext(node);
		node.setPrev(tail);
		tail = node;
		size++;
	}
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		E value = head.getData();
		if (head == tail) {
			head = tail = null;
		}
		head = head.getNext();
		head.setPrev(null);
		size--;
		return value;
	}
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
			result += " <-> "+temp.getData();
			temp = temp.getNext();
		}
		return result;
	}
	public String backwards() {
		Node<E> temp = tail;
		String result = "";
		while (temp != null) {
			result += " <-> "+temp.getData();
			temp = temp.getPrev();
		}
		return result;
	}
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
				temp.getNext().setPrev(prev);
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
	public int getSize() {
		return size;
	}
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.addLast(i);
		}
		System.out.println("[1] "+list);
		System.out.println("size: " + list.getSize());
		System.out.println("[2] "+list.backwards());
		for (int i = 0; i < 10; i += 2) {
			list.remove(i);
		}
		System.out.println("[3] "+list);
		System.out.println("size: " + list.getSize());
		
	}
}
