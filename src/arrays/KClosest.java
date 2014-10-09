package arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class KClosest {

	int initializeFlag = 0;
	int[] b;
	int len;

	public int[] getKclose(int a[], int start, int end, int k, int n) {

		int i = 0;
		if (initializeFlag == 0) {
			len = a.length;
			b = new int[k];
			initializeFlag = 1;
		}
		int beginIndex = binarySearch(a, start, end, n);
		int leftPointer = beginIndex;
		int rightPointer = beginIndex;
		if (a[beginIndex] != n) {
			b[i] = a[beginIndex];
			k--;
			i++;
		}
		int leftTemp;
		int righttTemp;
		while (k > 0) {
			if (leftPointer <= 0) {
				b[i] = a[rightPointer + 1];
				rightPointer++;
				k--;
				i++;
				continue;
			} else if (rightPointer > a.length - 1) {
				b[i] = a[leftPointer - 1];
				leftPointer--;
				k--;
				i++;
				continue;
			} else {
				leftTemp = a[leftPointer - 1];
				righttTemp = a[rightPointer + 1];
				int minIndex = Math.abs(leftTemp-n) < Math.abs(righttTemp-n) ? leftPointer-1
						: rightPointer+1;
				if (minIndex == leftPointer-1) {
					leftPointer--;
				} else {
					rightPointer++;
					;
				}
				b[i] = a[minIndex];
				i++;
				k--;
			}
		}
		return b;
	}

	/**
	 * @param a
	 * @param start
	 * @param end
	 * @param n
	 * @return
	 */
	public int binarySearch(int[] a, int start, int end, int n) {
		if(start>a.length-1){
			return a.length-1;
		}
		if(end<0){
			return 0;
		}
		if (start > end) {
			int diff1 = a[start] - n;
			int diff2 = a[end] - n;
			return Math.abs(diff1) > Math.abs(diff2) ? start : end;
		}
		int mid = (start + end) / 2;
		if (a[mid] == n) {
			return mid;
		} else if (a[mid] < n) {
			return binarySearch(a, mid + 1, end, n);
		} else {
			return binarySearch(a, start, mid - 1, n);
		}
	}

	public static void main(String args[]) {
		KClosest kc = new KClosest();
		int a[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int b[] = kc.getKclose(a, 0, a.length - 1, 5, 11);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
