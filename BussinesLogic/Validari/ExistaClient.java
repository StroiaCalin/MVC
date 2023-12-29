package BussinesLogic.Validari;

import BussinesLogic.ClientiBLL;
import Model.Clienti;

public class ExistaClient implements Validators<Object> {
    public boolean validate(Object obj) {
        if (obj instanceof Clienti) {
            Clienti aux = (Clienti) obj;
            ClientiBLL clientiBLL = new ClientiBLL();

            return clientiBLL.findClientiById(aux.getIdClienti()) == null;
        }

        return false; // Return false for non-Model.Clienti objects
    }
}