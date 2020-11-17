package listaDoble;

import nodos.NodoDoble;

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
	 * Operaciones del TAD ListaDoble
	 * isEmpty(): Determina si la lista est� vac�a
	 * insertHead(x): Inserta el elemento x al principio de la lista, ser� el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, ser� el �ltimo elemento.
	 * insertAfter(x, n): Inserta el elemento x despu�s de la posici�n n
	 * find(x): Devuelve el nodo con el elemento x
	 * remove(x): Elimina el nodo con el elemento x
	 * first(): Devuelve el primer nodo de la lista 
	 * last(): Devuelve el �ltimo nodo de la lista
	 * clear(): Vac�a la lista
	 * size(): Devuelve el tama�o de la lista
	 * 
	 * Nota: eliminado m�todo insertAtPosition(x, n) para evitar confusi�n y duplicidad
	 * Nota: eliminado m�todo previous(dato) ya que podemos acceder directamente a find(dato).anterior
	 * */
	
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
	 * M�todo para comprobar el primer nodo de la lista
	 * @return El primer nodo de la lista
	 */
	public NodoDoble first() {
		return primero;		
	}
	
	
	/**
	 * M�todo que inserta un nuevo nodo al principio de la lista	
	 * @param dato El elemento a insertar
	 */
	public void insertHead(Object dato) {
		NodoDoble nodo = new NodoDoble(null, dato, primero);
		primero = nodo;
	}
	
	/**
	 * M�todo que inserta un nuevo nodo al final de la lista
	 * @param dato El dato a insertar
	 */
	public void insertLast(Object dato) {
		NodoDoble last = last();
		last.siguiente = new NodoDoble(last, dato, null);
	}	
	
	/**
	 * M�todo que inserta un nuevo nodo tras una posici�n concreta
	 * @param dato El dato a insertar
	 * @param position La posici�n tras la cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepci�n si la posici�n solicitada est� fuera de rango
	 */
	public void insertAfter(Object dato, int position) throws Exception {

		if (position < 0 || position >= size()) throw new Exception("Error: �ndice solicitado fuera de rango v�lido");
		else if (position == 0)	insertHead(dato);
		else {
		
			// Creamos las variables auxiliares
			NodoDoble actual = primero;
	
			// Iteramos hasta llegar a la posici�n deseada (lista empieza en index 0)
			for (int i = 0; i < position; i++) actual = actual.siguiente;
	
			// Creamos el nuevo nodo basado en el actual
			NodoDoble nuevo = new NodoDoble(actual, dato, actual.siguiente);
	
			// Actualizamos los enlaces
			actual.siguiente.anterior = nuevo;
			actual.siguiente = nuevo;

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
			NodoDoble last  = primero;
			while(last.siguiente != null){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}


	/**
	 * M�todo que devuelve el �ltimo nodo de la lista
	 * @return El �ltimo nodo de la lista
	 */
	public NodoDoble last() {
		
		// Entro a trav�s del primero
		NodoDoble last  = primero;
		
		// Busco el �ltimo (nodo que apunta a null)
		while(last.siguiente != null) last = last.siguiente;
		
		// Devuelvo el �ltimo
		return last;
		
	}
	
	/**
	 * M�todo para buscar un nodo con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El nodo que contiene el dato concreto, null si no se encuentra el nodo
	 * @throws Exception En caso de no encontrar el nodo, lanza excepci�n
	 */
	public NodoDoble find(Object dato) throws Exception {
		
		NodoDoble actual = primero;
		while(actual.dato != dato) {
			if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
			else actual = actual.siguiente;
		}
		return actual;
		
	}
	
	/**
	 * M�todo para eliminar un nodo con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de no encontrar el nodo, lanza excepci�n
	 */
	public void remove(Object dato) throws Exception {
		
		if(primero.dato == dato) {
			primero = primero.siguiente;
			primero.anterior = null;
		} else {
			NodoDoble nodo = find(dato);
			nodo.siguiente.anterior = nodo.anterior;
			nodo.anterior.siguiente = nodo.siguiente;

		}
		System.gc();
		
	}
	
}
