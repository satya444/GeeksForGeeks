package Trees;


/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class MaxPathSum {
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

	int flag=0;
	int flag1=0;
	int flag2=0;
	public int getSum(Node n, int d1, int d2){
		if(n==null){
			return 0;
		}
		int leftSum= getSum(n.left,d1,d2);
		int rightSum= getSum(n.right,d1,d2);
		if(n.data==d1){
			flag1=1;
			if(flag1==1 && flag2==1){
				flag=1;
			}
			return n.data+leftSum+rightSum;
		}
		if(n.data==d2){
			flag2=1;
			if(flag1==1 && flag2==1){
				flag=1;
			}
			return n.data+leftSum+rightSum;
		}
		if(flag==1){
			if(leftSum!=0){
				return leftSum;
			}
			if(rightSum!=0){
				return rightSum;
			}
		}
		
		if(leftSum!=0 && rightSum!=0){
			flag=1;
			return n.data+leftSum+rightSum;
		}
		
		else if(leftSum==0 && rightSum!=0){
			return n.data+rightSum;
		}
		else if(leftSum!=0 && rightSum==0){
			return n.data+leftSum;
		}
		return 0;
	}
	public static void main(String args[]){
		int[] input={1,2,3,4,5,6,7};
		MaxPathSum mps= new MaxPathSum();
		mps.insert(input, 0, input.length-1);
		int sum=mps.getSum(head, 6, 7);
		System.out.println(sum);
	}
}
