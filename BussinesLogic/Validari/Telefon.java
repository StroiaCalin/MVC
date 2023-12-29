package BussinesLogic.Validari;
import Model.Clienti;
public class Telefon implements Validators<Clienti> {
    @Override
    public boolean validate(Clienti t) {
        String phoneNumber = t.getTelefon();
        if (phoneNumber.length() != 10) {
            return false;
        }
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
