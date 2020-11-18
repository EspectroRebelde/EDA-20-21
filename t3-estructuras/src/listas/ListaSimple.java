package listas;

import nodos.Nodo;

public class ListaSimple {

	public Nodo primero;
	
	// Constructores
	
	/**
	 * Constructor de lista vac�a
	 */
	public ListaSimple() {
		primero = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaSimple(Nodo primero) {
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
	 * X previous(x): Devuelve el nodo anterior al nodo con el elemento x 
	 * X first(): Devuelve el primer elemento de la lista 
	 * X last(): Devuelve el �ltimo elemento de la lista
	 * X clear(): Vac�a la lista
	 * X size(): Devuelve el tama�o de la lista
	 * 
	 * Nota: eliminado m�todo insertAtPosition(x, n) para evitar confusi�n y duplicidad innecesaria
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
	 * M�todo para comprobar el primer nodo de la lista
	 * @return El primer nodo de la lista
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a
	 */
	public Nodo first() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else return primero;		
	}
		
	/**
	 * M�todo que devuelve el �ltimo nodo de la lista
	 * @return El �ltimo nodo de la lista
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a
	 */
	public Nodo last() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else {
			Nodo last  = primero;
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
			Nodo last = primero;
			while(last.siguiente != null){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}
	
	/**
	 * M�todo que inserta un nuevo nodo al principio de la lista	
	 * @param dato El elemento a insertar
	 */
	public void insertHead(Object dato) {
		Nodo nodo = new Nodo(dato, primero);
		primero = nodo;
	}
	
	/**
	 * M�todo que inserta un nuevo nodo al final de la lista
	 * @param dato El dato a insertar
	 */
	public void insertLast(Object dato) {
		if(isEmpty()) insertHead(dato); 
		else {
			Nodo last  = primero;
			while(last.siguiente != null) last = last.siguiente;
			last.siguiente = new Nodo(dato);
		}
	}	
	
	/**
	 * M�todo que inserta un nuevo nodo tras una posici�n concreta
	 * Nota: se considera 0 como el �ndice de inicio, en otras palabras, la posici�n (6) har� referencia al 7� elemento de la lista:
	 * 		 (0) --> (1) --> (2) --> (3) --> (4) --> (5) --> {(6)}
	 * @param dato El dato a insertar
	 * @param position La posici�n tras la cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a o si la posici�n solicitada est� fuera de rango
	 */
	public void insertAfter(Object dato, int position) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else if (position < 0 || position >= size()) throw new Exception("Error: �ndice solicitado fuera de rango v�lido");
		else {
		
			// Creamos las variables auxiliares
			Nodo actual = primero;
	
			// Iteramos hasta llegar a la posici�n deseada (lista empieza en index 0)
			for (int i = 0; i < position; i++) actual = actual.siguiente;
	
			// Creamos el nuevo nodo basado en el actual
			Nodo nuevo = new Nodo(dato, actual.siguiente);
	
			// Actualizamos el enlace
			actual.siguiente = nuevo;

		}
	}
	
	/**
	 * M�todo para buscar un nodo con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El nodo que contiene el dato concreto, null si no se encuentra el nodo
	 * @throws Exception En caso de estar la lista vac�a o no encontrar el nodo, lanza excepci�n
	 */
	public Nodo find(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else {
			Nodo actual = primero;
			while(actual.dato != dato) {
				if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
				else actual = actual.siguiente;
			}
			return actual;
		}
		
	}
	
	/**
	 * M�todo para eliminar un nodo con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de estar la lista vac�a o no encontrar el nodo a eliminar, lanza excepci�n
	 */
	public void remove(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else if(primero.dato == dato && primero.siguiente == null) clear();
		else if(primero.dato == dato) primero = primero.siguiente;
		else {
			Nodo anterior = previous(dato);
			Nodo eliminar = find(dato);
			anterior.siguiente = eliminar.siguiente;
		}
		System.gc();		
	}
	
	/**
	 * M�todo para buscar el nodo anterior a otro nodo con un dato concreto
	 * @param dato El dato cuyo anterior deseamos encontrar
	 * @return El nodo anterior al nodo que contiene el dato concreto
	 * @throws Exception En caso de estar la lista vac�a, solicitar el anterior al primero, o no encontrar el nodo, lanza excepci�n
	 */
	public Nodo previous(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else if(primero.dato == dato) throw new Exception("Error: el primero no tiene anterior en una lista simple");
		else {
			Nodo anterior = primero;
			Nodo actual = primero;
			
			while(actual.dato != dato) {
				if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
				else {
					anterior = actual;
					actual = actual.siguiente;
				}
			}
			return anterior;
		}		
	}
	

	
}
