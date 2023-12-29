package Model;

public class Produse {

    private int idproduse;
    private String nume;
    private int cantitate;


    public Produse() {
        // Default constructor
    }

    public Produse(int idproduse, String nume, int cantitate) {
        this.idproduse = idproduse;
        this.nume = nume;
        this.cantitate = cantitate;
    }

    public Produse(String nume, int cantitate) {
        this(-1, nume, cantitate);
    }
    public int getIdproduse() {
        return idproduse;
    }
    public void setIdproduse(int idproduse) {
        this.idproduse = idproduse;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
