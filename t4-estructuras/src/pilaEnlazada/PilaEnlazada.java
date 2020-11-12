package pilaEnlazada;

import nodo.Nodo;

public class PilaEnlazada {
	
	public Nodo cima;
	
	/**
	 * Constructor de pila enlazada vac�a
	 */
	public PilaEnlazada()
	{
		cima = null;
	}
	
	
	/*
	 * X PilaEnlazada(): Inicializa una pila vac�a
	 * X push(x): Inserta un elemento en la pila
	 * X pop(): Extrae un elemento de la pila
	 * X isEmpty(): Comprobaci�n pila vac�a
	 * X clear(): Vac�a la pila
	 * X peek(): Valor cima de la pila (sin extracci�n)
	 * X size(): N�mero de elementos en la pila
	 */
	
	/* 
	 * Operaciones push/pop/peek usan directamente la referencia cima.
	 * Es decir, no es necesario recorrer los nodos.
	 */
	
	/**
	 * M�todo que comprueba si la pila est� vac�a
	 * Para ello, comprueba si la cima es null
	 * @return true si la pila est� vac�a, false si tiene elementos
	 */
	public boolean isEmpty()
	{
		return cima==null;
	}
	
	/**
	 * M�todo que inserta un elemento en la pila, para ello:
	 * - Crea un nuevo nodo a partir del elemento a insertar
	 * - Inserta el elemento en la cima 
	 * - Cambia la cima
	 * @param elemento El elemento que se desea insertar
	 */
	public void push(Object elemento)
	{
		Nodo nuevo=new Nodo(elemento);
		nuevo.siguiente=cima;
		cima=nuevo;
	}
	
	/**
	 * M�todo que saca un elemento de la pila, para ello:
	 * - Guarda el elemento en la cima en una variable auxiliar,
	 * - Cambia la cima
	 * - Devuelve el elemento guardado en la variable auxiliar
	 * @return Devuelve el elemento en la cima de la pila
	 * @throws Exception Lanza una excepci�n si la pila est� vac�a
	 */
	public Object pop() throws Exception
	{
		if(isEmpty()) throw new Exception("Pila vac�a, no se puede extraer.");
		
		Object aux=cima.elemento;
		cima=cima.siguiente;
		return aux;
	}
	
	/**
	 * M�todo que permite observar el elemento en la cima de la pila (sin extracci�n)
	 * @return Devuelve el elemento en la cima de la pila
	 * @throws Exception Lanza una excepci�n
	 */
	public Object peek() throws Exception
	{
		if(isEmpty()) throw new Exception("Pila vac�a, no se puede leer la cima.");
		return cima.elemento;
	}
	
	/**
	 * M�todo que vac�a una pila
	 * Para ello, cambia la cima a null
	 */
	public void clear()
	{
		cima = null;
	}
	
	/**
	 * M�todo que calcula el tama�o de una pila (n�mero de elementos en la pila), para ello:
	 * - Si la pila est� vac�a, devuelve 0
	 * - En caso contrario:
	 * 		. Accede a la pila mediante la cima
	 * 		. Crea un entero size = 1
	 * 		. Recorre la pila hasta hasta llegar al �ltimo, incrementando size
	 * 		. Devuelve size
	 * @return
	 */
	public int size()
	{
		if(isEmpty()) return 0;
		else {			
			Nodo t = cima;
			int size = 1;
			while(t.siguiente != null)
			{
				t = t.siguiente;
				size++;
			}
			return size;
		}
	}

}
