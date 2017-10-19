import java.util.Arrays;

public class Main {
	
	public static String reverseParentheses(String exp){
		Stack<Character> pila = new Stack<Character>();
		String Parentheses = "";
		char next = '0';
		char current = '0';
		int size = 0;
		for(int i = 0; i < exp.length(); i++){
			next = exp.charAt(i);
			if(next != '('){
				Parentheses += next;
			}
			else if(next == '('){
					
				int j = i+1;
				while(current != ')'){
					pila.push(exp.charAt(j));
					j++;
					current = exp.charAt(j);
				}
				current = 0;
				size = pila.size();
				for(int n = 0; n < size; n++){
					Parentheses += pila.pop();
				}
				i += size+1;
				
			}	
			
		}
		return Parentheses;
		}
			
		
	
	

	public static void main(String[] args) {
		System.out.println(reverseParentheses("(ab)(cd)(ef)g"));

	}

}
