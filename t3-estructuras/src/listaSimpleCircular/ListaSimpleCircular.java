package listaSimpleCircular;

import nodos.Nodo;

public class ListaSimpleCircular {

	public Nodo acceso;
	
	// Constructores
	
	/**
	 * Constructor de lista vac�a
	 */
	public ListaSimpleCircular() {
		acceso = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaSimpleCircular(Nodo acceso) {
		this.acceso = acceso;
		this.acceso.siguiente = acceso;
	}
	
	/*
	 * Operaciones del TAD Lista
	 * isEmpty(): Determina si la lista est� vac�a
	 * insert(x): Inserta el elemento x entre el nodo anterior al nodo de acceso y el nodo de acceso actual, ser� el nuevo nodo de acceso
	 * insertAfter(x, y): Inserta el elemento x despu�s del nodo con dato y, ser� el nuevo nodo de acceso
	 * find(x): Devuelve el nodo con el elemento x
	 * remove(x): Elimina el nodo con elemento x
	 * previous(x): Devuelve el nodo anterior al nodo con elemento x 
	 * clear(): Vac�a la lista
	 * size(): Devuelve el tama�o de la lista
	 * 
	 * Nota: conservamos first() y last() para acceder de forma sencilla a los nodos de acceso y su anterior
 	 *       pero hay que tener en cuenta que ambos van a estar cambiando constantemente
	 * 
	 * Nota: insertHead(x), insertLast(x) no tienen sentido en una lista circular, sustituidos por insert(x);
	 * Nota: modificado insertAfter(x, n) con posici�n -> insertAfter(x, y) con dato; no tiene sentido controlar posici�n en una lista circular
	 * Nota: eliminado m�todo insertAtPosition(x, n) para evitar confusi�n y duplicidad innecesaria
	 * */
	
	/**
	 * M�todo que comprueba si la lista est� vac�a
	 * @return true si la lista est� vac�a, false si la lista tiene elementos
	 */
	public boolean isEmpty() {
		return acceso == null;		
	}
	
	/**
	 * M�todo que limpia la lista
	 */
	public void clear() {
		acceso = null;
		System.gc(); // Invoca al garbage collector de java, que limpia la memoria
	}
	
	/**
	 * M�todo que devuelve el nodo de acceso actual la lista
	 * @return El nodo de acceso de la lista
	 */
	public Nodo first() {
		
		// Devuelvo el nodo de acceso
		return acceso;
		
	}
	
	/**
	 * M�todo que devuelve el que es actualmente el �ltimo nodo de la lista
	 * @return El �ltimo nodo de la lista
	 */
	public Nodo last() {
		
		// Entro a trav�s del nodo de acceso
		Nodo last  = acceso;
		
		// Busco el �ltimo (nodo que apunta a null)
		while(last.siguiente != null) last = last.siguiente;
		
		// Devuelvo el �ltimo
		return last;
		
	}
	
	/**
	 * M�todo que inserta un nuevo nodo justo antes del nodo de acceso
	 * El nodo introducido ser� el nuevo nodo de acceso
	 * @param dato El elemento a insertar
	 */
	public void insert(Object dato) {
		Nodo nodo = new Nodo(dato, acceso);
		last().siguiente = nodo;
		acceso = nodo;
	}
	
	/**
	 * M�todo que inserta un nuevo nodo tras otro nodo con un dato concreto
	 * @param datoInsertar El dato a insertar
	 * @param datoReferencia El dato tras el cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepci�n si no se encuentra el nodo de referencia
	 */
	public void insertAfter(Object datoInsertar, Object datoReferencia) throws Exception {

		Nodo nodoReferencia = find(datoReferencia);
		Nodo nodoInsertar = new Nodo(datoInsertar, nodoReferencia.siguiente);
		nodoReferencia.siguiente = nodoInsertar;
		
	}
	
	/**
	 * M�todo que devuelve el n�mero de elementos en la lista
	 * @return El n�mero de elementos en la lista
	 */
	public int size() {
		
		if (isEmpty()) return 0;	
		else {
			int size = 1;
			Nodo last = acceso;
			while(last.siguiente != acceso){
				size++;
				last = last.siguiente;
			}
			return size;
		}
	}


	/**
	 * M�todo para buscar un nodo con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El nodo que contiene el dato concreto, null si no se encuentra el nodo
	 * @throws Exception En caso de no encontrar el nodo, lanza excepci�n
	 */
	public Nodo find(Object dato) throws Exception {
		
		Nodo actual = acceso;
		while(actual.dato != dato) {
			if(actual.siguiente == acceso) throw new Exception("Error: nodo no encontrado");
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
		
		if(acceso.dato == dato) return last();
		else {
			
			Nodo anterior = acceso;
			Nodo actual = acceso;
			
			while(actual.dato != dato) {
				if(actual.siguiente == acceso) throw new Exception("Error: nodo no encontrado");
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
		
		if(acceso.dato == dato && acceso.siguiente == acceso) clear();
		else if(acceso.dato == dato) {
			last().siguiente = acceso.siguiente;
			acceso = acceso.siguiente;
		} else {
			Nodo anterior = previous(dato);
			anterior.siguiente = anterior.siguiente.siguiente;
		}

		System.gc();		
	}
	
}
