package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class NextGreaterNumber {

	public String getNextGreater(String n){
		String res="";
		int len= n.length();
		int j=0;
		int posVal=0;
		int units= Integer.parseInt(String.valueOf(n.charAt(len-1)));
		for(int i=n.length()-2; i>=0; i--){
			 posVal= Integer.parseInt(String.valueOf(n.charAt(i)));
			if(posVal<units){
				j=i;
				break;
			}
		}
		int i=0; 
		if(j==0){
			return null;
		}
		while(i<j){
			res+=n.charAt(i);
			i++;
		}
		res+=units;
		res+=n.charAt(i);
		i= len-2;
		while(i>j){
			res+=n.charAt(i);
			i--;
		}
		return res;
	}
	
	public static void main(String args[]){
		NextGreaterNumber ngn= new NextGreaterNumber();
		System.out.println(ngn.getNextGreater("4321"));
	}
}
