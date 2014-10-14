package arrays;

import java.util.Arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class PossibleTriangles {

	public int getTriangles(int a[]) {
		Arrays.sort(a);
		int len = a.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int k = j + 1;
				while (k < len) {
					if (a[i] + a[j] > a[k]) {
						count++;
						k++;
					}
					else{
						break;
					}
				}
				if (j < len) {
					continue;
				}

			}
		}
		return count;
	}

	public static void main(String args[]) {
		PossibleTriangles pt = new PossibleTriangles();
		int[] a = { 10, 21, 22, 100, 101, 200, 300};
		System.out.println(pt.getTriangles(a));
	}
}
