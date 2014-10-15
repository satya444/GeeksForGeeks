package arrays;

import java.util.HashMap;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class EqualZeroOne {

	public void getEqualZeroOne(int a[]) {
		if(a==null || a.length==0){
			System.out.println(a);
			return;
		}
		HashMap<Integer, Integer> indexMap = new HashMap<>();
		int start = -1;
		int end = -1;
		int len = a.length;
		int sum[] = new int[len];
		if (a[0] == 1) {
			sum[0] = 1;
		} else {
			sum[0] = -1;
		}
		for (int i = 1; i < len; i++) {
			if (a[i] == 1) {
				sum[i] = sum[i - 1] + 1;
			} else {
				sum[i] = sum[i - 1] - 1;
			}
		}

		for (int i = 0; i < len; i++) {
			if (sum[i] == 0) {
				start = 0;
				end = i;
				// total size is given by end-start+1;
			} else {
				Integer index = indexMap.get(sum[i]);
				if (index == null) {
					indexMap.put(sum[i], i);
				} else {
					int newSize = i - index;
					int oldSize = end - start + 1;
					if (newSize > oldSize) {
						start = index + 1;
						end = i;
					}
				}
			}
		}
		if (start >= 0) {
			for (int i = start; i <= end; i++) {
				System.out.print(a[i] + " ");
			}
		} else {
			System.out.println("null");
		}
	}

	public static void main(String args[]) {
		EqualZeroOne ezo = new EqualZeroOne();
		int a[] = { 0, 0, 1, 1, 0 };
		ezo.getEqualZeroOne(a);
	}
}
