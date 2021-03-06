package estructuras;

public class PilaArray {
	
	public int cima;
	public int size;
	public int[] datos;
	
	/*
	 * X PilaArray(): Inicializa una pila vac�a
	 * x push(x): Inserta un elemento en la pila
	 * pop(): Extrae un elemento de la pila
	 * X isEmpty(): Comprobaci�n si la pila est� vac�a
	 * X isFull(): Comprobaci�n si la pila est� llena
	 * X clear(): Vac�a la pila
	 * X peek(): Valor cima de la pila (sin extracci�n)
	 * X size(): N�mero de elementos en la pila
	 * X capacity(): Tama�o m�ximo de la pila
	 */
	
	public PilaArray(int size) {
		this.size = size;
		this.cima = -1;
		this.datos = new int[size];
	}
	
	// isEmpty(): Comprobaci�n si la pila est� vac�a
	
	public boolean isEmpty() {
		return this.cima==-1;
	}
	
	// isFull(): Comprobaci�n si la pila est� llena
	
	public boolean isFull() {
		return this.cima==this.size-1;
	}
	
	// size(): N�mero de elementos en la pila
	
	public int size() {
		return this.cima+1;
	}
	
	// capacity(): Tama�o m�ximo de la pila
	
	public int capacity() {
		return this.size;
	}
	
	// clear(): Vac�a la pila
	
	public void clear() {
		
		this.cima = -1;
	}
	
	// peek(): Valor cima de la pila (sin extracci�n)
	
	public int peek() throws Exception
	{
		if (!isEmpty()) {
			return this.datos[this.cima];
		} else throw new Exception("Error: pila vac�a");
	}
	
	// push(x): Inserta un elemento en la pila
	public void push(int dato) {
		if(!isFull()) {
			this.cima++;
			this.datos[this.cima]=dato;
		}else System.out.println("esta llena la pila");
	}
	
	//pop(): Extrae un elemento de la pila
	public int pop() throws Exception {
		if(!isEmpty()) {
			int valor = datos[cima];
			cima--;
			return valor;
		}else throw new Exception("Error: pila vac�a");
	}
	
	
	
}
