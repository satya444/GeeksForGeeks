package arrays;


/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class MinimumJumps {
	
	int minCount=Integer.MAX_VALUE;
	String outPath="";
	public void countPath(int[] a, int index, int len, int count,String path){
		if(index>=len){
			return;
		}
		if(index==len-1){
		//	System.out.println("***********************");
		//	System.out.println(count+1);
			if(count+1<minCount){
				minCount=count+1;
				outPath=path+a[index];
			}
		//	System.out.println(path+a[index]);
		//	System.out.println("***********************");
			return;
		}
		for(int i=1; i<=a[index];i++){
			countPath(a, index+i, len, count+1,path+a[index]);
		}
		
	}
	//dp method similiar to longest increasing subsequence
	//for path use another array
	public void getDpLeastJumps(int a[]){
		int len= a.length;
		int[] jumps= new int[len];
		jumps[0]=1;
		for(int i=1; i<len; i++){
			for(int j=0; j<i; j++){
				if(i-j<=a[j]){
					jumps[i]=jumps[j]+1;
					break;
				}
			}
		}
		
		System.out.println(jumps[len-1]);
	}
	
	public static void main(String args[]){
		MinimumJumps mj= new MinimumJumps();
		int a[]={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		String path="";
		mj.countPath(a, 0, a.length, 0, path);
		System.out.println(mj.outPath);
		mj.getDpLeastJumps(a);
	}

}
