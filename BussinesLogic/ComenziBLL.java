package BussinesLogic;

import DAO.ComenziDAO;
import Model.Comenzi;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class ComenziBLL {
	private ComenziDAO comenziDAO;
	public ComenziBLL() {
		comenziDAO = new ComenziDAO();
	}
	public List<Comenzi> findall()
	{
		List<Comenzi> aux=comenziDAO.findAll();
		return aux;
	}
	public String insert(Comenzi t)
	{
		return comenziDAO.insert(t.getIdCumparator()+","+'"'+t.getProdus()+'"'+','+t.getCantitate());

	}
	public DefaultTableModel creareTabel(List<Comenzi> afisare) {
	return comenziDAO.createTabel(afisare);
	}
}
