package listas;

import nodos.NodoDoble;

public class ListaDoble {

	public NodoDoble primero;
	
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
	 * X isEmpty(): Determina si la lista est� vac�a
	 * X insertHead(x): Inserta el elemento x al principio de la lista, ser� el nuevo primer elemento.
	 * X insertLast(x): Inserta el elemento x al final de la lista, ser� el �ltimo elemento.
	 * X insertAfter(x, n): Inserta el elemento x despu�s de la posici�n n
	 * X find(x): Devuelve el nodo con el elemento x
	 * X remove(x): Elimina el nodo con el elemento x
	 * X first(): Devuelve el primer nodo de la lista 
	 * X last(): Devuelve el �ltimo nodo de la lista
	 * X clear(): Vac�a la lista
	 * X size(): Devuelve el tama�o de la lista
	 * 
	 * Nota: eliminado m�todo insertAtPosition(x, n) para evitar confusi�n y duplicidad innecesaria
	 * Nota: eliminado m�todo previous(x), ya que podemos acceder al anterior mediante .anterior
	 * 
	 **/
	
	/**
	 * M�todo que comprueba si la lista est� vac�a
	 * @return true si la lista est� vac�a, false si la lista tiene elementos
	 */
	public boolean isEmpty() {
		return primero == null;		
	}
	
	/**
	 * M�todo que limpia la lista
	 */
	public void clear() {
		primero = null;
		System.gc(); // Invoca al garbage collector de java, que limpia la memoria
	}
	
	/**
	 * M�todo para comprobar el primer NodoDoble de la lista
	 * @return El primer NodoDoble de la lista
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a
	 */
	public NodoDoble first() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else return primero;		
	}
		
	/**
	 * M�todo que devuelve el �ltimo NodoDoble de la lista
	 * @return El �ltimo NodoDoble de la lista
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a
	 */
	public NodoDoble last() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else {
			NodoDoble last  = primero;
			while(last.siguiente != null) last = last.siguiente;
			return last;
		}		
	}
	
	/**
	 * M�todo que devuelve el n�mero de elementos en la lista
	 * @return El n�mero de elementos en la lista
	 */
	public int size() {
		if (isEmpty()) return 0;	
		else {
			int size = 1;
			NodoDoble last = primero;
			while(last.siguiente != null){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}
	
	/**
	 * M�todo que inserta un nuevo NodoDoble al principio de la lista	
	 * @param dato El elemento a insertar
	 */
	public void insertHead(Object dato) {
		NodoDoble NodoDoble = new NodoDoble(null, dato, primero);
		primero = NodoDoble;
	}
	
	/**
	 * M�todo que inserta un nuevo NodoDoble al final de la lista
	 * @param dato El dato a insertar
	 */
	public void insertLast(Object dato) {
		if(isEmpty()) insertHead(dato); 
		else {
			NodoDoble last  = primero;
			while(last.siguiente != null) last = last.siguiente;
			last.siguiente = new NodoDoble(last, dato, null);
		}
	}	
	
	/**
	 * M�todo que inserta un nuevo NodoDoble tras una posici�n concreta
	 * Nota: se considera 0 como el �ndice de inicio, en otras palabras, la posici�n (6) har� referencia al 7� elemento de la lista:
	 * 		 (0) --> (1) --> (2) --> (3) --> (4) --> (5) --> {(6)}
	 * @param dato El dato a insertar
	 * @param position La posici�n tras la cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a o si la posici�n solicitada est� fuera de rango
	 */
	public void insertAfter(Object dato, int position) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else if (position < 0 || position >= size()) throw new Exception("Error: �ndice solicitado fuera de rango v�lido");
		else if (position == size()-1) insertLast(dato);
		else {
		
			// Creamos las variables auxiliares
			NodoDoble actual = primero;
	
			// Iteramos hasta llegar a la posici�n deseada (lista empieza en index 0)
			for (int i = 0; i < position; i++) actual = actual.siguiente;
	
			// Creamos el nuevo NodoDoble basado en el actual
			NodoDoble nuevo = new NodoDoble(actual, dato, actual.siguiente);
	
			// Actualizamos los enlaces
			actual.siguiente.anterior = nuevo;
			actual.siguiente = nuevo;

		}
	}
	
	/**
	 * M�todo para buscar un NodoDoble con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El NodoDoble que contiene el dato concreto, null si no se encuentra el NodoDoble
	 * @throws Exception En caso de estar la lista vac�a o no encontrar el NodoDoble, lanza excepci�n
	 */
	public NodoDoble find(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else {
			NodoDoble actual = primero;
			while(actual.dato != dato) {
				if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
				else actual = actual.siguiente;
			}
			return actual;
		}
		
	}
	
	/**
	 * M�todo para eliminar un NodoDoble con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de estar la lista vac�a o no encontrar el NodoDoble a eliminar, lanza excepci�n
	 */
	public void remove(Object dato) throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else if(primero.dato == dato && primero.siguiente == null) clear();
		else if(primero.dato == dato) {
			primero = primero.siguiente;
			primero.anterior = null;
		}
		else {
			NodoDoble eliminar = find(dato);
			eliminar.anterior.siguiente = eliminar.siguiente;
			eliminar.siguiente.anterior = eliminar.anterior;
		}
		System.gc();		
	}
	
	
}
