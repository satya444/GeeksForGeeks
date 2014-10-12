package arrays;

import java.util.Arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class RemoveMinElements {

	public int[] removeMinElements(int a[]) {
		Arrays.sort(a);
		int startIndex = 0;
		int endIndex = 0;
		int flag = 0;
		for (int i = 0; i < a.length; i++) {
			int j = i + 1;
			if (j < a.length) {
				while (j < a.length) {
					if (2 * a[i] > a[j]) {
						j++;
					} else {
						break;
					}
				}
				if (endIndex - startIndex < j - 1 - i) {
					endIndex = j - 1;
					startIndex = i;
					flag = 1;
				}
			}

		}
		int b[] = null;
		if (flag == 1) {
			b = new int[endIndex - startIndex + 1];
			for (int i = 0; i < b.length; i++) {
				b[i] = a[startIndex++];
			}
		}
		return b;
	}

	public static void main(String args[]) {
		RemoveMinElements rme = new RemoveMinElements();
		int a[] ={20, 4, 1, 3};
		int b[] = rme.removeMinElements(a);
		if(b!=null){
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}}
		else{
			System.out.println("ALL ELEMENTS REMOVED");
		}
	}
}
