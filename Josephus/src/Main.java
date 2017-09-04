
/**
 *
 * @author Andrea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> iList = new LinkedList<Integer>();
        
		
		for(int i = 40; i > 0; i--) {
			iList.addFirst(i);
		}
                System.out.println(iList);
                System.out.println("Prueba");
                System.out.println(iList.josephus(2));
    }
                
}

                
                
                
                
                

