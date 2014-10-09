package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class FirstMissingPositive {

	public int missingNumber(int a[]){
		if(a.length==0){
			return 1;
		}
		int i=1;
		int sum=a[0];
		if(sum!=1){
			return 1;
		}
		while(i<a.length){
			if(sum>a[i]){
				sum= sum+a[i];
			}
			else{
				return sum+1;
			}
			i++;
		}
		return sum+1;
	}
	
	public static void main(String args[]){
		 int arr1[] = {1, 1, 3, 4};
		 FirstMissingPositive fmp= new FirstMissingPositive();
		 System.out.println(fmp.missingNumber(arr1));
	}
}
