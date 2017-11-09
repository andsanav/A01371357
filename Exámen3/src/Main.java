import java.util.LinkedList;
import java.util.Stack;
//Andrea Salas Navarro A01371357
public class Main {
	
	public static String allStar(String str){
		if(str == str.substring(0,1)){
			return str;
		}
		else{
			return str.substring(0,1) + "*" + allStar(str.substring(1));
		}
	}
	
	public static String endX(String str){
		if(str == str.substring(0,1)){
			return str;
		}
		  if(str.charAt(0) == 'x'){
			  return endX(str.substring(1)) + "x";
		  }
		  else
			  return String.valueOf(str.charAt(0)) + endX(str.substring(1));
			  		  
	}
	
	public static LinkedList<Integer> difference(LinkedList<Integer> list1, LinkedList<Integer> list2){
		LinkedList<Integer> result = new LinkedList<Integer>();
		for(int i = 0; i < list1.size();i++){
			if(!list2.contains(list1.get(i)))
				result.add(list1.get(i));
		}
		return result;
	}
	
	public static LinkedList<Integer> intersect(LinkedList<Integer> list1, LinkedList<Integer> list2){
		LinkedList<Integer> result = new LinkedList<Integer>();
		for(int i = 0; i < list1.size();i++){
			if(list2.contains(list1.get(i)))
				result.add(list1.get(i));
		}
		return result;
	}
	
	public static int shapeArea(int n){
		if(n == 1){
			return 1;
		}
		else
			return shapeArea(n-1) + 4*(n-1);
				
	}
	
	public static int maxDepth(String exp){
		Stack<Character> pila = new Stack<Character>();
		int depth = 0;
		for(int i = 0; i < exp.length(); i++){
			if(exp.charAt(i) == '('){
				pila.push(exp.charAt(i));
				if(depth < pila.size())
					depth = pila.size();
			}
			else if(exp.charAt(i) == ')'){
				if(pila.isEmpty())
					return -1;
				if(pila.peek() !='(')
					return -1;
				else{
					pila.pop();
					
				}
				
			}		
		}
		if(!pila.isEmpty())
			return -1;
		return depth;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Pruebas allStar");
		System.out.println(allStar("hello"));
		System.out.println(allStar("abc"));
		System.out.println(allStar("ab"));
		System.out.println(allStar("a"));
		System.out.println("Pruebas endX");
		System.out.println(endX("a"));
		System.out.println(endX("x"));
		System.out.println(endX("rexx"));
		System.out.println(endX("xxhixx"));
		System.out.println(endX("xhixhix"));
		System.out.println("Pruebas difference");
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++)
			list1.add(i);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		for(int i = 5; i < 16; i++)
			list2.add(i);
		System.out.println("list1: " + list1.toString());
		System.out.println("list2: " + list2.toString());
		System.out.println(difference(list1, list2).toString());
		System.out.println("Pruebas intersect");
		System.out.println(intersect(list1, list2).toString());
		System.out.println("Pruebas shapeArea");
		System.out.println(shapeArea(1));
		System.out.println(shapeArea(2));
		System.out.println(shapeArea(3));
		System.out.println(shapeArea(4));
		System.out.println(shapeArea(5));
		System.out.println("Pruebas maxDepth");
		System.out.println(maxDepth("(a(b)(c)(d(e(f)g)h)I(j(k)l)m)"));
		System.out.println(maxDepth("(p((q))((s)t))"));
		System.out.println(maxDepth(""));
		System.out.println(maxDepth("b)(c)()"));
		System.out.println(maxDepth("(b)((c)()"));
	}

}
