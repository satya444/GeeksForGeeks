package arrays;

import java.util.Arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class FourElementSum {

	class PairSum implements Comparable<PairSum>{
		int a;
		int b;
		int sum;
		public PairSum(int a, int b) {
			this.a=a;
			this.b=b;
			this.sum=a+b;
		}
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(PairSum in) {
			
			return Integer.compare(this.sum, in.sum);
		}
	}
	PairSum[] ps;
	public void getFourElement(int a[], int x){
		int n=a.length;
		ps= new PairSum[n*(n-1)/2];
		int k=0;
		for(int i=0; i<a.length;i++){
			for(int j=i+1; j<a.length; j++){
				 ps[k++]= new PairSum(a[i], a[j]);
			}
		}
		Arrays.sort(ps);
		
		printFourElements(ps,0,ps.length-1,x);
	
	}
	/**
	 * @param ps2
	 */
	public void printFourElements(PairSum[] ps2,int start, int end,int x) {
		if(start>end){
			System.out.println("NO ELEMENTS");
			return;
		}
		if(ps[start].sum+ps[end].sum ==x){
			if(ps[start].a!=ps[end].a && ps[start].a!=ps[end].b && ps[start].b!=ps[end].b && ps[start].b!=ps[end].a){
				System.out.println(ps[start].a +" "+ps[start].b+" "+ps[end].a+" "+ps[end].b);
				return;
			}
			else{
				start=start+1;
				end=end-1;
				printFourElements(ps2, start, end, x);
			}
		}
		else if(ps[start].sum+ps[end].sum<x){
			start=start+1;
			printFourElements(ps2, start, end, x);
		}
		else{
			end=end-1;
			printFourElements(ps2, start, end, x);
		}
	}
	
	public static void main(String args[]){
		FourElementSum fes= new FourElementSum();
		int a[]={10, 20, 30, 40, 1, 2};
		fes.getFourElement(a, 91);
	}
}
