package arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class KthSmallest {

	class HeapObject {
		public HeapObject(int rowNo, int colNo, int data) {
			super();
			this.rowNo = rowNo;
			this.colNo = colNo;
			this.data = data;
		}

		int rowNo;
		int colNo;
		int data;

	}

	int lastRow;
	int lastCol;

	public HeapObject[] buildHeap(int a[][], int k) {
		HeapObject[] ho;
		int i = 0;
		int j = 0;
		int rows = a.length;
		int cols = a[0].length;
		ho = new HeapObject[k];
		int l = 0;
		while (i < rows) {
			while (j < cols) {
				if (k > 0) {
					ho[l++] = new HeapObject(i, j, a[i][j]);
					k--;
					j++;
				} else {
					break;
				}

			}
			if (k > 0) {
				j = 0;
				i++;
			} else {
				break;
			}
		}

		for (int m = (int) Math.floor(ho.length / 2); m >= 0; m--) {
			ho = heapify(ho, m, ho.length);
		}

		lastRow = i;
		lastCol = j - 1;
		return ho;
	}

	public int getKthSmallest(int a[][], int k) {
		HeapObject[] ho = buildHeap(a, k);
		//printHeap(ho);
		int min = getKElement(a, ho, k, a.length, a[0].length);
		//System.out.println("*************************************");

		return min;
	}

	public void printHeap(HeapObject[] ho) {
		for (int i = 0; i < ho.length; i++) {
			System.out.println(ho[i].data + " ");
		}
	}

	public int getKElement(int a[][], HeapObject[] ho, int k, int rows, int cols) {
		int len = ho.length;
		int min;
	//	int replaceFlag=0;
		int currRow = lastRow;
		int currCol = 0;
		while (true) {
			min = ho[0].data;
			k--;
			if (k == 0) {
				break;
			}
			currRow++;

			while (currRow >= rows) {
				currCol++;
				if (currCol > lastCol)
					currRow = lastRow;
				else
					currRow = lastRow + 1;

			}

			if (currCol < cols && currRow < rows) {
				ho[0] = new HeapObject(currRow, currCol, a[currRow][currCol]);
				ho = heapify(ho, 0, len);
		//		replaceFlag=1;
			}
			else{
			/*	if(replaceFlag==0){
					k++;
				}
			*///	System.out.println("K IS "+k);
				for(int i=0; i<k; i++){
					ho= swap(ho, 0, ho.length-i-1);
					ho= heapify(ho, 0, len-i-1);
			//		System.out.println(i+" "+ho[0].data);
				}
				return ho[0].data;
			}

		}
		return min;
	}

	public HeapObject[] heapify(HeapObject[] ho, int start, int len) {

		if (start >= len) {
			return ho;
		}
		int left = (2 * start) + 1;
		int right = (2 * start) + 2;
		if (left < len && right < len) {
			if (ho[start].data < ho[left].data
					&& ho[start].data < ho[right].data) {
				return ho;
			} else {
				int min = Math.min(ho[left].data, ho[right].data);
				int minIndex;
				if (min == ho[left].data) {
					ho = swap(ho, start, left);
					minIndex = left;
				} else {
					ho = swap(ho, start, right);
					minIndex = right;
				}

				ho = heapify(ho, minIndex, len);
			}
		} else if (left < len) {
			if (ho[start].data < ho[left].data) {
				return ho;
			} else {
				ho = swap(ho, start, left);
				return ho;
			}

		}

		return ho;
	}

	/**
	 * @param ho
	 * @param start
	 * @param left
	 */
	public HeapObject[] swap(HeapObject[] ho, int start, int index) {
		HeapObject temp = ho[start];
		ho[start] = ho[index];
		ho[index] = temp;
		return ho;
	}

	public static void main(String args[]) {
		KthSmallest ks = new KthSmallest();
		int a[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 25, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(ks.getKthSmallest(a, 16));
	}
}
