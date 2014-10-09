package arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class SubSquareSum {

	List<Integer> allSubSums = new LinkedList<>();

	public void findSums(int a[][], int k, int n) {
		int i = 0;
		int j = 0;
		if (k == 1) {
			while(j<n){
				while(i<n){
					allSubSums.add(a[i][j]);
					i++;
				}
				i=0;
				j++;
			}
		} else {
			while (j + k <=n) {
				int[] rowSum= new int[k];
				int subSum = 0;
				while(i+k<=n){
				for (int q = j; q < j + k; q++) {
					rowSum[i] += a[i][q];
				}
				i++;
				}
				
				for(int l=0; l< rowSum.length; l++){
					subSum+= rowSum[l];
				}
				allSubSums.add(subSum);
				int startIndex=0;
				while (i < n) {
					subSum=0;
					rowSum[startIndex]=0;
					for (int q = j; q < j + k; q++) {
						rowSum[startIndex] += a[i][q];
					}
					for(int l=0; l< rowSum.length; l++){
						subSum+= rowSum[l];
					}
					allSubSums.add(subSum);
					startIndex++;
					i++;
				}
				j++;
				i = 0;
			}
		}

	}

	public static void main(String args[]) {
		SubSquareSum sss = new SubSquareSum();
		int a[][] ={ {1, 2, 3},
	            {4, 5, 6},
	            {7, 8, 9},
	         };
		sss.findSums(a,2, 3);
		sss.allSubSums.forEach(System.out::println);
	}
}
