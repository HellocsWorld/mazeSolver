package p2;

/**************************
 * Raul A Serrano
 * 916615562
 * rserran2@mail.sfsu.edu
 **************************/

public class LinkedStack<T> implements StackInterface<T> {
	  private Node<T> top;

	  public LinkedStack() {
	    this.top = null;
	  }

	  public void push( T entry ) {
	    Node<T> temp = new Node<T>( entry );

	    temp.next = top;

	    top = temp;

	    // top = new Node<T>( entry, top );
	  }

	  public T pop() {
	    if( isEmpty() ) {
	      return null;
	    }

	    Node<T> temp = top;

	    top = temp.next;

	    return temp.data;
	  }

	  public T peek() {
	    if( isEmpty() ) {
	      return null;
	    }

	    return this.top.data;
	  }

	  public boolean isEmpty() {
	    return this.top == null;
	  }

	  public void clear() {
	    this.top = null;
	  }

     public class Node<T> {
	  public T data;
	  public Node<T> next;

	  public Node( T entry ) {
	    this( entry, null );
	  }

	  public Node( T entry, Node<T> next ) {
	    this.data = entry;
	    this.next = next;
	  }
     }
}

