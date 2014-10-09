package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class NonConsecutiveOnes {

	public int getCount(int n){
		int a[]= new int[n+1];
		int b[]= new int[n+1];
		a[1]=1;
		b[1]=1;
		for(int i=2; i<=n; i++){
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1];
		}
		return a[n]+b[n];
	}
	
	public static void main(String args[]){
		NonConsecutiveOnes nco= new NonConsecutiveOnes();
		System.out.println(nco.getCount(4));
	}
}
