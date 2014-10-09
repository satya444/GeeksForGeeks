package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class SmallestSubArray {

	public int[] getSubArray(int a[],int x){
		int start=0;
		int end=0;
		int len= a.length;
		int minStart=0;
		int minEnd=len-1;
		int sum=0;
		while(end<len){
			while(sum<=x && end<len ){
				sum+=a[end++];
			}
			
			while(sum>x && start<len){
				if(end-1-start< minEnd-minStart){
					minEnd=end-1;
					minStart=start;
				}
				
				sum-=a[start++];
			}
		}
		int[] b= new int[minEnd-minStart+1];
		for(int i=0; i<b.length; i++){
			b[i]=a[minStart++];
		}
		return b;
	}
	
	public static void main(String args[]){
		SmallestSubArray ssa= new SmallestSubArray();
		int a[]= {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		int[] b=ssa.getSubArray(a, 280);
		for(int i=0; i<b.length; i++){
			System.out.print(b[i]+" ");
		}
	}
}
