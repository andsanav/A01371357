import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class SBinaryNode {
	public String value;
	
	public SBinaryNode leftChild;
	public SBinaryNode rightChild;
	public SBinaryNode father;
	
	public SBinaryNode(String value){
		this.value = value;
		leftChild = null;
		rightChild = null;
	}

	public String answer(){
		Scanner sc = new Scanner(System.in);
		String ans = "";
		ans = sc.nextLine();
		return ans;
	}
	
	public void recorrido(){
		recorridoTransversal(this);
	}
	
	public boolean isLeft(){
		return(this.father.leftChild.equals(this));
	}
	
	public void newAnswer(SBinaryNode node){
		System.out.println("¿En qué animal habías pensado?");
		String animal = this.answer();
		SBinaryNode toAdd = new SBinaryNode(animal);
		System.out.println("¿Qué pregunta me ayudaría a diferenciar " + animal + " de " + node.value + "?");
		String pregunta = this.answer();
		SBinaryNode question = new SBinaryNode(pregunta);
		System.out.println("¿Qué respuesta me llevaría a " + animal + "?(S/N)");
		String ans = this.answer();
		if(node.isLeft()){
			node.father.leftChild = question;
		} else {
			node.father.rightChild = question;
		}
		question.father = node.father;
		if(ans.equals("S")){
			question.leftChild = toAdd;
			question.rightChild = node;
			}
		if(ans.equals("N")){
			question.leftChild = node;
			question.rightChild = toAdd;
			}
		node.father = question;
		toAdd.father = question;
		System.out.println("Tu respuesta ha sido agregada, ¿Quieres seguir jugando?");
		String res = this.answer();
		if(res.equals("S"))
			recorrido();
		} 
	
		public void depthFirst(SBinaryNode node) throws FileNotFoundException, UnsupportedEncodingException{
			PrintWriter out = new PrintWriter("Animales.txt", "UTF-8");
			if(node.leftChild != null || node.rightChild != null){
				if(node.leftChild!=null)
					out.println(node.leftChild.value);
					out.close();
				if(node.rightChild!=null)
					out.println(node.rightChild.value);
				if(node.leftChild!=null)
					depthFirst(node.leftChild);
				if(node.rightChild!=null)
					depthFirst(node.rightChild);
			} else
				return;
		}
		
	
	private void recorridoTransversal(SBinaryNode node){
		if(node.rightChild == null || node.leftChild == null){
			System.out.println("¿Pensaste en " + node.value + "?");
			String ans = this.answer();
			if(ans.equals("S"))
				return;
			if(ans.equals("N")){
				newAnswer(node);
				return;
			}
		}
		System.out.println(node.value);
		String ans = this.answer();
		if(ans.equals("S"))
			recorridoTransversal(node.leftChild);
		if(ans.equals("N"))
			recorridoTransversal(node.rightChild);
		
	
		}
	}

