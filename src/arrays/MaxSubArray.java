package arrays;

import java.util.Arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class MaxSubArray {

	public int[] getMaxSubArraySum(int a[]){
		if(a==null || a.length==0){
			return null;
		}
		Integer maxSofar = null;
		Integer sumSofar=null;
		Integer maxStartIndex = 0;
		Integer maxEndIndex = 0;
		Integer start=null;
		Integer end;
		for(int i=0; i< a.length; i++){
			if(i==0){
				maxSofar= a[0];
				sumSofar= a[0];
				start=0;
				maxStartIndex=0;
				maxEndIndex=0;
				end=0;
			}
			else{
				int tempSum=0;
				tempSum=a[i]+sumSofar;
				
				if(a[i]>tempSum){
					start=i;
					end=i;
					sumSofar= a[i];
				}
				else{
					sumSofar+=a[i];
					end=i;
				}
				if(sumSofar>maxSofar){
					maxSofar=sumSofar;
					maxEndIndex=end;
					maxStartIndex=start;
				}
			}
		}
		return Arrays.copyOfRange(a, maxStartIndex, maxEndIndex+1);
	}
	
	public static void main(String args[]){
		MaxSubArray msa= new MaxSubArray();
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		a=msa.getMaxSubArraySum(a);
		if(a==null){
			System.out.println(a);
			return;
		}
		for(int i=0; i< a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
}
