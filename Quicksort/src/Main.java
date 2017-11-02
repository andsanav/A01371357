import java.util.*;
public class Main {

	public static void Quicksort(int[] values,int start, int end){
		if(start >= end)
			return;
		int div = values[start];
		Stack<Integer> before = new Stack<Integer>();
		Stack<Integer> after = new Stack<Integer>();
		
		for(int i = start + 1; i <= end; i++){
			if(values[i] < div)
				before.push(values[i]);
			else
				after.push(values[i]);
		}
		int i = start;
		while(!before.empty())
			values[i++] = before.pop();
		int middle = i++;
		values[middle] = div;
		while(!after.empty()) {
			values[i++] = after.pop();
		}
	}

	public static void Mergesort(int[] values, int[] scratch, int start, int end){
		if(start>=end)
			return;
		int midpoint = (start + end)/2;
		Mergesort(values, scratch, start, midpoint);
		Mergesort(values, scratch, midpoint + 1, end);
		
		int leftIndex = start;
		int rightIndex = midpoint + 1;
		int scratchIndex = leftIndex;
		
		while(leftIndex <= midpoint && rightIndex <= end){
			if(values[leftIndex] <= values[rightIndex]){
				scratch[scratchIndex] = values[leftIndex];
				leftIndex = leftIndex + 1;
			}
			else{
				scratch[scratchIndex] = values[rightIndex];
				rightIndex = rightIndex + 1;
			}
			scratchIndex += 1;
			
			}
		for(int i = leftIndex; i <= midpoint; i++){
			scratch[scratchIndex] = values[i];
			scratchIndex++;
			
		}
		for(int i = rightIndex; i <= end; i++){
			scratch[scratchIndex] = values[i];
			scratchIndex++;
		}
		for(int i = start; i <= end; i++)
			values[i] = scratch[i];
	}
		
		public static void main(String[] args) {
			int uArray[] ={10, 4, 1, 240, 1024,23,21,9};
			//System.out.println("Before: " + Arrays.toString(uArray));
			//Quicksort(uArray, 0, uArray.length -1);
			//System.out.println("Quicksort: " + Arrays.toString(uArray));
			int scratch[] = new int[uArray.length];
			Mergesort(uArray, scratch, 0, uArray.length - 1);
			System.out.println(Arrays.toString(uArray));
		}
	
}
