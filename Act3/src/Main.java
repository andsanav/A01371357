import java.util.Arrays;
public class Main {
    
    public int LinearSearch(int Values[],int Target){
            for(int i=0; i<Values.length;i++){
                if(Values[i] == Target)
                    return i;
            
                if(Values[i] > Target)
                    i++;
                    return -1;
            }
            return -1;
        }
        
        public int BinarySearch(int Values[], int Target){
            int min = 0;
            int max = (Values.length) -1;
            int mid = 0;
            
            while(min<= max)
                mid = (min + max)/2;
            
                if(Target < Values[mid])
                    max = mid -1;
                
                if(Target> Values[mid])
                    min = mid +1;
                
                else
                    return mid;
                
            return -1;
        }
        
        public static void Insertionsort(int values[]){
            
            
            int save = 0;     
            for (int i = 1; i<values.length;i++){
                for(int j=0; j<i ;j++){
                    if(j < i && values[j] > values[i]){
                        
                        save = values[i];
                        
                        shiftRight(values,j,i);
                        
                        values[j] = save;
                    } 
                }
            }
        }
        
        public static void shiftRight(int values[], int start,int end){
            
            for(int i=end; i> start;i--) 
                values[i] = values[i-1];          
        }
        
        public static void Selectionsort( int values[]){
            int smallest;
            int ind;
            int x;
            
            for(int i=0; i < values.length;i++){
                smallest = values[i];
                ind = i;
                x = values[i];
                for(int j=i; j< values.length; j++){
                    
                    if(values[j] <= smallest){
                        smallest = values[j];
                        ind = j;
                    } 
                    
                }
                values[i] = smallest;
                values[ind] = x;   
            }
        }
            
	public static void Bubblesort(int values[]){
		boolean not_sorted = true;
		while(not_sorted){
			not_sorted = false;
		for(int i = 1;i < values.length;i++){
			if(values[i] < values[i-1]){
			     int value = values[i];
			     values[i] = values[i-1];
			     values[i-1] = value;
			     not_sorted = true;
			}
		}
		}	
	}
	
	public static void makeHeap(int values[]) {
		for(int i=0;i< values.length; i++){
			int index = i;
			while(index != 0){
				int parent = (index -1)/2;
				if(values[index]<=values[parent]){
					break;
				}
				
				int temp = values[index];
				values[index] = values[parent];
				values[parent] = temp;
				
				index = parent;
			}
		}
		
	}
	
	public static int removeTopItem(int values[], int count){
		int result = values[0];
		values[0] = values[count-1];
		
		
		int index = 0;
		while(true) {
			int child1 = 2*index +1;
			int child2 = 2*index +2;
		
		
		if(child2 >= count){
			child2 = index;
		}
		
		if(values[index] >= values[child1] && values[index] >= values[child2]){
			break;
		}
		
		int swapChild = child1;
		if(values[child2] > values[child1]){
			swapChild = child2;
		}
		
		int temp = values[index];
		values[index] = values[swapChild];
		values[swapChild] = temp;
		
		if(swapChild==child1)
			index++;
		else if(swapChild == child2){
			index = index+2;
		}
		
		

		}
		
		return result;
		
	}
	
	public static void Heapsort(int values[]){
		makeHeap(values);
		int count = values.length;
		
		for(int i=values.length-1;i>=0;i--){
			int temp =values[0];
			values[0] = values[i];
			values[i] = temp;
			int values2[] = new int[count-1];
			
			for(int n = 0; n < values2.length; n++){
				values2[n] = values[n];
				}
			
			makeHeap(values2);
			
			for(int m = 0; m < values2.length;m++){
				values[m]= values2[m];
			}
			
			count--;
			
		}
	}

	public static void main(String[] args) {
	 int values[] = {6,4,3,1,8,9,7,5,10,2,11,12,15};
	 Bubblesort(values);
	 System.out.println(Arrays.toString(values));
	 Heapsort(values);
	 System.out.println(Arrays.toString(values));
	 makeHeap(values);
	 System.out.println(Arrays.toString(values));
	 removeTopItem(values, 13);
	 System.out.println(Arrays.toString(values));
	 
	 
	
	}

}
