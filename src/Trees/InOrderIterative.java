package Trees;

import java.util.Stack;

/**
 * @author Dilip
 * 
 *         github Profile: https://github.com/satya444
 * 
 */
public class InOrderIterative {
	class Node {
		Integer data;
		Node left;
		Node right;

		Node(Integer data) {
			this.data = data;
		}

	}

	static Node head = null;

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

	public void printInorder() {
		Stack<Node> s = new Stack<>();
		Node temp = head;
		s.push(temp);
		temp = temp.left;
		while (!s.isEmpty()) {
			while (temp != null) {
				s.push(temp);
				temp = temp.left;
			}
			Node pNode = s.pop();
			System.out.println(pNode.data);
			temp = pNode.right;
			if (temp != null) {
				s.push(temp);
				temp = temp.left;
			}

		}
	}

	public static void main(String args[]) {
		InOrderIterative ioi = new InOrderIterative();
		int[] input = { 1, 2, 3, 4, 5, 6, 7 };
		ioi.insert(input, 0, input.length - 1);
		ioi.printInorder();
	}
}
