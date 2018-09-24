package vishu.personal.techniques.searching;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Array Size:- ");
		int N = sc.nextInt();
		int [] input = new int[N];
		System.out.print("****PLEASE ENTER SORTED ARRAY****\nEnter here:- ");
		for(int i=0; i<N; i++){
			input[i] = sc.nextInt();
		}
		
		System.out.print("Enter the Number you want to Search:- ");
		int searchNumber = sc.nextInt();
		
		sc.close();
		
		int left = 0;
		int right = N-1;
		
		int mid = (left + right) / 2;;
		boolean flag = false;
		
		while((left < right) && (left != mid)){
			mid = (left + right) / 2;
//			System.out.println("Left=" +left +",right=" +right +",mid=" +mid);
			if(input[mid] == searchNumber){
				System.out.println("Number '" +searchNumber +"' is at Index '" +mid + "' of Input Array");
				flag = true;
				break;
			}
			else if(input[mid] < searchNumber){
				left = mid;
				continue;
			}
			else if(input[mid] > searchNumber){
				right = mid;
				continue;
			}
		}
		if(!flag){
			System.out.println("Number '" +searchNumber +"' is not in the Input Array");
		}
	}

}
