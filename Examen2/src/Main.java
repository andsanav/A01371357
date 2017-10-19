
public class Main {
	/*Código original exámen*/
	/*public static String reverseParentheses(String exp){*/
		/*Stack<Character> pila = new Stack<Character>();
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
		System.out.println(reverseParentheses(""));

	}

}*/ 
	/*Código corregido*/
		public static String reverseParentheses(String exp){
			Stack<Character> pila = new Stack<Character>();
			Queue<Character> fila = new Queue<Character>();
			boolean inPar = false;
			String reverseParentheses = "";
			for(int i = 0; i < exp.length(); i++){
				char next = exp.charAt(i);
				if(next != '(' && next != ')' && inPar == false)
					reverseParentheses += next;
				else if(next == '('||(inPar == true && next != ')')){
					pila.push(next);
					inPar = true;
				}
				else if(next == ')'){
					while(pila.peek() != '('){
						fila.offer(pila.pop());
					}
					pila.pop();
					if(pila.empty())
						inPar = false;
					while(!fila.isEmpty()){
						pila.push(fila.remove());                      
					}
					if(inPar == false){
						while(!pila.empty()){
							fila.offer(pila.pop());
						}
						while(!fila.isEmpty()){
							pila.push(fila.remove());
						}
						while(!pila.empty()){
							reverseParentheses += pila.pop();
						}
					}
							
				}
					
			}
			return reverseParentheses;
				
		}
			
		
	
		public static void main(String[] args) {
			System.out.println(reverseParentheses("a(b(c(d)e)f)g"));
			System.out.println(reverseParentheses("a(b(cd)e)f"));
		}
}
