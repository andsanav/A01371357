
public class Main {
	
	public static int LinearSearch(int[] data, int target){
		for(int i = 0;i < data.length;i++){
			if(data[i] == target){
					return 1;}
			if(data[i] > target){
				return -1;}}
			return -1;
	}
	
	public static int BinarySearch(int[] values, int target){
		int min = 0;
		int max = values.length -1;
		int mid = 0;
		while(min <= max){
			mid = (min+max)/2;
		if(target < values[mid])
			max = mid-1;
		else if(target > values[mid])
			min = mid+1;
			else
				return mid;
		}
		return -1;
		
	}
				

	public static void main(String[] args) {
		
	int[] list = {1,2,3,4,5};
	System.out.println(LinearSearch(list,2));
	System.out.println(BinarySearch(list,4));
	
	}
}