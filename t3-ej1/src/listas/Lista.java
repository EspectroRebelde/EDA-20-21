package listas;

import nodos.NodoLista;

public class Lista {

	public NodoLista primero;
	
	// Constructores
	
	/**
	 * Constructor de lista vac�a
	 */
	public Lista() {
		primero = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public Lista(NodoLista primero) {
		this.primero = primero;
	}
	
	/*
	 * Operaciones del TAD Lista
	 * X isEmpty(): Determina si la lista es vac�a
	 * X insertHead(x): Inserta el elemento x al principio de la lista, ser� el nuevo primer elemento.
	 * X insertLast(x): Inserta el elemento x al final de la lista, ser� el �ltimo elemento.
	 * X insertAtPosition(n,x): Inserta el elemento x en la posici�n n
	 * insertAfter(n,x): Inserta el elemento x en la posici�n n+1
	 * find(x): Devuelve la posici�n del elemento x
	 * remove(x): Elimina el elemento x
	 * previous(x): Devuelve el elemento anterior al elemento x 
	 * X first(): Devuelve el primer elemento de la lista 
	 * X last(): Devuelve el �ltimo elemento de la lista
	 * X clear(): Vac�a la lista
	 * X size(): Devuelve el tama�o de la lista
	 * */
	
	/**
	 * M�todo que comprueba si la lista est� vac�a
	 * @return true si la lista est� vac�a, false si la lista tiene elementos
	 */
	public boolean isEmpty() {
		if (primero.equals(null))return true;
		else return false;
		
	}
	
	public void clear() {
		this.primero = null;
	}
	
	public NodoLista first() {
		return this.primero;		
	}
	
	//insertHead(x): Inserta el elemento x al principio de la lista, ser� el nuevo primer elemento.
	
	public Lista insertHead(Object dato) {
		NodoLista nodo = new NodoLista(dato, this.primero);
		this.primero = nodo;
		return this;
	}
	
	// insertLast(x)
	
	public Lista insertLast(Object dato) {

		// 1 --> 2 --> 3 (aux) --> null
		//						4
		// 3 (aux) --> 4 (aux.enlace) --> null (aux.enlace.enlace)
		// 1 --> 2 --> 3 --> 4 --> null
		
		/*
		 *  Cojo el �ltimo nodo de la lista
		 *  NodoLista last  = last();
		 *	Cambio el enlace para que sea un nuevo nodo
		 *  El nuevo nodo tiene el dato y apunta a null
		 *  last.enlace = new NodoLista(dato);
		 */
		
		last().enlace = new NodoLista(dato);
		
		return this;
		
	}	
	
	// 1 --> 2 --> 3 --> 4 --> null
	// 0	 1	   2	 3
	// insertAfter(dato, 2)
	// 1 --> 2 --> 3 --> nuevo --> 4 --> null
	// 0 	 1     2       3       4
	// insertAtPosition(dato, 2)
	// 1 --> 2 --> nuevo --> 3 --> 4 --> null
	// 0     1       2       3     4
	
	
	
	public Lista insertAtPosition(Object dato, int position) {

		/*
		 * 1 --> 2 --> 3 --> null
		 * 0	 1	   2
		 * Queremos meter en la posici�n 2
		 * Resultado:
		 * 1 --> 2 --> nuevo --> 3 --> null
		 */

		/* Algoritmo err�neo
		 * 1 (aux) --> 2 --> 3 --> null
		 * Bucle hasta posici�n donde queremos meter el nuevo (pos 2)
		 * 1 --> 2 --> 3 (aux) --> null
		 *            nuevo (aux) --> 3 --> null
		 */

		/* Algoritmo
		 * 1 (aux) --> 2 --> 3 --> null
		 * Bucle hasta posici�n anterior hasta donde queremos meter el nuevo (pos 1)
		 * 1 --> 2 (aux) --> 3 --> null
		 * Guardamos 3 en una variable para poder apuntar
		 * 1 --> 2 (aux) --> 3 (siguiente) --> null
		 * Queremos que 2 apunte a nuevo y que nuevo apunte a 3
		 * 1 --> 2 (aux) --> nuevo (aux.enlace) --> 3 (siguiente) --> null
		 */

		//TODO: resolver position negativa, position 0, position > tama�o de lista
		if (position < 0 || position > size()) {
			System.out.println("Error, out of bounds");
		}
		else if (position == 0) {
			insertHead(dato);
		}
		else {
		
			// Creamos las variables auxiliares
			NodoLista aux = this.primero;
	
			// Iteramos hasta llegar a la posici�n anterior
			for (int i = 0; i < position-1; i++) {
				aux = aux.enlace;
			}
	
			// Guardamos el siguiente para poder usarlo como enlace
			NodoLista siguiente = aux.enlace;
	
			// Actualizamos el enlace
			aux.enlace = new NodoLista(dato, siguiente);

		}
		return this;
	}
	
	public int size() {
		
		if (isEmpty()) {
			return 0;	
		}
		else {
			int size = 1;
			NodoLista last  = this.primero;
			while(last.enlace != null){
				size++;
				last = last.enlace;
			}
			return size;
		}
	}


	public NodoLista last() {
		
		// Entro a trav�s del primero
		NodoLista last  = this.primero;
		
		// Busco el �ltimo (nodo que apunta a null)
		while(last.enlace != null) last = last.enlace;
		
		// Devuelvo el �ltimo
		return last;
		
	}
	
	/*
	 * Bonus
	 * printList(): imprime la lista por pantalla
	 * size(): devuelve el tama�o de la lista
	 */
}
