package pilas;

public class PilaArray {

	public int size;
	public int[] datos;
	public int cima;
	
	/*
	 * X PilaArray(): Inicializa una pila vac�a
	 * X push(x): Inserta un elemento en la pila
	 * pop(): Extrae un elemento de la pila
	 * X isEmpty(): Comprobaci�n si la pila est� vac�a
	 * X isFull(): Comprobaci�n si la pila est� llena
	 * clear(): Vac�a la pila
	 * X peek(): Valor cima de la pila (sin extracci�n)
	 * X size(): N�mero de elementos en la pila
	 * X capacity(): Tama�o m�ximo de la pila
	 */
	
	public PilaArray(int size) {
		this.size = size;
		this.datos = new int[size];
		this.cima = -1;
	}
	
	public boolean isEmpty() {
		return cima == -1;
	}
	
	public boolean isFull() {
		return cima == this.size-1;
	}
	
	public int capacity() {
		return this.size;
	}
	public int size() {
		return this.cima+1;
	}
	public int peek() {
		return this.datos[cima];
	}
	
	public void push(int nuevoDato) {
		
		if(!this.isFull()) {
			this.datos[cima+1] = nuevoDato;
			cima++;
		} else {
			System.out.println("Stack overflow");
		}
		
	}
	
	public int pop() {
		int valor = peek();
		cima--;
		return valor;
	}
	
	public void clear() {
		cima = -1;
	}
	
}
