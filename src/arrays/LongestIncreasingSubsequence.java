package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class LongestIncreasingSubsequence {

	public int[] getLongestSubsequence(int a[]){
		
		int len=a.length;
		
		int[] prevIndex= new int[len];
		int[] longSeq=new int[len];
		for(int i=0; i<len; i++){
			prevIndex[i]=-1;
		}
		for(int i=0; i<len; i++){
			longSeq[i]=1;
		}
		for(int i=0; i<len; i++){
			for(int j=i-1; j>=0; j--){
				if(a[i]>a[j]){
					if(longSeq[i]<longSeq[j]+1){
						longSeq[i]=longSeq[j]+1;
						prevIndex[i]=j;
					}
				}
			}
		}
		
		int maxIndex=0;
		int maxVal=Integer.MIN_VALUE;
		for(int i=0; i<len; i++){
			if(a[i]>maxVal){
				maxVal=a[i];
				maxIndex=i;
			}
		}
		printSubsequence(a,prevIndex,maxIndex);
		/*for(int i=0; i<len; i++){
			System.out.println(a[i]+" "+longSeq[i]);
		}*/
		
		return a;
	}
	/**
	 * @param prevIndex
	 * @param maxIndex
	 */
	public void printSubsequence(int[] a, int[] prevIndex, int maxIndex) {
		
		while(maxIndex!=-1){
			System.out.println(a[maxIndex]);
			maxIndex=prevIndex[maxIndex];
		}
	}
	public static void main(String args[]){
		LongestIncreasingSubsequence lis= new LongestIncreasingSubsequence();
		int[] a= { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		lis.getLongestSubsequence(a);
	}
}
