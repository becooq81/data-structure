public class AVLTree<T> {
	class Node<T> {
		T data;
		Node<T> left, right, parent;
		public Node(T obj) {
			this.data = obj;
			parent = left = right = null;
		}
	}
	Node<T> root;
	int currentSize;
	public AVLTree() {
		this.root = null;
		currentSize = 0;
	}
	public void add(T obj) {
		Node<T> node = new Node<T>(obj);
		if (root == null) {
			this.root = node;
			currentSize++;
		}
		add(root, node);
	}
	public void add(Node<T> parent, Node<T> newNode) {
		// if newly added node is greater than parent
		if (((Comparable<T>) newNode.data).compareTo(parent.data)>0) {
			// if theere is no right child, add as the right child
			// else, call add function on right child
			if (parent.right == null) {
				parent.right = newNode;
				newNode.parent = parent;
				currentSize++;
			} else {
				add(parent.right, newNode);
			}
		}
		// if newly added node is less than parent
		else {
			if (parent.left == null) {
				parent.left = newNode;
				newNode.parent = parent;
				currentSize++;
			} else {
				add(parent.left, newNode);
			}
		}
	checkBalance(newNode);
	}
	/*
	check if qualification of AVLTree is met: balance <= 1
	 */
	public void checkBalance(Node<T> node) {
		if (Math.abs(height(node.left) - height(node.right))>1) {
			rebalance(node);
		}
		if (node.parent == null)
			return;
		checkBalance(node.parent);
	}
	public void rebalance(Node<T> node) {
		if (height(node.left) - height(node.right) > 1)
			if (height(node.left.left) - height(node.left.right) > 1) 
				node = rightRotate(node);
		else 
			if (height(node.right.left) - height(node.right.right) > 1)
				node = leftRotate(node);
			else
				node = rightLeftRotate(node);
		if (node.parent == null) {
			root = node;
		}
			
	}
	public Node<T> leftRotate(Node<T> node) {
		Node<T> temp = node.right;
		node.right = temp.left;
		temp.left = node;
		return temp;
	}
	public Node<T> rightRotate(Node<T> node) {
		Node<T> temp = node.left;
		node.left = temp.right;
		temp.right = node;
		return temp;
	}
	public Node<T> rightLeftRotate(Node<T> node) {
		node.right = rightRotate(node.right); //rotation on parent
		return leftRotate(node); //rotation on grandparent
	}
	public Node<T> leftRightRotate(Node<T> node) {
		node.left = leftRotate(node.left);
		return rightRotate(node);
	}
	public void preorder() {
		preorder(root);
	}
	public void preorder(Node<T> node) {
		if (node == null) 
			return;
		System.out.print(node.data +" ");
		preorder(node.left);
		preorder(node.right);
	}
	public void inorder() {
		inorder(root);
	}
	public void inorder(Node<T> node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	public void postorder() {
		postorder(root);
	}
	public void postorder(Node<T> node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data+" ");
	}
	public boolean isLeaf(Node<T> node) {
		if ((node.left == null) && (node.right == null)) 
			return true;
		return false;
	}
	public int height(Node<T> node) {
		Node<T> temp = node;
		int leftHeight = 0, rightHeight = 0;
		while (temp != null) {
			leftHeight ++;
			temp = temp.left;
		}
		while (node != null) {
			rightHeight ++;
			node = node.right;
		}
		return Math.max(leftHeight, rightHeight);
		
	}
	public Node<T> getRoot() {
		return this.root;
	}
	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(5);
		tree.add(10);
		tree.add(2);
		System.out.println(tree.height(tree.getRoot()));
	}
	
}
