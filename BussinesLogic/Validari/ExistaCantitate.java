package BussinesLogic.Validari;
import Model.Produse;
public class ExistaCantitate implements Validators<Produse> {

    public boolean validate(Produse obj) {
        Produse produse = obj;

        return produse.getCantitate() >= 0;
    }
}