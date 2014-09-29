package Trees;

/**
 * @author Dilip
 * 
 *         github Profile: https://github.com/satya444
 * 
 */
/**
 * Check if 2 Nodes are cousins 
 */
public class Cousin {

	class Node {
		Integer data;
		Node left;
		Node right;

		Node(Integer data) {
			this.data = data;
		}

	}

	static Node head = null;
	int level1 = 0;
	int level2 = 0;
	Node parent1;
	Node parent2;

	public void fillLevels(Node n, Node n1, Node n2, int level, Node parent) {
		if (n == null) {
			return;
		}
		if (n.data==n1.data) {
			level1 = level;
			parent1 = parent;
		}
		if (n.data==n2.data) {
			level2 = level;
			parent2 = parent;
		}
		if (level1 != 0 && level2 != 0) {
			return;
		}
		fillLevels(n.left, n1, n2, level + 1, n);
		fillLevels(n.right, n1, n2, level + 1, n);
	}

	/**
	 * 
	 * @param s1- input1
	 * @param s2- input2
	 * @return true if nodes are cousins
	 */
	public boolean areCousins(Integer s1, Integer s2) {
		Node n1= new Node(s1);
		Node n2= new Node(s2);
		fillLevels(head, n1, n2, 0, null);
		if (level1 == level2 && parent1.data != parent2.data) {
			return true;
		}
		return false;
	}
	
	public Node insert(int input[],int start, int end){
		if(start>end){
			return null;
		}
		int mid= (start+end)/2;
		Node currentNode=null;
		currentNode= new Node(input[mid]);
		if(head==null){
			head= currentNode;
		}
		currentNode.left=insert(input,start,mid-1);
		currentNode.right=insert(input, mid+1, end);
		return currentNode;
	}
	public void print(Node n){
		if(n==null){
			return;
		}
		print(n.left);
		System.out.println(n.data);
		print(n.right);
	}
	public static void main(String args[]){
		int input[]={1,2,3,4,5,6,7};
		Cousin c= new Cousin();
		c.insert(input, 0, input.length-1);
		c.print(head);
		boolean check= c.areCousins(5,null);
		System.out.println(check);
	}
}
