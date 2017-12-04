import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
//Exámen Final Andrea Salas Navarro a01371357
public class Main {
	
	public static String cleanString(String str){
		String result = "";
		for(int i = 0; i < str.length(); i++){
			if(Character.isAlphabetic(str.charAt(i))){
				result += String.valueOf(str.charAt(i)).toUpperCase();
			}
		}
		return result;
	}
	
	public static int mystery(int m, int n){
		if(m == 0)
			return n+1;
		if(m > 0 && n == 0)
			return mystery(m-1,1);
		if(m > 0 && n > 0)
			return mystery(m-1,mystery(m,n-1));
		return 0;			
	}
	
	public static LinkedList<Integer> union(LinkedList<Integer> list1, LinkedList<Integer> list2){
		LinkedList<Integer> result = new LinkedList<Integer>();
		LinkedList<Integer> list = list1;
		LinkedList<Integer> list3 = list2;
		while(!list.isEmpty()){
			result.add(list.removeFirst());
		}
		while(!list3.isEmpty()){
			result.add(list3.removeFirst());
		}
		return result;
	}
	
	public static void insertInOrder(LinkedList<Integer> lst,int element){
		int i = 0;
		boolean add = false;
		while(lst.get(i) != null && add == false){
			if(lst.get(i) > element || lst.get(i) == element){
				if(i == 0){
					lst.addFirst(element);
					add = true;
				} else {
				lst.add(i, element);
				add = true;
			}
		}
			i++;
		}
		if(add = false){
			lst.addLast(element);
		}	
	}
	
	public static void eraseInOrder(LinkedList<Integer> lst,int count, boolean desc){
		if(desc == true){
			for(int i = 0; i < count; i++){
				lst.removeLast();
				if(lst.isEmpty())
					break;
			}
		} else {
			for(int i = 0; i < count; i++){
				lst.removeFirst();
				if(lst.isEmpty())
					break;
			}
		}
	}
	
	public static void moveToBeginning(LinkedList<Integer> lst,int i){
		if(i > lst.size()-1){
			throw new IndexOutOfBoundsException();
		}
		int toMove = lst.get(i);
		lst.remove(i);
		lst.addFirst(toMove);
	}
	
	public static int get(Stack<Integer> lst, int i){
		Stack<Integer> lst2 = lst;
		if(i > lst.size())
			throw new IndexOutOfBoundsException();
		if(i == 0)
			return lst.peek();
		for(int j = 0; j < i; j++){
			lst2.pop();
		}
		return lst2.peek();
	}
	
	public static void moveToTop(Stack<Integer> lst, int x){
		Queue<Integer> fila = new Queue<Integer>();
		if(x > lst.size())
			throw new IndexOutOfBoundsException();
		for(int j = 0; j < x; j++){
			fila.offer(lst.pop());
		}
		int toMove = lst.pop();
		while(!fila.isEmpty()){
			lst.push(fila.remove());
		}
		lst.push(toMove);
	}
	
	public static void superSort(String[] arr){
		LinkedList<String> cero = new LinkedList<String>();
		LinkedList<String> uno = new LinkedList<String>();
		LinkedList<String> dos = new LinkedList<String>();
		LinkedList<String> tres = new LinkedList<String>();
		LinkedList<String> cuatro = new LinkedList<String>();
		LinkedList<String> cinco = new LinkedList<String>();
		LinkedList<String> seis = new LinkedList<String>();
		LinkedList<String> siete = new LinkedList<String>();
		LinkedList<String> ocho = new LinkedList<String>();
		LinkedList<String> nueve = new LinkedList<String>();
		for(int i = arr[0].length()-1; i >= 0; i--){
			for(int j = 0; j < arr.length; j++){
				char last = arr[j].charAt(i);
				if(last == '0')
					cero.addLast(arr[j]);
				if(last == '1')
					uno.addLast(arr[j]);
				if(last == '2')
					dos.addLast(arr[j]);
				if(last == '3')
					tres.addLast(arr[j]);
				if(last == '4')
					cuatro.addLast(arr[j]);
				if(last == '5')
					cinco.addLast(arr[j]);
				if(last == '6')
					seis.addLast(arr[j]);
				if(last == '7')
					siete.addLast(arr[j]);
				if(last == '8')
					ocho.addLast(arr[j]);
				if(last == '9')
					nueve.addLast(arr[j]);
				}
			for(int m = 0; m < arr.length; m++){
				if(!cero.isEmpty())
					arr[m] = cero.removeFirst();
				else if(!uno.isEmpty())
					arr[m] = uno.removeFirst();
				else if(!dos.isEmpty())
					arr[m] = dos.removeFirst();
				else if(!tres.isEmpty())
					arr[m] = tres.removeFirst();
				else if(!cuatro.isEmpty())
					arr[m] = cuatro.removeFirst();
				else if(!cinco.isEmpty())
					arr[m] = cinco.removeFirst();
				else if(!seis.isEmpty())
					arr[m] = seis.removeFirst();
				else if(!siete.isEmpty())
					arr[m] = siete.removeFirst();
				else if(!ocho.isEmpty())
					arr[m] = ocho.removeFirst();
				else if(!nueve.isEmpty())
					arr[m] = nueve.removeFirst();
			}
		}
	}
	public static void main(String[] args) {
		/*System.out.println(cleanString("sbh4b%rs"));
		System.out.println(mystery(0,0));
		System.out.println(mystery(4,0));
		System.out.println(mystery(3,4));*/
		String[] toSort = {"123","398","210","019","528","003","513","129","220","294"};
		superSort(toSort);
		System.out.println(Arrays.toString(toSort));
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		for(int i = 0; i < 6; i++)
			a.add(i);
		for(int i = 5; i < 9; i++)
			b.add(i);
		System.out.println(union(a,b).toString());
		LinkedList<Integer> c = new LinkedList<Integer>();
		c.add(1);
		c.add(2);
		c.add(6);
		c.add(8);
		c.add(11);
		c.add(54);
		System.out.println(c.toString());
		insertInOrder(c,10);
		System.out.println(c.toString());
		LinkedList<Integer> a1 = new LinkedList<Integer>();
		LinkedList<Integer> b1 = new LinkedList<Integer>();
		LinkedList<Integer> c1 = new LinkedList<Integer>();
		for(int i = 0; i < 11; i++)
			a1.add(i);
		for(int i = 50; i < 58; i++)
			b1.add(i);
		for(int i = 20; i < 23; i++)
			c1.add(i);
		eraseInOrder(a1,3,true);
		eraseInOrder(b1,5,false);
		eraseInOrder(c1,6,true);
		System.out.println(a1.toString());
		System.out.println(b1.toString());
		System.out.println(c1.toString());
		moveToBeginning(a1,2);
		System.out.println(a1.toString());
		Stack<Integer> lst = new Stack<Integer>();
		for(int i = 50; i < 58; i++)
			lst.push(i);
		System.out.println(lst.toString());
		System.out.println(get(lst,2));
		moveToTop(lst,4);
		System.out.println(lst.toString());
		
	}

}
