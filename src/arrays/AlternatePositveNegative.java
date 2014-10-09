package arrays;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class AlternatePositveNegative {

	public int[] getAlternate(int a[]) {
		int i = 0;
		int j = 1;
		int len = a.length;
		int prev = 1;
		while (true) {
			if (i == len || j == len) {
				return a;
			}
			if (prev == 1) {
				if (a[i] < 0) {
					j= Math.max(j, i+1);
					prev = -1;
				} else {
					while (a[j] >= 0) {
						j++;
						if (j == len) {
							return a;
						}

					}
					int temp = j;
					int tempVal = a[j];
					while (temp > i) {
						a[temp] = a[temp - 1];
						temp--;
					}
					a[temp] = tempVal;
					prev = -1;
				}
			}
			else	if (prev == -1) {
				if (a[i] > 0) {
					j= Math.max(j, i+1);
					prev = 1;
				} else {
					while (a[j] < 0) {
						j++;
						if (j == len) {
							return a;
						}

					}
					int temp = j;
					int tempVal = a[j];
					while (temp > i) {
						a[temp] = a[temp - 1];
						temp--;
					}
					a[temp] = tempVal;
					prev=1;
				}
			}
			i++;

		}
	}

	public static void main(String args[]) {
		AlternatePositveNegative apn = new AlternatePositveNegative();
		int a[] = {-1, -2, -3, -4, -1, 4};
		a = apn.getAlternate(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
