package colas;

import nodo.Nodo;

public class ColaEnlazada {

	public Nodo frente;
	public Nodo fin;
	
	public int size;
	
	/**
	 * Constructor de cola vac�a
	 */
	public ColaEnlazada()
	{
		frente=null;
		fin=null;
		size = 0;
	}
	
	/*
	 * X ColaEnlazada(): Inicializa una cola vac�a
	 * X push(x): Inserta un elemento al final de la cola
	 * X pop(): Extrae un elemento del principio de la cola
	 * X isEmpty(): Comprobaci�n cola vac�a
	 * X clear(): Vac�a la cola
	 * X front(): Valor frente de la cola (sin extracci�n)
	 * X end(): Valor final de la cola (sin extracci�n)
	 * X size(): N�mero de elementos en la cola
	 */
	
	public void push(Object elemento)
	{
		Nodo a=new Nodo(elemento);
		if(isEmpty())
		{
			frente=a;
		}
		else
		{
			fin.siguiente=a;
		}
		fin=a;
		size++;
	}

	/**
	 * M�todo que comprueba si una cola est� vac�a
	 * Para ello, comprueba si el frente es null
	 * @return
	 */
	public boolean isEmpty() {
		return (size==0);
	}
	
	public Object pop() throws Exception
	{
		Object aux;
		if(!isEmpty())
		{
			aux=frente.elemento;
			frente=frente.siguiente;
			size--;
		}
		else throw new Exception("Eliminar de una cola vac�a");
		
		return aux;
	}
	
	public void clear()
	{
		frente=null;
		size = 0;
		System.gc();
	}
	
	public Object front() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Error: la cola est� vac�a");
		}
		return frente.elemento;
	}
	
	public Object end() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Error: la cola est� vac�a");
		}
		return fin.elemento;
	}

}
