package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class MaxPathSum {

	public int getMaxPathSum(int a[], int b[]){
		int i=0;
		int j=0;
		int maxTillNow=0;
		int alen= a.length;
		int blen=b.length;
		int aSum=0;
		int bSum=0;
		while(true){
			if( i== alen ){
				while(j<blen){
					bSum+=b[j];
					j++;
				}
				return (aSum>bSum) ?(maxTillNow+aSum):(maxTillNow+bSum);
			}
			if( j== blen ){
				while(i<alen){
					aSum+=a[i];
					i++;
				}
				return (aSum>bSum) ?(maxTillNow+aSum):(maxTillNow+bSum);
			}
			if(a[i]<b[j]){
				aSum+=a[i];
				i++;
			}
			else if(b[j]<a[i]){
				bSum+=b[j];
				j++;
			}
			else{
				maxTillNow+= Math.max(aSum, bSum)+a[i];
				aSum=0;
				bSum=0;
				i++;
				j++;
				
			}
			
		}
	}
	public static void main(String args[]){
		MaxPathSum mps= new MaxPathSum();
		int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34};
        int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};
		System.out.println(mps.getMaxPathSum(ar1, ar2));
	}
}
