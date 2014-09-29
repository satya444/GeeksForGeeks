package Trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dilip
 * 
 *         github Profile: https://github.com/satya444
 * 
 */
//****INCOMPLETE SOLUTION >> NEED TO IMPLEMENT IN GREEDY FASHION
public class IterationCount {
	HashMap<String, Node> allNodes = new HashMap<>();

	Node head;

	class Node {
		String data;
		List<Node> children = new LinkedList<>();

		Node(String data) {
			this.data = data;
		}

	}

	public void insert(String input, List<String> children) {
		Node currentNode = null;

		if (!allNodes.containsKey(input)) {
			currentNode = new Node(input);
			allNodes.put(input, currentNode);
		} else {
			currentNode = allNodes.get(input);
		}
		if (head == null) {
			head = currentNode;
		}
		Iterator<String> itr = children.iterator();
		List<Node> childNodes = new LinkedList<>();
		Node temp = null;
		while (itr.hasNext()) {
			String data = itr.next();
			temp = allNodes.get(data);
			if (temp == null) {
				temp = new Node(data);
				allNodes.put(data, temp);
			}
			childNodes.add(temp);
		}
		currentNode.children.addAll(childNodes);
	}

	public void printTree(int height) {
		Queue<Node> levelPrint = new LinkedList<>();
		levelPrint.add(head);
		Node marker = new Node("");
		levelPrint.add(marker);
		while (!levelPrint.isEmpty()) {
			Node n = levelPrint.poll();
			if (n.data.equals("") && height > 0) {
				height = height - 1;
				levelPrint.add(marker);
				System.out.println();
			} else {
				System.out.print(n.data + " ");
				Iterator<Node> itr = n.children.iterator();
				while (itr.hasNext()) {
					levelPrint.add(itr.next());
				}
			}
		}
	}
	int maxIterations=0;
	HashMap<Node, Integer> countItr= new HashMap<>();
	public int getIterationCount(){
		
		return 0;
	}
	
	
	public static void main(String args[]) {
		IterationCount ic = new IterationCount();
		List<String> children = new LinkedList<>();
		String input[] = { "b", "c", "d", "e", "f", "g" };
		for (int i = 0; i < input.length; i++) {
			children.add(input[i]);
		}
		ic.insert("a", children);
		children.clear();
		String input1[] = { "h", "i", "j" };

		for (int i = 0; i < input1.length; i++) {
			children.add(input1[i]);
		}
		ic.insert("b", children);
		children.clear();
		String input2[] = { "k", "l" };
		for (int i = 0; i < input2.length; i++) {
			children.add(input2[i]);
		}
		ic.insert("e", children);
		children.clear();
		String input3[] = { "m" };
		for (int i = 0; i < input3.length; i++) {
			children.add(input3[i]);
		}
		ic.insert("g", children);
		children.clear();
		String input4[] = { "n", "o" };
		for (int i = 0; i < input4.length; i++) {
			children.add(input4[i]);
		}
		ic.insert("h", children);
		children.clear();
		String input5[] = { "p" };
		for (int i = 0; i < input5.length; i++) {
			children.add(input5[i]);
		}
		ic.insert("k", children);
		children.clear();
		String input6[] = { "q" };
		for (int i = 0; i < input6.length; i++) {
			children.add(input6[i]);
		}
		ic.insert("l", children);
		ic.printTree(3);
		for (int i = 0; i < input1.length; i++) {
			children.add(input1[i]);
		}
	}
}
