package vishu.personal.techniques.sorting;

public class Sorting {

	public static void main(String[] args) {
		int [] a = {2,7,4,1,5,3};
		int n = a.length;
		System.out.println("The given array is: ");
		for(int b: a){
			System.out.print(b +" ");
		}
		System.out.println();
		selectionSort(a, n);
		bubbleSort(a, n);
	}
	
	/*
	 * In Selection Sort we sort it in ascending order by placing one element in it's proper
	 * position every loop.
	 * Time Complexity	: O(n^2).
	 * Space Complexity	: O(1).
	 */
	public static void selectionSort(int [] a, int n){
		for(int i=0; i<n-1; i++){
			int minIndex = i;
			for(int j=i+1; j<n; j++){
				if(a[j] < a[minIndex]){
					minIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
		System.out.println("SELECTION SORT of given array: ");
		for(int b: a){
			System.out.print(b +" ");
		}
		System.out.println();
	}
	
	/*
	 * In Bubble Sort we each element with its adjacent and move it if its greater than adjacent.
	 * This way the greatest number moves to right end array. We repeat this procedure.
	 * Time Complexity	: O(n^2)
	 * Space Complexity	: O(n^2)
	 */
	public static void bubbleSort(int [] a, int n){
		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-1-i; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println("BUBBLE SORT of given array: ");
		for(int b: a){
			System.out.print(b +" ");
		}
		System.out.println();
	}
}
