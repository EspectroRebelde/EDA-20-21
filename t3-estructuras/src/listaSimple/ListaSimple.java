package listaSimple;

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
	 * Operaciones del TAD Lista
	 * isEmpty(): Determina si la lista est� vac�a
	 * insertHead(x): Inserta el elemento x al principio de la lista, ser� el nuevo primer elemento.
	 * insertLast(x): Inserta el elemento x al final de la lista, ser� el �ltimo elemento.
	 * insertAfter(x, n): Inserta el elemento x despu�s de la posici�n n
	 * find(x): Devuelve el nodo con el elemento x
	 * remove(x): Elimina el nodo con el elemento x
	 * previous(x): Devuelve el nodo anterior al nodo con el elemento x 
	 * first(): Devuelve el primer elemento de la lista 
	 * last(): Devuelve el �ltimo elemento de la lista
	 * clear(): Vac�a la lista
	 * size(): Devuelve el tama�o de la lista
	 * 
	 * Nota: eliminado m�todo insertAtPosition(x, n) para evitar confusi�n y duplicidad innecesaria
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
	public Nodo first() {
		return primero;		
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
		last().siguiente = new Nodo(dato);
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
	 * M�todo que devuelve el n�mero de elementos en la lista
	 * @return El n�mero de elementos en la lista
	 */
	public int size() {
		
		if (isEmpty()) return 0;	
		else {
			int size = 1;
			Nodo last  = primero;
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
	public Nodo last() {
		
		// Entro a trav�s del primero
		Nodo last  = primero;
		
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
	public Nodo find(Object dato) throws Exception {
		
		Nodo actual = primero;
		while(actual.dato != dato) {
			if(actual.siguiente == null) throw new Exception("Error: nodo no encontrado");
			else actual = actual.siguiente;
		}
		return actual;
		
	}
	
	/**
	 * M�todo para buscar el nodo anterior a otro nodo con un dato concreto
	 * @param dato El dato cuyo anterior deseamos encontrar
	 * @return El nodo anterior al nodo que contiene el dato concreto
	 * @throws Exception En caso de no encontrar el nodo, lanza excepci�n
	 */
	public Nodo previous(Object dato) throws Exception {
		
		if(primero.dato == dato) throw new Exception("Error: el primero no tiene anterior");
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
	
	/**
	 * M�todo para eliminar un nodo con un dato concreto
	 * @param dato El dato a eliminar
	 * @throws Exception En caso de no encontrar el nodo, lanza excepci�n
	 */
	public void remove(Object dato) throws Exception {
		
		if(primero.dato == dato) {
			primero = primero.siguiente;
		} else {
			Nodo anterior = previous(dato);
			anterior.siguiente = anterior.siguiente.siguiente;
		}

		System.gc();		
	}
	
}
