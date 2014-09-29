package Trees;

import java.util.HashMap;

/**
 * @author Dilip
 * 
 *         github Profile: https://github.com/satya444
 * 
 */
public class SuffixTree {
	// In suffix tree there is no head/root for the tree. For simplicity make
	// ' ' as head of the tree
	Node head = null;

	class Node {
		Character c;
		HashMap<Character, Node> childrenNodes = new HashMap<>();

		Node(Character c) {
			this.c = c;
		}
	}

	/**
	 * This is the subtree of a given tree. It checks if the character at
	 * particular index is already Linked to the parent node then the simply
	 * make that node as next node otherwise create a node and make it next node
	 * 
	 * @param s
	 */
	public void insert(String s) {
		if (head == null) {
			head = new Node(' ');
		}
		Node temp = head;
		for (int i = 0; i < s.length(); i++) {
			Node n = temp.childrenNodes.get(s.charAt(i));
			if (n == null) {
				n = new Node(s.charAt(i));
				temp.childrenNodes.put(s.charAt(i), n);
			}
			temp = n;
		}
	}
/**
 * construct tree for given string
 * @param s
 */
	public void buildTree(String s) {
		for (int i = 0; i < s.length(); i++) {
			insert(s.substring(i));
		}
	}

/**
 * search if the given string is a substring using the suffix tree	
 * @param s
 * @return
 */
	public boolean search(String s) {
		Node temp = head;
		for (int i = 0; i < s.length(); i++) {
			Node childNode = temp.childrenNodes.get(s.charAt(i));
			if (childNode == null) {
				return false;
			}
			temp = childNode;
		}
		return true;
	}

	public static void main(String args[]) {
		SuffixTree st = new SuffixTree();
		st.buildTree("bibs");
		boolean result = st.search("is");
		System.out.println(result);
	}
}
