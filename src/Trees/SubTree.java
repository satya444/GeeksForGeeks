package Trees;

/**
 * @author Dilip
 * 
 *         github Profile: https://github.com/satya444
 * 
 */
public class SubTree {

	private Node inOrder[];
	private Node preOrder[];

	class Node {
		Integer data;
		Node left;
		Node right;

		Node(Integer data) {
			this.data = data;
		}

	}

	Node head = null;

	public Node getHead() {
		return head;
	}

	public Node insert(int input[], int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node currentNode = null;
		currentNode = new Node(input[mid]);
		if (head == null) {
			head = currentNode;
		}
		currentNode.left = insert(input, start, mid - 1);
		currentNode.right = insert(input, mid + 1, end);
		return currentNode;
	}

	public void print(Node n) {
		if (n == null) {
			return;
		}
		print(n.left);
		System.out.println(n.data);
		print(n.right);
	}

	public void initialize(int size) {
		inOrder = new Node[size];
		preOrder = new Node[size];
	}

	int inpos = 0;
	int prepos = 0;

	public Node[] getInorder() {
		return inOrder;
	}

	public Node[] getPreorder() {
		return preOrder;
	}

	public void fillInorder(Node n) {
		if (n == null) {
			return;
		}
		fillInorder(n.left);
		inOrder[inpos++] = n;
		fillInorder(n.right);
	}

	public void fillPreorder(Node n) {
		if (n == null) {
			return;
		}
		preOrder[prepos++] = n;
		fillPreorder(n.left);
		fillPreorder(n.right);
	}

	public boolean isSubstring(Node[] input1, Node[] input2) {
		StringBuffer str1 = new StringBuffer("");
		StringBuffer str2 = new StringBuffer("");
		for (int i = 0; i < input1.length; i++) {
			str1.append(String.valueOf(input1[i].data));
		}
		for (int i = 0; i < input2.length; i++) {
			str2.append(String.valueOf(input2[i].data));
		}

		/**
		 * SuffixTree class in other file
		 */
		SuffixTree st = new SuffixTree();
		st.buildTree(str1.toString());
		return st.search(str2.toString());

	}

	public void print(Node[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i].data);
		}
		System.out.println();
	}
	public static boolean isSubTree(int[] input1, int[] input2){
		SubTree st = new SubTree();
		st.insert(input1, 0, input1.length - 1);
		st.initialize(input1.length);
		st.fillInorder(st.head);
		st.fillPreorder(st.head);
		Node[] in1 = st.getInorder();
		Node[] pre1 = st.getPreorder();
		SubTree st1 = new SubTree();
		st1.initialize(input2.length);
		st1.insert(input2, 0, input2.length - 1);
		st1.fillInorder(st1.head);
		st1.fillPreorder(st1.head);
		Node[] in2 = st1.getInorder();
		Node[] pre2 = st1.getPreorder();
		st.print(in1);
		st.print(pre1);
		st1.print(in2);
		st1.print(pre2);
		boolean inCheck = st.isSubstring(in1, in2);
		boolean preCheck = st.isSubstring(pre1, pre2);
		return (inCheck && preCheck);
	}

	public static void main(String args[]) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7 };
		int[] input1 = { 1, 2, 3 };
		System.out.println(isSubTree(input, input1));
	

	}

}
