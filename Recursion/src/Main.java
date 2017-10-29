
public class Main {
	
	public int factorial(int n) {
		  if(n==1)
		  return 1;
		  return n*factorial(n-1);
		}
	
	public int bunnyEars(int bunnies) {
		  if(bunnies == 0)
		  return 0;
		  return bunnyEars(bunnies-1)+2;
		}
	
	public int fibonacci(int n) {
		  if(n == 0)
		  return 0;
		  if(n == 1)
		  return 1;
		  return fibonacci(n-1)+fibonacci(n-2);
		}

	public int bunnyEars2(int bunnies) {
		  int ears=0;
		  if(bunnies == 0)
		  return 0;
		  if(bunnies%2 == 0)
		  ears = 3;
		  else if(bunnies%2 != 0)
		  ears = 2;
		  return bunnyEars2(bunnies-1) + ears;
		}

	public int triangle(int rows) {
		  if(rows == 0)
		  return 0;
		  return rows+triangle(rows-1);
		}
	
	public int sumDigits(int n) {
		  if(n < 9)
		  return n;
		  int num = n%10;
		  int m= n/10;
		  return num + sumDigits(m);
		  
		}
	
	public int count7(int n) {
		  int sum = 0;
		  if(n==7)
		  return 1;
		  else if(n < 9)
		  return 0;
		  int digit = n%10;
		  if(digit == 7)
		  sum = 1;
		  return sum + count7(n/10);
		  
		}
	
	public int count8(int n) {
		  if(n==8)
		  return 1;
		  else if(n < 8)
		  return 0;
		  int digit1 = n%10;
		  int m = n/10;
		  int digit2 = m%10;
		  int sum = 0;
		  if( ( digit1 == 8) && !( digit1 == 8 && digit2== 8 ) )
		  sum = 1;
		  else if(digit1 == 8 && digit2 == 8)
		  sum = 2;
		  return sum + count8(n/10);
		  
		}
	
	public int powerN(int base, int n) {
		  if(n==1)
			  return base;
		  return base*powerN(base, n-1);
		}
	
	public int countX(String str) {
	 	if(str.length() == 0)
			return 0;
		if(str.charAt(0) == 'x')
			return 1 + countX(str.substring(1));
	  return countX(str.substring(1));
	}
	
	public String changeXY(String str) {
		  if(str.length() < 1)
		  return str;
		  char ch = ' ';
		  if(str.charAt(0) == 'x')
		  ch = 'y';
		  else
		  ch = str.charAt(0);
		  return ch + changeXY(str.substring(1));
		}
	
	public boolean array6(int[] nums, int index) {
		if(index == nums.length)
			return false;
		if(nums[index] == 6)
			return true;
		return array6(nums, index+1);
		}
	
	public int array11(int[] nums, int index) {
		  if(index == nums.length)
			  return 0;
		  int sum = 0;
		  if(nums[index] == 11)
			  sum = 1;
		  return sum + array11(nums, index+1);
		  
		}







	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
