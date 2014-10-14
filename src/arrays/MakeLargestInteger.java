package arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class MakeLargestInteger {

	
	public long makeLargestInteger(int a[]){
		
		List<Integer> integers= new LinkedList<>();
		for(int i=0; i<a.length; i++){
			integers.add(a[i]);
		}
		Collections.sort(integers,new NumberComparator());
		Iterator<Integer> itr= integers.iterator();
		while(itr.hasNext()){
		System.out.println(itr.next());
		}
		return 0;
	}
	
	class NumberComparator implements Comparator<Integer>{

		
		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Integer in1, Integer in2) {
			String str1= String.valueOf(in1)+String.valueOf(in2);
			String str2= String.valueOf(in2)+String.valueOf(in1);
			//System.out.println("************************");
			//System.out.println(str1+" "+str2);
			//System.out.println("************************");
			return Long.compare(Long.parseLong(str2), Long.parseLong(str1));
		}
		
	}
	public static void main(String args[]){
		MakeLargestInteger mli=  new MakeLargestInteger();
		int[] a= {1, 34, 3, 98, 9, 76, 45, 4};
		mli.makeLargestInteger(a);
	}
}

