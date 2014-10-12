package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class SubArraySumZero {

	public int[] getSubArray(int a[]) {
		HashMap<Integer, Integer> sumIndex = new HashMap<>();
		int sum = 0;
		int changeFlag = 0;
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			Integer val = sumIndex.get(sum);
			if (val != null) {
				startIndex = sumIndex.get(sum) + 1;
				endIndex = i;
				changeFlag = 1;
			} else if (a[i] == 0) {
				startIndex = i;
				endIndex = i;
				changeFlag = 1;
			} else {
				sumIndex.put(sum, i);
			}
		}
		if (changeFlag == 1)
			return Arrays.copyOfRange(a, startIndex, endIndex + 1);
		return null;
	}

	public static void main(String args[]) {
		int a[] = { -3, 2, 3, 1, 6 };
		SubArraySumZero sas = new SubArraySumZero();
		a = sas.getSubArray(a);
		if (a != null) {
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
		} else {
			System.out.println(a);
		}
	}
}
