package arrays;


/**
 * @author Dilip
 *
 *         github Profile: https://github.com/satya444
 *
 */
public class MaxSub2dArray {

	public int[][] getMaxsubArray(int a[][]) {
		int maxRowStart = 0;
		int maxColStart = 0;
		int maxRowEnd = 0;
		int maxColEnd = 0;
		int maxSubarraySum=Integer.MIN_VALUE;
		int rows = a.length;
		int cols = a[0].length;
		for (int i = 0; i < cols - 1; i++) {
			for (int j = i + 1; j < cols; j++) {
				int[] temp = new int[rows];
				int currRow = 0;
				while (currRow < rows) {
					int k = i;
					while (k <= j) {
						temp[currRow] += a[currRow][k++];
					}
					currRow++;
				}
				int[] sumRowIndexes= getMaxSubArrayIndexes(temp);
				if(sumRowIndexes[0]>maxSubarraySum){
					maxSubarraySum=sumRowIndexes[0];
					maxColStart=i;
					maxColEnd=j;
					maxRowStart=sumRowIndexes[1];
					maxRowEnd=sumRowIndexes[2];
				}
			}
		}
		System.out.println(maxSubarraySum);
		System.out.println(maxColStart+" "+maxColEnd+" "+maxRowStart+" "+maxRowEnd);
		int b[][]= new int[maxRowEnd-maxRowStart+1][maxColEnd-maxColStart+1];
		int n= maxRowStart;
		for(int i=0; i< b.length; i++){
			 int m=maxColStart;
			for(int j=0; j<b[0].length; j++){
				b[i][j]=a[n][m++];
			}
			n++;
		}
		return b;
	}
	
	public int[] getMaxSubArrayIndexes(int a[]){
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
		int sumIndexes[]={maxSofar,maxStartIndex,maxEndIndex};
		return sumIndexes;
	}
	public static void main(String args[]){
		MaxSub2dArray msa= new MaxSub2dArray();
		int a[][]={{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
               };
		a=msa.getMaxsubArray(a);
		for(int i=0; i< a.length; i++){
			for(int j=0; j<a[0].length; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
