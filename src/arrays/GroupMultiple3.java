package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class GroupMultiple3 {
	
	public int getGroupCount(int a[]){
		int count0=0;
		int count1=0;
		int count2=0;
		int groupTwoCount=0;
		int groupThreeCount=0;
		for(int i=0; i< a.length; i++){
			if(a[i]%3==0){
				count0++;
			}
			if(a[i]%3==1){
				count1++;
			}
			if(a[i]%3==2){
				count2++;
			}
		}
		groupTwoCount= ((count0)*(count0-1)/2)+(count1*count2);
		groupThreeCount=((count0)*(count0-1)*(count0-2)/6)+((count1)*(count1-1)*(count1-2)/6)+((count2)*(count2-1)*(count2-2)/6)+(count0*count1*count2);
		
		return groupTwoCount+groupThreeCount;
	}


	public static void main(String args[]){
		int a[]= {2, 1, 3, 4};
		GroupMultiple3 gm= new GroupMultiple3();
		System.out.println(gm.getGroupCount(a));
	}
}
