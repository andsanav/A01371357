/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.NoSuchElementException;

/**
 *
 * @author Andrea
 */

public class SLinkedList<E> implements List<E> {

    private SNode<E> top;
    private int size;

    public SLinkedList() {
        top = new SNode<E>();
        size = 0;
    }

    @Override
    public void addFirst(E e) {
        SNode<E> newNode = new SNode<E>(e);
        newNode.next = top.next;
        top.next = newNode;
        size++;

    }

    @Override
    public void addLast(E e) {
        SNode<E> newNode = new SNode<E>(e);

        SNode<E> current = top;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;

    }

    @Override
    public void add(int index, E element) {
        SNode<E> newNode = new SNode<E>(element);
        SNode<E> current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (top.next == null) {
            throw new NoSuchElementException();
        }

        SNode<E> nodeToRemove = top.next;
        top.next = nodeToRemove.next;
        nodeToRemove.next = null;
        size--;
        return nodeToRemove.value;
    }

    @Override
    public E removeLast() {
        if (top.next == null) {
            throw new NoSuchElementException();
        }

        SNode<E> last = top;
        while (last.next.next != null) {
            last = last.next;
        }

        SNode<E> nodeToRemove = last.next;
        last.next = null;
        size--;
        return nodeToRemove.value;
    }

    @Override
    public E remove(int index) {
        SNode<E> current = top;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        SNode<E> removed = current.next;
        current.next = current.next.next;
        size--;
        return removed.value;
    }

    @Override
    public boolean remove(Object o) {
        SNode<E> current = top;
        if(o == null)
            for(SNode<E> x = top.next; x != null; x = x.next) {
				if(x.value == null) {
                                    size--;
                                    x.next = x.next.next;
                                    return true;
                                }
            }
        else { 
            for(SNode<E> x = top.next; x != null; x = x.next) {
                if(o.equals(x.value)) {
                    size--;
                    x.next = x.next.next;
                    return true;
                }
                   		
}
    }
        return false;
    }

    @Override
    public E getFirst() {
        if (top.next == null) {
            throw new NoSuchElementException();
        }

        return top.next.value;
    }

    @Override
    public E getLast() {
        if (top.next == null) {
            throw new NoSuchElementException();
        }

        SNode<E> current = top;
        while (current.next != null) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public E get(int index) {
        SNode<E> current = top;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public E set(int index, E element) {
        SNode<E> newNode = new SNode<E>(element);
        SNode<E> current = top;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        SNode<E> removed = current.next;
        current.next = newNode;

        return removed.value;
    }

    @Override
    public boolean contains(E e) {
        SNode<E> current = top;
        for (int i = 0; i < size(); i++) {
                current = current.next;
                if(e.equals(current.value))
                    return true;
            }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
		
		if(o == null) {
			for(SNode<E> x = top.next; x != null; x = x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}
		else {
			for(SNode<E> x = top.next; x != null; x = x.next) {
				if(o.equals(x.value))
					return index;
				index++;
			}
		}
		return -1;
}

    @Override
    public void clear() {
        top.next = null;
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
        Object[] array = new Object[size()];
        SNode<E> current = top.next;
        for (int i = 0; i < size(); i++) {
            array[i] = current.value;
        }
        return array;
    }

    public String toString() {
        if (top.next == null) {
            return "[]";
        }

        SNode<E> current = top.next;
        String returnValue = "[" + current.value;
        while (current.next != null) {
            current = current.next;
            returnValue += ", " + current.value;
        }

        returnValue += "]";
        return returnValue;
    }

}
