package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class AlternateMatrix {

	public String[][] fillMatrix(int m, int n){
		String prev="o";
		String[][] a= new String[m][n];
		int rowStart=0;
		int rowEnd=m-1;
		int colStart=0; 
		int colEnd= n-1;
		int i= rowStart;
		int j= colStart;
		int k=colEnd;
		int l=rowEnd;
		while(true){
		if(rowStart>rowEnd && colStart>colEnd){
			break;
		}
		for( j=colStart; j<colEnd; j++){
			if(prev.equals("o")){
				a[i][j]="x";
			}
			else{
				a[i][j]="o";
			}
		}
		for( i=rowStart; i<rowEnd; i++){
			if(prev.equals("o")){
				a[i][j]="x";
			}
			else{
				a[i][j]="o";
				
			}
		}
		for(k=j; k> colStart; k--){
			if(prev.equals("o")){
				a[i][k]="x";
			}
			else
				a[i][k]="o";
		}
		for(l=i; l> rowStart; l--){
			if(prev.equals("o")){
				a[l][k]="x";
			}
			else{
				a[l][k]="o";
			}
		}
		rowStart= rowStart+1;
		colStart= colStart+1;
		rowEnd= rowEnd-1;
		colEnd= colEnd-1;
		i=rowStart;j=colStart;k=rowEnd; l=colEnd;
		if(colStart>colEnd && rowStart>rowEnd){
			break;
		}
		if(prev.equals("o")){
			prev="x";
		}
		else{
			prev="o";
		}
	}
		return a;
	}
	
	public static void main(String args[]){
		AlternateMatrix am = new AlternateMatrix();
		String[][] a= am.fillMatrix(4,4);
		for(int i=0; i< a.length ; i++){
			for(int j=0; j<a[0].length; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
