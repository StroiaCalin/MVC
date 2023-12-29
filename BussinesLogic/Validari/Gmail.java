package BussinesLogic.Validari;
import Model.Clienti;
public class Gmail implements Validators<Clienti> {

    @Override
    public boolean validate(Clienti t) {
        return t.getEmail().toLowerCase().contains("@gmail.com");
    }
}
