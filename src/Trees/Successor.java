package Trees;


/**
 * @author Dilip
 * 
 *         github Profile: https://github.com/satya444
 * 
 */
public class Successor {

	class Node {
		int data;
		Node left;
		Node right;
		Node parent;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head = null;

	public Node findSuccessor(Node n, int data) {
		if (n == null) {
			return null;
		}
		if (n.data == data) {
			Node successor = getSuccessor(n);
			return successor;
		}
		Node lSucc = findSuccessor(n.left, data);
		if (lSucc != null) {
			return lSucc;
		}
		Node rSucc = findSuccessor(n.right, data);
		if (rSucc != null) {
			return rSucc;
		}
		return null;
	}

	/**
	 * @param n
	 * @return
	 */
	public Node getSuccessor(Node n) {
		if (n.right != null) {
			n = n.right;
			while (n.left != null) {
				n = n.left;
			}
			return n;
		} else {
			Node parent = n.parent;
			while (parent.left != n) {
				n = parent;
				if (n.parent != null)
					parent = n.parent;
				else
					return null;
			}
			return parent;
		}
	}
	public Node insert(int input[], int start, int end,Node parent) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node currentNode = null;
		currentNode = new Node(input[mid]);
		currentNode.parent=parent;
		if (head == null) {
			head = currentNode;
		}
		currentNode.left = insert(input, start, mid - 1, currentNode);
		currentNode.right = insert(input, mid + 1, end,currentNode);
		return currentNode;
	}
	public static void main(String args[]){
		Successor s= new Successor();
		int[] input= {1,2,3,4,5,6,7};
		s.insert(input, 0, input.length-1, null);
		Node n=s.findSuccessor(head, 1);
		if(n==null){
			System.out.println(n);
			return;
		}
		System.out.println(n.data);
	}
}
