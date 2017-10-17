
public class Main {
	
	public static String checkForBalance(String toCheck){
		Stack<Character> stack = new Stack<Character>();
		System.out.println(toCheck);
		char check = 0;
		String revision = "";
		toCheck.replaceAll("\\s+","");
		for(int i=0; i<toCheck.length();i++){
			if(toCheck.charAt(i) == '(' ||toCheck.charAt(i) == '['||toCheck.charAt(i) == '{'){
				stack.push(toCheck.charAt(i));
			}
			else if(toCheck.charAt(i) == ')' ||toCheck.charAt(i) == ']'||toCheck.charAt(i) == '}'){
				if(stack.empty()){
					for(int n = 0; n < i; n++)
						revision += " ";
					revision += "^ Missing left symbol";
					return revision;
				}
				check = stack.pop();
				switch(toCheck.charAt(i)){
				case ')':
					if(check != '('){
						for(int n = 0; n < i; n++)
							revision += " ";
					    revision += "^ Missing left symbol";
					    return revision;
					}
					break;
				case ']':
					if(check != '['){
						for(int n = 0; n < i; n++)
							revision += " ";
					    revision += "^ Missing left symbol";
					    return revision;
					}
					break;
				case '}':
					if(check != '{'){
						for(int n = 0; n < i; n++)
							revision += " ";
					    revision += "^ Missing left symbol";
					    return revision;
					}
					break;
				default:
                    break;
				}
			}
			
		}
		for(int n = 0; n < toCheck.length(); n++)
			revision += " ";
		if(stack.size()!=0){
	        revision += "^ Missing right symbol";
	        return revision;
		}
		
		revision += "Expression is balanced";
		return revision;
				}
	
	public static String postfixEval(String expression){
		Stack<Integer> exp = new Stack<Integer>();
		char next = ' ';
		int temp = 0;
		int retVal = 0;
		for(int i = 0; i < expression.length();i++){
			next = expression.charAt(i);
			if(next == '0'||next == '1' ||next == '2'||next == '3'||next == '4'||next == '5'||next == '6'||next == '7'||next == '8'||next == '9'){
				exp.push(Character.getNumericValue(next));
			}
			if(next == '+'||next == '-' ||next == '/'||next == '*'){
				if(exp.size() < 2){
					return "The expression has too many operators";
				}
				temp = exp.pop();
				switch(next){
				case '+':
					retVal = exp.pop()+temp;
					exp.push(retVal);
					break;
				case '-':
					retVal = exp.pop()-temp;
					exp.push(retVal);
					break;
				case '/':
					retVal = exp.pop()/temp;
					exp.push(retVal);
					break;
				case '*':
					retVal = exp.pop()*temp;
					exp.push(retVal);
					break;
				
				}
				
			}
		}
		if(exp.size() > 1){
			return "The expression has too many operands";
		}
		return String.valueOf(exp.pop());
	}
	
	public static void fibonacci(int n) {
		Queue<Integer> q = new Queue<Integer>();
		q.offer(1);
		q.offer(1);
		for(int i = 0; i <= n-1;i++){
			int a = q.remove();
			int b = q.remove();
			System.out.println(a);
			q.offer(b);
			q.offer(a+b);
		}
		
			
	}
	
	public static void main(String[] args) {
		System.out.println("Testing balanced symbols");
		System.out.println(checkForBalance("t = arr[3] + a) - 4"));
		System.out.println(checkForBalance("if (arr(3] < 4)"));
		System.out.println(checkForBalance("System.out.println(std.charAt(3);"));
		System.out.println(checkForBalance("while (i > 100) { sum += i; i++; }"));
		System.out.println();
		
		System.out.println("Testing postfix evaluation");
		System.out.println("4 3 5 * + => " + postfixEval("4 3 5 * +"));
		System.out.println("1 2 * 3  4 / - => " + postfixEval("1 2 * 3 4 / -"));
		System.out.println("1 2 * 3 * 4 * 5 * 6 * => " + postfixEval("1 2 * 3 * 4 * 5 * 6 *"));
		System.out.println("1 2 3 * 4 + 5 / + => " + postfixEval("1 2 3 * 4 + 5 / +"));
		System.out.println("2 2 * 4 1 * 3 * - 2 1 * / => " + postfixEval("2 2 * 4 1 * 3 * - 2 1 * /"));
		System.out.println("3 8 + * 9 => " + postfixEval("3 8 + * 9"));
		System.out.println("9 8 + 7 => " + postfixEval("9 8 + 7"));
		System.out.println();
		
		System.out.println("Testing Fibonacci sequence");
		fibonacci(20);
		System.out.println();
		
		System.out.println("Testing the Printer class");
		Printer printer = new Printer();
		printer.printDocument("gato.jpg");
		printer.printDocument("tarea.docx");
		printer.printDocument("meme.png");
		try {
			printer.runPrinter();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}