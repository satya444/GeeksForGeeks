package arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class RepeatingElements {

	public void getRepeatingElements(int a[]) {
		int len = a.length;
		for(int i=0; i<len; i++){
			a[i]=a[i]-1;
		}
		for (int i = 0; i < len; i++) {
			a[a[i] % len ] += len;
		}

		for (int i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < len; i++) {
			if (a[i] / len > 1) {
				System.out.println(i + 1);
			}

		}
	}

	public static void main(String args[]) {
		RepeatingElements smp = new RepeatingElements();
		int a[] = { 1, 2, 3, 1, 3, 7,7 };
		smp.getRepeatingElements(a);
	}
}
