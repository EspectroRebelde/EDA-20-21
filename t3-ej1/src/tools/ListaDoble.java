package tools;

public class ListaDoble {
	
	public NodoDoble primero;
	
	// Constructores
	
	/**
	 * Constructor de lista vac�a
	 */
	public ListaDoble() {
		primero = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaDoble(NodoDoble primero) {
		this.primero = primero;
	}
	
	/*
	 * Operaciones del TAD
	 * isEmpty(): Determina si la lista es vac�a
	 * insertHead(x): Inserta el elemento x al principio de la lista, ser� el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, ser� el �ltimo elemento.
	 * insertAtPosition(n,x): Inserta el elemento x en la posici�n n
	 * insertAfter(n,x): Inserta el elemento x en la posici�n n+1
	 * find(x): Devuelve la posici�n del elemento x
	 * remove(x): Elimina el elemento x
	 * previous(x): Devuelve el elemento anterior al elemento x 
	 * first(): Devuelve el primer elemento de la lista 
	 * last(): Devuelve el �ltimo elemento de la lista
	 * clear(): Vac�a la lista
	 * size(): Devuelve el tama�o de la lista
	 * */

}
