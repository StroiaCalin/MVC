package Model;

public class Clienti {
    private int idClienti;
    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private String adresa;
    public Clienti() {
        // Default constructor
    }
    public Clienti(String nume, String prenume, String mail, String telefon, String adresa) {
        this(-1, nume, prenume, mail, telefon, adresa);
    }
    public Clienti(int idClienti, String nume, String prenume, String email, String telefon, String adresa) {
        this.idClienti = idClienti;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
    }
    public int getIdClienti() {
        return idClienti;
    }
    public void setIdClienti(int idClienti) {
        this.idClienti = idClienti;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}