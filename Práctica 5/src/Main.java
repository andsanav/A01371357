import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Testing array reversing");
		int[] inputArray = {1, 2, 3, 4, 5};
		
		Stack<Integer> reverse = new Stack<Integer>();
		for(int i=0;i<inputArray.length;i++)
			reverse.push(inputArray[i]);
		
		int[] outputArray = new int[inputArray.length];
		
		for(int i=0;i<inputArray.length;i++)
			outputArray[i] = reverse.pop();// TODO: pop every item in inputArray and save them in outputArray
		
		System.out.println("Input: " + Arrays.toString(inputArray));
		System.out.println("Output: " + Arrays.toString(outputArray));
		System.out.println();
		
		System.out.println("Testing train ordering");
		Stack<Integer> train = new Stack<Integer>();
		train.push(3);
		train.push(2);
		train.push(1);
		train.push(3);
		train.push(2);
		
		System.out.println("Train as it arrived to the station: " + Arrays.toString(train.toArray()));
		Stack<Integer> holding1 = new Stack<Integer>();
		Stack<Integer> holding2 = new Stack<Integer>();
		Stack<Integer> output = new Stack<Integer>();
		
		for(int i=0;i<train.size();i++)	{
		switch (train.peek().intValue()) {
			case 1: 
				holding1.push(train.pop());
			case 2: 
				holding2.push(train.pop());
			case 3:
				output.push(train.pop());
				}
		}
		for(int i=0;i<=output.size();i++)
			train.push(output.pop());
		for(int i=0;i<=holding2.size();i++)
			train.push(holding2.pop());
		for(int i=0;i<=holding1.size();i++)
			train.push(holding1.pop());
		
		
		// TODO: sort the wagons in priority order
		
		System.out.println("Train ordered by priority: " + Arrays.toString(train.toArray()));
		System.out.println();
		
		Stack<Integer> towerOne = new Stack<Integer>();
		Stack<Integer> towerTwo = new Stack<Integer>();
		Stack<Integer> towerThree = new Stack<Integer>();
		
		towerOne.push(3);
		towerOne.push(2);
		towerOne.push(1);
		
		System.out.println("At the beginning");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		
		for(int i=0;i<=towerOne.size();i++){
			if(towerTwo.empty()||towerTwo.peek()>towerOne.peek()){
				towerTwo.push(towerOne.pop());
			}else if(towerThree.empty()||towerThree.peek()>towerOne.peek())
				towerThree.push(towerOne.pop());
		}
		
		for(int i=0;i<=towerTwo.size();i++){
			if(towerThree.empty()||towerThree.peek()>towerTwo.peek()){
				towerThree.push(towerTwo.pop());
			}else if(towerOne.empty()||towerOne.peek()>towerTwo.peek())
				towerOne.push(towerTwo.pop());
		}
		for(int i=0;i<=towerOne.size();i++){
			if(towerTwo.empty()||towerTwo.peek()>towerOne.peek()){
				towerTwo.push(towerOne.pop());
			}else if(towerThree.empty()||towerThree.peek()>towerOne.peek())
				towerThree.push(towerOne.pop());
		}
		for(int i=0;i<=towerThree.size();i++){
			if(towerOne.empty()||towerOne.peek().equals(towerThree.peek()+1)){
				towerOne.push(towerThree.pop());
			}else if(towerTwo.empty()||towerTwo.peek()>towerThree.peek())
				towerTwo.push(towerThree.pop());
		}
		for(int i=0;i<=towerOne.size();i++){
			if(towerTwo.empty()||towerTwo.peek()>towerOne.peek()){
				towerTwo.push(towerOne.pop());
			}else if(towerThree.empty()||towerThree.peek()>towerOne.peek())
				towerThree.push(towerOne.pop());
		}
		
		
		System.out.println("At the end");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		System.out.println();
	}
}
