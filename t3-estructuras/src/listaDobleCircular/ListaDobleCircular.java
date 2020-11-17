package listaDobleCircular;

import nodos.NodoDoble;

public class ListaDobleCircular {

	public NodoDoble acceso;
	
	// Constructores
	
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
	 * Nota: eliminados first() y last(), no tienen sentido en una lista circular y podemos acceder directamente
	 * 		 a trav�s de las variables acceso y acceso.anterior
	 * 
	 * Nota: eliminado previous(), podemos acceder directamente a .anterior
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
	 * M�todo que inserta un nuevo nodo justo antes del nodo de acceso
	 * El nodo introducido ser� el nuevo nodo de acceso
	 * @param dato El elemento a insertar
	 */
	public void insert(Object dato) {
		NodoDoble nodo = new NodoDoble(acceso.anterior, dato, acceso);
		acceso.anterior.siguiente = nodo;
		acceso.anterior = nodo;
		acceso = nodo;
	}
	
	/**
	 * M�todo que inserta un nuevo nodo tras otro nodo con un dato concreto
	 * @param datoInsertar El dato a insertar
	 * @param datoReferencia El dato tras el cual se desea insertar el nuevo dato
	 * @throws Exception Lanza una excepci�n si no se encuentra el nodo de referencia
	 */
	public void insertAfter(Object datoInsertar, Object datoReferencia) throws Exception {

		NodoDoble nodoReferencia = find(datoReferencia);
		NodoDoble nodoInsertar = new NodoDoble(nodoReferencia, datoInsertar, nodoReferencia.siguiente);
		nodoReferencia.siguiente.anterior = nodoInsertar;
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
			NodoDoble last = acceso;
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
	public NodoDoble find(Object dato) throws Exception {
		
		NodoDoble actual = acceso;
		while(actual.dato != dato) {
			if(actual.siguiente == acceso) throw new Exception("Error: nodo no encontrado");
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
		
		if(acceso.dato == dato && acceso.siguiente == acceso) clear();
		else if(acceso.dato == dato) {
			acceso.anterior.siguiente = acceso.siguiente;
			acceso.siguiente.anterior = acceso.anterior;
			acceso = acceso.siguiente;
		} else {
			NodoDoble nodoEliminar = find(dato);
			nodoEliminar.anterior.siguiente = nodoEliminar.siguiente;
			nodoEliminar.siguiente.anterior = nodoEliminar.anterior;
		}

		System.gc();		
	}
	
}
