
public class BinaryNode {
	public int value;
	
	public BinaryNode leftChild;
	public BinaryNode rightChild;
	
	public BinaryNode(int value){
		this.value = value;
		leftChild = null;
		rightChild = null;
	}
	
	public void preorderTraversal(){
		preorder(this);
	}
	
	public void inorderTraversal(){
		inorder(this);
	}
	
	public void postorderTraversal(){
		postorder(this);
	}
	
	public void depthFirstTraversal(){
		System.out.println(this.value);
		depthFirst(this);
	}
	
	private void preorder(BinaryNode node){
		if(node.leftChild != null || node.rightChild != null){
			System.out.println(node.value);
			if(node.leftChild!=null)
				preorder(node.leftChild);
			if(node.rightChild!=null)
				preorder(node.rightChild);
		}
		else
			System.out.println(node.value);
			
		
	}
	
	private void inorder(BinaryNode node){
		if(node.leftChild != null || node.rightChild != null){
			if(node.leftChild!=null){
				inorder(node.leftChild);
			}
			System.out.println(node.value);
			if(node.rightChild!=null)
				inorder(node.rightChild);
		}
		else
			System.out.println(node.value);
			
		
	}
	
	private void postorder(BinaryNode node){
		if(node.leftChild != null || node.rightChild != null){
			if(node.leftChild!=null)
				postorder(node.leftChild);
			if(node.rightChild!=null)
				postorder(node.rightChild);
			System.out.println(node.value);
		}
		else
			System.out.println(node.value);
			
		
	}
	
	private void depthFirst(BinaryNode node){
		if(node.leftChild != null || node.rightChild != null){
			if(node.leftChild!=null)
				System.out.println(node.leftChild.value);
			if(node.rightChild!=null)
				System.out.println(node.rightChild.value);
			if(node.leftChild!=null)
				depthFirst(node.leftChild);
			if(node.rightChild!=null)
				depthFirst(node.rightChild);
		} else
			return;
	}

}
