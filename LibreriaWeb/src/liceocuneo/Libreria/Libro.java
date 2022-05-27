package liceocuneo.Libreria;

public class Libro {

	private int id;
	private String isbn; 
	private String titolo1;
	private String titolo2;
	public Libro(String isbn, String titolo1, String titolo2) {
		super();
		this.isbn = isbn;
		this.titolo1 = titolo1;
		this.titolo2 = titolo2;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo1() {
		return titolo1;
	}
	public void setTitolo1(String titolo1) {
		this.titolo1 = titolo1;
	}
	public String getTitolo2() {
		return titolo2;
	}
	public void setTitolo2(String titolo2) {
		this.titolo2 = titolo2;
	}
	public int getId() {
		return id;
	}
	
	
}
