package Trees;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author Dilip
 * 
 *         github Profile: https://github.com/satya444
 * 
 */
//****INCOMPLETE SOLUTION >> NEED TO IMPLEMENT IN GREEDY FASHION
public class IterationCount {
	HashMap<String, Node> allNodes = new HashMap<>();

	static Node head;

	class Node implements Comparable<Node>{
		String data;
		List<Node> children = new LinkedList<>();
		TreeSet<Node> child= new TreeSet<>();
		int iterationCount;
		Node(String data) {
			this.data = data;
		}
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Node o) {
			Node tempNode= o;
			return Integer.compare(iterationCount, tempNode.iterationCount);
			// TODO Auto-generated method stub
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
		currentNode.child.addAll(childNodes);
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
	HashMap<Node, Integer> countItr= new HashMap<>();
	
	public static void setInput(){
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
		int iterations=ic.getIterationCount(head);
		System.out.println(iterations);
	}
	public Integer getIterationCount(Node n){
		
		List<Node> children= n.children;
		Iterator<Node> itr= children.iterator();
		int max=0;
		int tempMax=0;
		///SHOULD SORT THE CHILDREN BEFORE DOING THIS
		for(int i=0; i<children.size(); i++){
			 tempMax= 1+i+ getIterationCount(itr.next());
			 if(tempMax>max){
				 max=tempMax;
			 }
		}
		
		n.iterationCount=max;
		return max;
	}
	
	public static void main(String args[]) {
		setInput();
		
	}
}
