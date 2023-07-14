package ldlinkedlist;

import java.util.AbstractList;


public class LDLinkedList<E> extends AbstractList<E> {
	
	private static class Node<E>{
		private E data;
		private Node<E> next;
		private int lazydeleted=0;
		private Node(E data) {
			this.data = data;
			next = null;
			
		}	
		public void setLazy(int i) {
			lazydeleted = i;
		}
		public int getLazy() {
			return lazydeleted;
		}
	}

	private Node<E> head = null;
	private Node<E> iter = null;
	private int size = 0;
	private int lazydeletedcount=0;
	private int marked=-1;
	
	@Override
	public E get(int index) {
		
		Node<E> node = head;				//if index is zero, then return head
		
		for(int i=0; i< index; i++) {
			node = node.next;
		}
		return node.data;
		
	}

	@Override
	public int size() {
		return size;
	}

	public int isMarked() {
		if(marked == -1) {
			return -1;
		}
		else {
			return marked;
		}
	}
	
	/**
	 * Adding an element to the end of the LDLinkedlist
	 */
	@Override
	public boolean add(E item) {
		
		Node<E> node = new Node<>(item);
		
		if(size == 0) {
			//Node<E> node = new Node<>(item);
			head = node;
			
		}
		else {
			iter = head;
			while(iter.next!= null) {
				iter = iter.next;
			}
			iter.next = node;
			//Node<E> node = new Node<>(item);
			//iter = head;
			//iter.next = node;
			//iter = node;
		}
		
		size++;
		
		return true;
	}
	
	
	public void lazyRemove(int index) {
		
		int i = 0;
		int lazyindex = 0;
		iter = head;
		while(i<index) {
			iter = iter.next;
			i++;
		}
		
		iter.lazydeleted = 1;
		marked = index;
		
		int count = 0;
		count = this.lazyCount();
		//System.out.println("Lazy deleted num: "+count);
		
		if(count == 2) {
			iter = head;
			int j=0;
			for(int k=0; k<count; k++) {
				j=0;
				lazyindex = lazyIndex();
				
				if(lazyindex == 0) {
					head = head.next;
					marked = -1;
					size--;
				}
				else {
					iter = head;
					while(iter != null && j < lazyindex-1) {
						iter = iter.next;
						j++;
					}
					if(iter.next.next==null) {
						iter.next=null;
					}	
					else {
						iter.next = iter.next.next;
					}	
					marked = -1;
					size--;
				}
			}
			
		}
	}
	
	public int lazyIndex() {
		int in=0;
		int i=0;
		iter = head;
		while(iter != null) {
			if(iter.lazydeleted == 1) {
				in = i;
				break;
			}
			i++;
			iter = iter.next;
		}
		return in;
	}
	public int lazyCount() {
		
		int count = 0;
		iter = head;
		
		while(iter != null) {
			if(iter.lazydeleted==1) {
				count++;
			}
			iter = iter.next;
		}
		return count;
	}
	
	
}
