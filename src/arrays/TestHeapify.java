package arrays;


/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class TestHeapify {

	public int[] heapify(int a[], int start, int len){
		if(start>=len){
			return a;
		}
		int left= (2*start)+1;
		int right= (2*start)+2;
		int leftFlag=0;
		int rightFlag=0;
		if(left<len){
			leftFlag=1;
		}
		if(right<len){
			rightFlag=1;
		}
		if(leftFlag==1 && rightFlag==1){
			if(a[start]<a[left] && a[start]<a[right]){
				return a;
			}
			else{
				int min= Math.min(a[left], a[right]);
				int minIndex;
				if(min==a[left]){
					a= swap(a,start,left);
					minIndex=left;
				}
				else{
					a= swap(a,start,right);
					minIndex=right;
				}
				 heapify(a,minIndex,len);
			}
		}
		else if(leftFlag==1){
			if(a[start]<a[left]){
				return a;
			}
			else{
				a= swap(a, start, left);
				return a;
			}
		}
		
		return a;
	}
	
	public int[] buildHeap(int a[]){
		for(int i=(int) Math.floor(a.length/2);i>=0; i--){
			a=heapify(a, i, a.length);
		}
		return a;
	}
	

	/**
	 * @param a
	 * @param start
	 * @param left
	 * @return
	 */
	public int[] swap(int[] a, int start, int index) {
		int temp=a[start];
		a[start]=a[index];
		a[index]=temp;
		return a;
	}
	
	
	public int[] sort(int a[]){
		int b[]= new int[a.length];
		for(int j=0; j<a.length; j++){
			b[j]= a[0];
			a= swap(a, 0,a.length-j-1 );
			a=heapify(a,0,a.length-j-1 );
		}
		return b;
	}
	public static void main(String args[]){
		int a[]={5,4,3,2,1};
		TestHeapify th= new TestHeapify();
		a=th.buildHeap(a);
		a=th.heapify(a, 0, a.length);
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		a=th.sort(a);
		System.out.println();
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
}
