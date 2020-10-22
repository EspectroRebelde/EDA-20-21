package listas;

public class Lista {
	
	// primero --> 2 --> 3 --> 4 --> ... --> ultimo --> null
	// [valor] (enlace) --> [valor] (enlace)
	
	public Nodo primero;
	
	// Constructor lista vac�a (sin elementos)
	// null
	public Lista() {
		primero = null;		
	}
	
	// Constructor de lista con elemento
	public Lista(Nodo nodo) {
		primero = nodo;
	}
	
	/*
	 * Operaciones de la lista
	 * X isEmpty(): Determina si la lista es vac�a
	 * X insertHead(x): Inserta el elemento x al principio de la lista, ser� el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, ser� el �ltimo elemento.
	 * insertAtPosition(n,x): Inserta el elemento x en la posici�n n
	 * insertAfter(n,x): Inserta el elemento x en la posici�n n+1
	 * find(x): Devuelve la posici�n del elemento x
	 * remove(x): Elimina el elemento x
	 * previous(x): Devuelve el elemento anterior al elemento x 
	 * X first(): Devuelve el primer elemento de la lista 
	 * last(): Devuelve el �ltimo elemento de la lista
	 * X clear(): Vac�a la lista
	 * */
	
	public Nodo first() {
		return primero;
	}
	
	public void clear() {
		primero = null;
	}
	
	public boolean isEmpty() {
		if(primero != null) return false;
		else return true;
	}
	
	public void insertHead(Nodo nuevo) {
		// 23(primero) --> null
		// 154(nuevo)/(primero) --> 23 (nuevo.enlace) --> null
		nuevo.enlace = primero;
		primero = nuevo;
	}

}
