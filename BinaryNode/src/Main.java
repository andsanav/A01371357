
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = new BinaryNode(4);
		BinaryNode node1 = new BinaryNode(1);
		BinaryNode node2 = new BinaryNode(2);
		BinaryNode node3 = new BinaryNode(3);
		BinaryNode node4 = new BinaryNode(4);
		BinaryNode node5 = new BinaryNode(5);
		BinaryNode node6 = new BinaryNode(6);
		BinaryNode node7 = new BinaryNode(7);
		BinaryNode node8 = new BinaryNode(8);
		
		root.leftChild = node2;
		root.rightChild = node5;
		node2.leftChild = node1;
		node2.rightChild = node3;
		node5.rightChild = node7;
		node7.leftChild = node6;
		node7.rightChild = node8;
		//root.preorderTraversal();
		//root.inorderTraversal();
		//root.postorderTraversal();
		root.depthFirstTraversal();
	}

}
