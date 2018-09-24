package vishu.personal.testdome;

public class TwoSum {
	public static void main(String[] args){
		int[] indices = findTwoSum(new int[] {3,1,5,5,7,5,9}, 10);
		if(indices != null){
			System.out.println(indices[0] +" " +indices[1]);
		}
	}
	
	public static int[] findTwoSum(int[] list, int sum){
		int len = list.length;
		for(int i=0; i<len-1; i++){
			int curr = list[i];
			for(int j=i+1;j<len; j++){
				if(curr + list[j] == sum){
					return new int[] {list[i], list[j]};
				}
			}
		}
		return null;
	}
}
