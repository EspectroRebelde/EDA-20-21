package colas;

public class ColaPrioridad {
	
	public ColaEnlazada[] colas;
	
	public ColaPrioridad(int numPrioridades) {
		colas = new ColaEnlazada[numPrioridades];
		for(int i = 0; i < numPrioridades; i++) {
			colas[i] = new ColaEnlazada();
		}
	}
	
	/*
	 * X ColaPrioridad(): Inicializa una cola de prioridad vac�a
	 * X push(x, i): Inserta un elemento x al final de la cola con prioridad i
	 * X pop(): Extrae un elemento del principio de la primera cola no vac�a
	 * X isEmpty(): Comprobaci�n colas vac�as
	 * X clear(): Vac�a todas las colas
	 * X size(): N�mero de elementos en todas las colas
	 */
	
	public boolean isEmpty() {
		
		for(ColaEnlazada cola : colas) {
			if(!cola.isEmpty()) return false;
		}
		
		return true;
		
	}
	
	public void clear() {
		for(ColaEnlazada cola : colas) {
			cola.clear();
		}
	}
	
	public int size() {
		int size = 0;
		for(ColaEnlazada cola : colas) {
			size += cola.size;
		}
		return size;
	}
	
	// Inserta un elemento x al final de la cola con prioridad i
	public void push(Object elemento, int prioridad) {
		colas[prioridad].push(elemento);
	}
	
	// Extrae un elemento del principio de la primera cola no vac�a
	public Object pop() throws Exception {

		for(ColaEnlazada cola : colas){
			if(!cola.isEmpty()) return cola.pop();
		}

		// Podr�a ser que todas las colas est�n vac�as, en ese caso llegaremos a este c�digo
		System.out.println("Error: todas las colas est�n vac�as");
		return null;
	}

}