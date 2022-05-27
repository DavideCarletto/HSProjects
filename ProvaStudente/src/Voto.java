import java.sql.Date;

public class Voto {

	private int id;
	private float valore;
	private Date data;
	private int idStudente;
	
	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValore() {
		return valore;
	}
	public void setValore(float valore) {
		this.valore = valore;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Voto [id=" + id + ", valore=" + valore + ", data=" + data + ", idStudente=" + idStudente + "]";
	}
	
	
}
