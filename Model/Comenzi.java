package Model;

public class Comenzi {
	private int idComenzi;
	private int idCumparator;
	private String produs;
	private int cantitate;
	public Comenzi()
	{

	}
	public Comenzi(int idCumparator, String produs, int cantitate) {
		super();
		this.idCumparator=idCumparator;
		this.produs = produs;
		this.cantitate = cantitate;
	}
	public int getIdComenzi() {
		return idComenzi;
	}
	public void setIdComenzi(int idComenzi) {
		this.idComenzi = idComenzi;
	}
	public int getIdCumparator() {
		return idCumparator;
	}
	public void setIdCumparator(int idCumparator) {
		this.idCumparator = idCumparator;
	}
	public String getProdus() {
		return produs;
	}
	public void setProdus(String produs) {
		this.produs = produs;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

}
