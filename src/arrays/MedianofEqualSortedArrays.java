package arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class MedianofEqualSortedArrays {

	public double getCombinedMedian(int a[], int b[], int start1, int end1,
			int start2, int end2) {

		if (end1 == start1 && end2 == start2) {
			return (a[start1] + b[start2]) / 2;
		}
		if (((end1 - start1) == 1) && ((end2 - start2) == 1)) {
			return (Math.max(a[start1], b[start2]) + Math.min(a[end1], b[end2])) / 2;
		}
		double median1 = getMedian(a, start1, end1);
		double median2 = getMedian(b, start2, end2);

		int mid1 = (start1 + end1) / 2;
		int mid2 = (start2 + end2) / 2;
		if (median1 > median2) {
			if ((double) a[mid1] == median1)
				return getCombinedMedian(a, b, start1, mid1, mid2, end2);
			else
				return getCombinedMedian(a, b, start1, mid1 , mid2 + 1, end2);
		} else if (median1 < median2) {
			if ((double) a[mid1] == median1)
				return getCombinedMedian(a, b, mid1, end1, start2, mid2);
			else
				return getCombinedMedian(a, b, mid1 + 1, end1, start2, mid2 );
		}
		else{
			return a[mid1];
		}

	}

	public double getMedian(int a[], int start, int end) {
		int len = end - start + 1;
		int mid = (start + end) / 2;
		if (len % 2 == 0) {
			return (double) (a[mid] + a[mid + 1]) / 2;
		} else {
			return a[mid];
		}
	}

	public static void main(String args[]) {
		MedianofEqualSortedArrays mes = new MedianofEqualSortedArrays();
		int a[]   = {1, 12, 15, 26, 38};
		  int b[] = {2, 13, 17, 30, 45};
		System.out.println(mes
				.getCombinedMedian(a, b, 0, a.length - 1, 0, b.length - 1));
	}
}
 