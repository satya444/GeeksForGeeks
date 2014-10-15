package arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class MedianDataStream {

	public double getMedian(int a[]) {
		int len = a.length;
		int[] maxHeap;
		int[] minHeap;
		int maxHeapLen = 0;
		int minHeapLen = 0;
		if (len % 2 == 0) {
			maxHeap = new int[len / 2];
			minHeap = new int[len / 2];
		} else {
			maxHeap = new int[len / 2 +1];
			minHeap = new int[len / 2 + 1];
		}

		maxHeap[0] = a[0];
		maxHeapLen = 1;
		for (int i = 1; i < len; i++) {
			if (a[i] < maxHeap[0]) {
				if (maxHeapLen + 1 - minHeapLen > 1) {
					int temp = maxHeap[0];
					maxHeap[0] = a[i];
					minHeap[minHeapLen++] = temp;
					minHeap = buildMinHeap(minHeap, minHeapLen);
				} else {
					maxHeap[maxHeapLen++] = a[i];
				}
				maxHeap = buildMaxHeap(maxHeap, maxHeapLen);
			} else {
				if (minHeapLen + 1 - maxHeapLen > 1) {
					int temp = minHeap[0];
					minHeap[0] = a[i];
					maxHeap[maxHeapLen++] = temp;
					maxHeap = buildMaxHeap(maxHeap, maxHeapLen);
				} else {
					minHeap[minHeapLen++] = a[i];
				}
				minHeap = buildMinHeap(minHeap, minHeapLen);
			}
		}
		if (len % 2 == 0) {
			System.out.println(maxHeap[0]+" "+minHeap[0]);
			return (double)(maxHeap[0] + minHeap[0]) / 2;

		}
		if (maxHeapLen > minHeapLen) {
			return maxHeap[0];
		} else {
			return minHeap[0];
		}
	}

	public int[] buildMinHeap(int a[], int len) {
		for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
			a = minheapify(a, i, len);
		}
		return a;
	}

	public int[] buildMaxHeap(int a[], int len) {
		for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
			a = maxheapify(a, i, len);
		}
		return a;
	}

	public int[] minheapify(int a[], int start, int len) {
		if (start >= len) {
			return a;
		}
		int left = (2 * start) + 1;
		int right = (2 * start) + 2;

		if (left < len && right < len) {
			if (a[start] < a[left] && a[start] < a[right]) {
				return a;
			} else {
				int min = Math.min(a[left], a[right]);
				int minIndex;
				if (min == a[left]) {
					a = swap(a, start, left);
					minIndex = left;
				} else {
					a = swap(a, start, right);
					minIndex = right;
				}
				a = minheapify(a, minIndex, len);
			}
		} else if (left < len) {
			if (a[start] < a[left]) {
				return a;
			} else {
				a = swap(a, start, left);
				return a;
			}
		}

		return a;
	}

	public int[] maxheapify(int a[], int start, int len) {
		if (start >= len) {
			return a;
		}
		int left = (2 * start) + 1;
		int right = (2 * start) + 2;

		if (left < len && right < len) {
			if (a[start] > a[left] && a[start] > a[right]) {
				return a;
			} else {
				int max = Math.max(a[left], a[right]);
				int maxIndex;
				if (max == a[left]) {
					a = swap(a, start, left);
					maxIndex = left;
				} else {
					a = swap(a, start, right);
					maxIndex = right;
				}
				a = maxheapify(a, maxIndex, len);
			}
		} else if (left < len) {
			if (a[start] > a[left]) {
				return a;
			} else {
				a = swap(a, start, left);
				return a;
			}
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
		int temp = a[start];
		a[start] = a[index];
		a[index] = temp;
		return a;
	}
	
	public static void main(String args[]){
		int a[]= {5, 15, 1, 3, 2, 8,6,  7,9, 10,  11, 4};
		MedianDataStream mds= new MedianDataStream();
		System.out.println(mds.getMedian(a));
	}
}
