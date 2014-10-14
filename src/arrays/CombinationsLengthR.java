package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class CombinationsLengthR {

	public void getCombLenR(String prefix, String str, int len, int r){
		if(prefix.length()==r){
			System.out.println(prefix);
			return;
		}
		for(int i=0; i< str.length(); i++ ){
			getCombLenR(prefix+str.charAt(i), str.substring(i+1), len, r);
		}
	}
	
	public static void main(String args[]){
		String str="12345";
		CombinationsLengthR clr= new CombinationsLengthR();
		clr.getCombLenR("", str, str.length(), 3);
	}
}
