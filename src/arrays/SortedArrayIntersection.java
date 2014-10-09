package arrays;

/**
 * @author Dilip
 *
 * github Profile: https://github.com/satya444
 *
 */
public class SortedArrayIntersection {

	public void simpleImplementation(int a[], int b[], int c[]){
		int x=0, y=0, z=0;
		while(true){
			if(x==a.length || y==b.length || z== c.length){
				return;
			}
			if(a[x]==b[y]&& a[x]==c[z]){
				System.out.println(a[x]);
				x++;
				y++;
				z++;
			}
			else if(a[x]<b[y]){
				x++;
			}
			else if(b[y]<c[z]){
				y++;
			}
			else{
				z++;
			}
		}
		
	}
	public void findIntersection(int a[], int b[], int c[]){
		int x=0, y=0, z=0;
		while(true){
			if(x==a.length || y==b.length || z== c.length){
				return;
			}
			if(a[x]==b[y]&& a[x]==c[z]){
				System.out.println(a[x]);
				x++;
				y++;
				z++;
			}
			else{
				if(a[x]>b[y] && a[x]>c[z]){
					y++;
					z++;
				}
				else if(b[y]>a[x] && b[y]>c[z]){
					x++;
					z++;
				}
				else if(c[z]>a[x] && c[z]>b[y]){
					x++;
					y++;
				}
				else if(a[x]>b[y] && a[x]==c[z]){
					y++;
				}
				else if(a[x]>c[z] && a[x]== b[y]){
					z++;
				}
				else if(b[y]>a[x] && b[y]==c[z]){
					x++;
				}
				else if(b[y]>c[z] && b[y]== a[x]){
					z++;
				}
				else if(c[z]>a[x] && c[z]==b[y]){
					x++;
				}
				else if(c[z]>b[y] && c[z]== a[x]){
					y++;
				}
			}
		}
	}
	public static void main(String args[]){
		int ar1[] ={1, 5, 10, 20, 40, 80};
		int ar2[] = {6, 7, 20, 80, 100};
		int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		SortedArrayIntersection sai= new SortedArrayIntersection();
		//sai.findIntersection(ar1, ar2, ar3);
		sai.simpleImplementation(ar1, ar2, ar3);
	}
}

