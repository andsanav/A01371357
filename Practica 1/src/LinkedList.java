
public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get.
	 * @return the node at the specified position.
	 * @throws IndexOutOfBoundsException if the index is
	 */
	private Node<E> node(int index) {
		if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
		}
		
		if(index < (size >> 1)) {
			//Significa que el elemento está en la primera
			//mitad de la lista.
			//Recorrer la lista desde el inicio hacia adelante.
			Node<E> x = header.next;
			for(int i=0; i<index; i++)
				x = x.next;
			return x;
			
		} else {
			Node<E> x = header.prev;
			for(int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
			//Significa que el elemento está
			// en la segunda mitad de la lista.
			//Recorrer la lista del final hacia atrás.
		}
	}
	
	@Override
	public void addFirst(E e) {
		Node<E> newElement = new Node<E>(e);
		
		Node<E> firstElement = header.next;
		newElement.next = firstElement;
		firstElement.prev = newElement;
		
		newElement.prev = header;
		header.next = newElement;
		
		newElement.prev = header;
		header.next = newElement;
		
		size++;
		
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
		}
		Node<E> newNode = new Node<E>(element);
		Node<E> current = node(index);
		Node<E> previousNode = current.prev;
		
		
		
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
