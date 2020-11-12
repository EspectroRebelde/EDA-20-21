package clases;

public class Libro {
	
		
	public String title;
	public int pages;
	public String author;
	
	private int currentPage;
	
	/**
	 * Constructor de la clase Libro sin par�metros
	 */
	public Libro() {
		currentPage = 0;
	}
	
	/**
	 * Constructor de la clase Libro con una p�gina
	 */
	public Libro(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * M�todo que sirve para poner la p�gina actual a 0
	 */
	public void empezarLibro() {
		currentPage = 0;
	}
	
	public static void comprarLibro(int price) {
		System.out.println("El precio del libro es " + price);
	}

}
