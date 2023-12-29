package BussinesLogic;

import DAO.ClientiDAO;
import Model.Clienti;
import BussinesLogic.Validari.Gmail;
import BussinesLogic.Validari.Telefon;
import project.ExistaClient;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ClientiBLL {
    private ClientiDAO clientiDAO;
    public ClientiBLL() {
        clientiDAO = new ClientiDAO();
    }
    public Clienti findClientiById(int id) {
        return clientiDAO.findById(id);
    }
    public String update(Clienti t)
    {
        ExistaClient ex=new ExistaClient();
        ArrayList<String> valori=new ArrayList<String>();
        valori.add(t.getIdClienti()+"");
        valori.add(t.getNume());
        valori.add(t.getPrenume());
        valori.add(t.getEmail());
        valori.add(t.getTelefon());
        valori.add(t.getAdresa());
        if(!ex.validate(t))
            return clientiDAO.update(valori, String.valueOf(t.getIdClienti()));
        else return "ERROR";
    }
    public String delete(Clienti t)
    {
        ExistaClient ex=new ExistaClient();
        if(!ex.validate(t))
            return clientiDAO.delete(String.valueOf(t.getIdClienti()));
        else return "ERROR";
    }
    public String insert(Clienti t)
    {
        Gmail e=new Gmail();
        Telefon p=new Telefon();
        String valori="";
        valori='"'+t.getNume()+'"'+","+'"'+t.getPrenume()+'"'+","+'"'+t.getEmail()+'"'+","+'"'+t.getTelefon()+'"'+","+'"'+t.getAdresa()+'"';
        if(e.validate(t) && p.validate(t))
        {
            return clientiDAO.insert(valori);
        }
        else if(!e.validate(t)) return "BusinessLogic.Validari.Gmail incorect!";
        else if(!p.validate(t)) return "Numar de telefon incorect!";
        return "";
    }
    public List<Clienti> findall()
    {
        return clientiDAO.findAll();
    }
    public DefaultTableModel creareTabel(List<Clienti> afisare) {
        return clientiDAO.createTabel(afisare);
    }
}