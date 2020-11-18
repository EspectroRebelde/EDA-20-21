package listas;

import nodos.NodoDoble;

public class ListaDobleCircular {

	public NodoDoble acceso;
	
	/**
	 * Constructor de lista vac�a
	 */
	public ListaDobleCircular() {
		acceso = null;
	}
	
	/**
	 * Constructor con un elemento
	 * @param primero
	 */
	public ListaDobleCircular(NodoDoble acceso) {
		this.acceso = acceso;
		this.acceso.siguiente = acceso;
		this.acceso.anterior = acceso;
	}
	
	/*
	 * Operaciones del TAD
	 * X isEmpty(): Determina si la lista est� vac�a
	 * insert(x): Inserta el elemento x entre el nodo anterior al nodo de acceso y el nodo de acceso actual, ser� el nuevo nodo de acceso
	 * insertAfter(x, y): Inserta el elemento x despu�s del nodo con dato y, ser� el nuevo nodo de acceso
	 * X find(x): Devuelve el nodo con el elemento x
	 * X remove(x): Elimina el nodo con elemento x 
	 * X clear(): Vac�a la lista
	 * X size(): Devuelve el tama�o de la lista
	 * 
	 * Nota: conservamos first() y last() para acceder de forma sencilla a los nodos de acceso y su anterior
 	 *       pero hay que tener en cuenta que ambos van a estar cambiando constantemente
	 *
	 * Nota: eliminado previous(), podemos acceder directamente a .anterior
	 * 
	 * Nota: insertHead(x), insertLast(x) no tienen sentido en una lista circular, sustituidos por insert(x);
	 * Nota: modificado insertAfter(x, n) con posici�n -> insertAfter(x, y) con dato; no tiene sentido controlar posici�n en una lista circular
	 * Nota: eliminado m�todo insertAtPosition(x, n) para evitar confusi�n y duplicidad innecesaria
	 * 
	 **/
	
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
	 * M�todo para comprobar el primer nodo de la lista
	 * @return El primer nodo de la lista
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a
	 */
	public NodoDoble first() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else return acceso;		
	}
		
	/**
	 * M�todo que devuelve el �ltimo nodo de la lista
	 * @return El �ltimo nodo de la lista
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a
	 */
	public NodoDoble last() throws Exception {
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else return acceso.anterior;
	}
	
	/**
	 * M�todo que devuelve el n�mero de elementos en la lista
	 * @return El n�mero de elementos en la lista
	 */
	public int size() {
		if (isEmpty()) return 0;	
		else {
			int size = 1;
			NodoDoble last = acceso;
			while(last.siguiente != acceso){
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
	public void insert(Object dato) {
		if(isEmpty()) {
			acceso = new NodoDoble(dato);
			acceso.siguiente = acceso;
			acceso.anterior = acceso;
		} else {
			NodoDoble nodo = new NodoDoble(acceso.anterior, dato, acceso);
			acceso.anterior.siguiente = nodo;
			acceso.anterior = nodo;
			acceso = nodo;
		}
	}
	
	/**
	 * M�todo que inserta un nuevo nodo tras otro nodo con un dato concreto
	 * @param dato El dato a insertar
	 * @param referencia El dato de referencia tras el cual se desea insertar un nuevo nodo
	 * @throws Exception Lanza una excepci�n si la lista est� vac�a o si no se encuentra el dato de referencia
	 */
	public void insertAfter(Object dato, Object datoReferencia) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else {
		
			NodoDoble nodoReferencia = find(datoReferencia);
			NodoDoble nuevo = new NodoDoble(nodoReferencia, dato, nodoReferencia.siguiente);
			nodoReferencia.siguiente.anterior = nuevo;
			nodoReferencia.siguiente = nuevo;

		}
	}
	
	/**
	 * M�todo para buscar un nodo con un dato concreto
	 * @param dato El dato a encontrar
	 * @return El nodo que contiene el dato concreto
	 * @throws Exception En caso de estar la lista vac�a o no encontrar el nodo, lanza excepci�n
	 */
	public NodoDoble find(Object dato) throws Exception {
		
		if(isEmpty()) throw new Exception("Error: lista vac�a");
		else {
			NodoDoble actual = acceso;
			while(actual.dato != dato) {
				if(actual.siguiente == acceso) throw new Exception("Error: nodo no encontrado");
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
		else if(acceso.dato == dato && acceso.siguiente == acceso) clear();
		else if(acceso.dato == dato) {
			acceso.anterior.siguiente = acceso.siguiente;
			acceso.siguiente.anterior = acceso.anterior;
			acceso = acceso.siguiente;
		}
		else {
			NodoDoble eliminar = find(dato);
			eliminar.anterior.siguiente = eliminar.siguiente;
			eliminar.siguiente.anterior = eliminar.anterior;
		}
		System.gc();		
	}
	
	
}
