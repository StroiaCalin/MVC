package BussinesLogic;

import DAO.ProduseDAO;
import Model.Produse;
import BussinesLogic.Validari.Validators;
import project.ExistaCantitate;
import project.ExistaProdus;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProduseBLL {
	private List<Validators<Produse>> validators;
	
	private ProduseDAO produseDAO;

	public ProduseBLL() {
		validators = new ArrayList<Validators<Produse>>();
		validators.add(new ExistaProdus());
		validators.add(new ExistaCantitate());
		produseDAO = new ProduseDAO();
	}

	public Produse findProduseById(int id) {
		return produseDAO.findById(id);
	}
	public List<Produse> findall()
	{
		return produseDAO.findAll();
	}
	public String insert(Produse T)
	{
	ExistaCantitate aux=new ExistaCantitate();
	String valori="";
	valori='"'+T.getNume()+'"'+","+T.getCantitate();
	if(aux.validate(T))
	{
		return produseDAO.insert(valori);	
	}
	else if(!aux.validate(T)) return "Cantitatea introdusa nu este valida!";
	return null;
	}
	public String delete(Produse T)
	{
		ExistaProdus aux=new ExistaProdus();
		if(!aux.validate(T))
			return produseDAO.delete(String.valueOf(T.getIdproduse()));
		else return "Delete invalid!";
	}
	public String update(Produse t)
	{
		ExistaProdus ex=new ExistaProdus();
		ArrayList<String> valori=new ArrayList<String>();
		valori.add(String.valueOf(t.getIdproduse()));
		valori.add(t.getNume());
		valori.add(String.valueOf(t.getCantitate()));
		if(!ex.validate(t))
			return produseDAO.update(valori, String.valueOf(t.getIdproduse()));
		else return "Update invalid!";
	}
	public DefaultTableModel creareTabel(List<Produse> afisare) {	
	return produseDAO.createTabel(afisare);
	}
}
