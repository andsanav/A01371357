/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.NoSuchElementException;

/**
 *
 * @author Andrea
 */
	public class LinkedList<E> implements List<E> {
	protected Node<E> header;
	protected int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get.
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index){
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index < (size >> 1)) {
			Node<E> x = header.next;
			for(int i=0; i<index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = header.prev;
			for(int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
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
		
		size++;
	}

	@Override
	public void addLast(E e) {
		Node<E> newElement = new Node<E>(e);
		
		Node<E> lastElement = header.prev;
		newElement.prev = lastElement;
		lastElement.next = newElement;
		
		newElement.next = header;
		header.prev = newElement;
		
		size++;
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index == size()) {
			addLast(element);
		} else {
			Node<E> newNode = new Node<E>(element);
			
			Node<E> current = node(index);
			Node<E> previousNode = current.prev;
			newNode.prev = previousNode;
			previousNode.next = newNode;
			
			newNode.next = current;
			current.prev = newNode;
			
			size++;
		}
	}

	@Override
	public E removeFirst() {
		if(header.next == header) {
			throw new NoSuchElementException();
		}
		
		Node<E> nodeToRemove = header.next;
		Node<E> nextNode = nodeToRemove.next;
		
		header.next = nextNode;
		nextNode.prev = header;
		
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
		
		size--;
		
		return nodeToRemove.value;
	}

	@Override
	public E removeLast() {
		if(header.next == header) {
			throw new NoSuchElementException();
		}
		
		Node<E> nodeToRemove = header.prev;
		Node<E> previousNode = nodeToRemove.prev;
		
		previousNode.next = header;
		header.prev = previousNode;
		
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
		
		size--;
		
		return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> nodeToRemove = node(index);
		Node<E> previousNode = nodeToRemove.prev;
		Node<E> nextNode = nodeToRemove.next;
                Node<E> firstNode = header.next;
                Node<E> lastNode = header.prev;
                
                if(index!=size -1){
                header.next = nextNode;
                header.prev = previousNode;
                previousNode.next = header;
		nextNode.prev = header;
                lastNode.next = firstNode;
                firstNode.prev = lastNode;
                
		
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
                }
                
                else{
                    previousNode.next = header;
                    header.prev = previousNode;
                }
                size--;
                return nodeToRemove.value;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		
		if(index >= 0 && index < size()) {
			remove(index);
			return true;
		}
		
		return false;
	}

	@Override
	public E getFirst() {
		if(header.next == header) {
			throw new NoSuchElementException();
		}
		
		return header.next.value;
	}

	@Override
	public E getLast() {
		if(header.next == header) {
			throw new NoSuchElementException();
		}
		
		return header.prev.value;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> nodeToReturn = node(index);
		
		return nodeToReturn.value;
	}

	@Override
	public E set(int index, E element) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> nodeToSet = node(index);
		E currentValue = nodeToSet.value;
		nodeToSet.value = element;
		
		return currentValue;
	}

	@Override
	public boolean contains(E e) {
		int index = indexOf(e);
		
		if(index >= 0 && index < size()) {
			return true;
		}
		
		return false;
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		
		if(o == null) {
			for (Node<E> x = header.next; x != header; x = x.next) {
                if (x.value == null)
                    return index;
                index++;
            }
		} else {
			for (Node<E> x = header.next; x != header; x = x.next) {
	            if (o.equals(x.value))
	                return index;
	            index++;
	        }
		}
		
		return -1;
	}

	@Override
	public void clear() {
		header.next = header;
		header.prev = header;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Object[] toArray() {
		Object[] returnArray = new Object[size];
		
		int i = 0;
		for(Node<E> x = header.next; x != header; x = x.next)
			returnArray[i++] = x.value;
		
		return returnArray;
	}
        
        public int goOver(int index){
            if(header.next == header) {
			throw new NoSuchElementException();
            }
            Node<E> current = header.next;
            for(int i = 0; i < index; i++){
                    if(current.next == header){
                        current = header.next;
                    }
                    else{
                        current = current.next;
                    }
            }
            return this.indexOf(current.value);
        }
        
         public E josephus(int steps){
             while(this.size() > 1){
                int index2 = this.goOver(steps);
                if(index2 == 0) {
                    this.removeFirst();
                } else if (index2 == this.size-1) {
                    this.removeLast();
                } else {
                    this.remove(index2);
                }
                
                }
             return this.getFirst();
         }

	@Override
	public String toString() {
		if(header.next == header) {
			return "[]";
		}
		
		Node<E> current = header.next;
		String str = "[" + current.value;
		while(current.next != header) {
			current = current.next;
			str += ", " + current.value;
		}
		str += "]";
		
		return str;
	}
        }
        
       

