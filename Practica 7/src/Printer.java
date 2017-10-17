
public class Printer {
	private Queue<String> printerSpool;
	
	public Printer() {
		printerSpool = new Queue<String>();
	}
	
	public void printDocument(String name) {
		printerSpool.offer(name);
	}
	
	public void runPrinter() throws InterruptedException {
		boolean estado = false;
		while(!printerSpool.isEmpty()){
			if(!estado){
				System.out.println("Printing " + printerSpool.remove());
				estado = true;
				Thread.sleep(5000);
			}
			else{
				throw new InterruptedException();
			}
			estado = false;
			
		
		}
		System.out.println("Finished printing documents");
			
	}
}
