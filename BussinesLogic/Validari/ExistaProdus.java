package BussinesLogic.Validari;
import BussinesLogic.ProduseBLL;
import Model.Produse;

public class ExistaProdus implements Validators<Produse> {

    public boolean validate(Produse obj) {
        Produse t = obj;
        ProduseBLL produseBLL = new ProduseBLL();

        return produseBLL.findProduseById(t.getIdproduse()) == null;
    }
}