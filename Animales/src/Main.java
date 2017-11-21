import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		SBinaryNode root = new SBinaryNode("¿Es mamífero?");
		SBinaryNode uno = new SBinaryNode("¿Ladra?");
		SBinaryNode dos = new SBinaryNode("¿Tiene escamas?");
		SBinaryNode tres = new SBinaryNode("Perro");
		SBinaryNode cuatro = new SBinaryNode("¿Tiene cuello largo?");
		SBinaryNode cinco = new SBinaryNode("¿Respira agua?");
		SBinaryNode seis = new SBinaryNode("Pájaro");
		SBinaryNode siete = new SBinaryNode("Jirafa");
		SBinaryNode ocho = new SBinaryNode("Gato");
		SBinaryNode nueve = new SBinaryNode("Pez");
		SBinaryNode diez = new SBinaryNode("Serpiente");
		
		root.leftChild = uno;
		uno.father = root;
		root.rightChild = dos;
		dos.father = root;
		uno.leftChild = tres;
		tres.father = uno;
		uno.rightChild = cuatro;
		cuatro.father = uno;
		dos.leftChild = cinco;
		cinco.father = dos;
		dos.rightChild = seis;
		seis.father = dos;
		cuatro.leftChild = siete;
		siete.father = cuatro;
		cuatro.rightChild = ocho;
		ocho.father = cuatro;
		cinco.leftChild = nueve;
		nueve.father = cinco;
		cinco.rightChild = diez;
		diez.father = cinco;
		
		root.recorrido();
	}

}
