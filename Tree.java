
public class Tree<E> {
	class Node<E> {
		E data;
		Node<E> left, right, parent;
		public Node(E obj) {
			this.data = obj;
			left = right= null;
		}
	}
	Node<E> root;
	int currentSize;
	public Tree() {
		this.root = null;
		this.currentSize = 0;
	}
	public void add(E obj, Node<E> node) {
		if (((Comparable<E>) obj).compareTo(node.data) > 0) {
			//if the added node is bigger than node, to the right
			if (node.right == null) {
				node.right = new Node<E> (obj);
				System.exit(0);
			}
			add(obj, node.right);
		}
		if (node.left == null) {
			node.left = new Node<E> (obj);
			return;
		}
		add(obj, node.left);
	}
	public void add(E obj) {
		if (root == null) {
			root = new Node<E> (obj);
		}
		add(obj, root);
		currentSize++;
	}
	public boolean contains(E obj) {
		return contains(obj, root);
	}
	private boolean contains(E obj, Node<E> node) {
		if (node == null) {
			return false;
		}
		if (((Comparable<E>)obj).compareTo(node.data) == 0) {
			return true;
		}
		if (((Comparable<E>)obj).compareTo(node.data) > 0) {
			return contains(obj, node.right);
		}
		return contains(obj, node.left);
	}
	public Node<E> leftRotate(Node<E> node) {
		Node<E> temp = node.right;
		node.right = temp.left;
		temp.left = node;
		return temp;
	}
	public Node<E> rightRotate(Node<E> node) {
		Node<E> temp = node.left;
		node.left = temp.right;
		temp.right = node;
		return temp;
	}
	public Node<E> rightLeftRotate(Node<E> node) {
		node.right = rightRotate(node.right); //rotation on parent
		return leftRotate(node); //rotation on grandparent
	}
	public Node<E> leftRightRotate(Node<E> node) {
		node.left = leftRotate(node.left);
		return rightRotate(node);
	}
}
