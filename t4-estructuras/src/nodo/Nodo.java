package nodo;

public class Nodo {

	//declaramos que los elementos son de tipo Object para que sea una pila gen�rica
	public Object elemento;
	public Nodo siguiente;
	
	public Nodo(Object x)
	{
		elemento=x;
		siguiente=null;
	}
	
}
