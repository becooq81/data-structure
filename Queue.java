public class Queue<E> {
	private Node<E> head, tail=null;
	private int size = 0;
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
	public void add(E data) {
		Node<E> node = new Node(data);
		if (size == 0) {
			head = tail = node;
			size++;
			return;
		}
		tail.setNext(node);
		tail = node;
		size++;
	}
	public E remove() {
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
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		E value = head.getData();
		if (head == tail) {
			head = tail = null;
		}
		head = head.getNext();
		size--;
		return value;
	}
	public E remove(E data) {
		Node<E> temp = head, prev = null;
		while (temp != null) {
			if (((Comparable<E>)data).compareTo(temp.getData())==0) {
				if (temp == head) {
					return removeFirst();
				}
				if (temp == tail) {
					return remove();
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
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.add(i);
			System.out.println(queue);
		}
		for (int i = 0; i < 10; i ++) {
			queue.remove();
			System.out.println(queue);
		}
	}
}
