package MVC;

import Model.Clienti;
import Model.Comenzi;
import Model.Produse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import BussinesLogic.ClientiBLL;
import BussinesLogic.ProduseBLL;
import BussinesLogic.ComenziBLL;
public class Controller {
public View my_view;
private ArrayList<Produse> produseAdaugatePerClient=new ArrayList<Produse>();
public Controller(View my_view)
{
	this.my_view=my_view;
	my_view.addListenerVizualizareComenzi(new listenerVizualizareComenzi());
	my_view.addListenerVizualizareProduse(new listenerVizualizareProduse());
	my_view.addListenerInsertProduse(new listenerInsertProduse());
	my_view.addListenerStergProduse(new listenerStergProduse());
	my_view.addListenerUpdateProduse(new listenerUpdateProduse());
	my_view.addListenerBackTabel(new listenerBackTabel());
	my_view.addListenerAdaugareProduse(new listenerAdaugaProduse());
	my_view.addListenerClienti(new listenerClienti());
	my_view.addListenerComenzi(new listenerComenzi());
	my_view.addListenerBackComenzi(new listenerBackComenzi());
	my_view.addListenerVizualizareClienti(new listenerVizualizareClienti());
	my_view.addListenerInsertClienti(new listenerInsertClienti());
	my_view.addListenerBackClienti(new listenerBackClienti());
	my_view.addListenerProduse(new listenerProduse());
	my_view.addListenerBackProduse(new listenerBackProduse());
	my_view.addListenerDeleteClienti(new listenerDeleteClienti());
	my_view.addListenerUpdateClienti(new listenerUpdateClienti());
}

class listenerComenzi implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.frameComenzi();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBackComenzi implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getFrameComenzi().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBackTabel implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getResultFrame().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerClienti implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.frameClienti();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerAdaugaProduse implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			int id_cautat=Integer.parseInt(my_view.getTextField_idProduse());
			ProduseBLL aux=new ProduseBLL();
			Produse produs=aux.findProduseById(id_cautat);
			Produse produsUpdate=aux.findProduseById(id_cautat);
			produs.setCantitate(Integer.parseInt(my_view.getTextField_cantitateComenzi()));
			if(produs.getCantitate()>produsUpdate.getCantitate())
				{Rezultate("CANTITATE INSUFICIENTA!");
				}
			else {
				produseAdaugatePerClient.add(produs);
				produsUpdate.setCantitate(produsUpdate.getCantitate() - Integer.parseInt(my_view.getTextField_cantitateComenzi()));
				String sir = aux.update(produsUpdate);
				ComenziBLL aux2 = new ComenziBLL();
				Comenzi i = new Comenzi(my_view.getTextField_idClient(), my_view.getTextField_numeProdus(), Integer.parseInt(my_view.getTextField_cantitateComenzi()));
				aux2.insert(i);
				Rezultate("SUCCES");
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class listenerBackClienti implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getFrameClienti().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerProduse implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.frameProduse();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerBackProduse implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			my_view.getFrameProduse().dispose();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerVizualizareClienti implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			List<Clienti> afisare= new ArrayList<Clienti>();
			ClientiBLL aux=new ClientiBLL();
			afisare=aux.findall();
			DefaultTableModel tabelModel =aux.creareTabel(afisare);
			my_view.getTable().setModel(tabelModel);
			my_view.createResultFrame();
			my_view.getResultFrame().setVisible(true);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerVizualizareComenzi implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL bll=new ClientiBLL();
			my_view.getResultFrame().dispose();
			List<Comenzi> afisare= new ArrayList<Comenzi>();
			ComenziBLL aux=new ComenziBLL();
			afisare=aux.findall();
			DefaultTableModel tabelModel =aux.creareTabel(afisare);
			my_view.createResultFrame();
			my_view.getTable().setModel(tabelModel);
			my_view.getTable().setVisible(true);
			my_view.getResultFrame().setVisible(true);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
	private void Rezultate(String text) {
		JOptionPane.showMessageDialog(null,text,"Info",JOptionPane.INFORMATION_MESSAGE);
	}
class listenerVizualizareProduse implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					List<Produse> afisare= new ArrayList<Produse>();
					ProduseBLL aux=new ProduseBLL();
					afisare=aux.findall();
					DefaultTableModel tabelModel =aux.creareTabel(afisare);
					my_view.getTable().setModel(tabelModel);
					my_view.createResultFrame();
					my_view.getResultFrame().setVisible(true);
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}

}
class listenerInsertClienti implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL bll=new ClientiBLL();
			Clienti aux=new Clienti(my_view.getTextField_numeClienti(),my_view.getTextField_prenumeClienti(),my_view.getTextField_emailClienti(),my_view.getTextField_telefonClienti(),my_view.getTextField_adresaClienti());
			Rezultate(bll.insert(aux));
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerInsertProduse implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ProduseBLL bll=new ProduseBLL();
			Produse aux=new Produse(my_view.getTextField_numeProduse(),Integer.parseInt(my_view.getTextField_cantitateProduse()));
			Rezultate(bll.insert(aux));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerStergProduse implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ProduseBLL bll=new ProduseBLL();
			Produse aux=new Produse(Integer.parseInt(my_view.getTextField_idProduse()),my_view.getTextField_numeProduse(),Integer.parseInt(my_view.getTextField_cantitateProduse()));
			Rezultate(bll.delete(aux));
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerDeleteClienti implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL bll=new ClientiBLL();
			Clienti aux=new Clienti(Integer.parseInt(my_view.getTextField_idClienti()),my_view.getTextField_numeClienti(),my_view.getTextField_prenumeClienti(),my_view.getTextField_emailClienti(),my_view.getTextField_telefonClienti(),my_view.getTextField_adresaClienti());
			Rezultate(bll.delete(aux));
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerUpdateProduse implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ProduseBLL bll=new ProduseBLL();
			Produse aux=new Produse(Integer.parseInt(my_view.getTextField_idProduse()),my_view.getTextField_numeProduse(),Integer.parseInt(my_view.getTextField_cantitateProduse()));
			Rezultate(bll.update(aux));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class listenerUpdateClienti implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		try {
			ClientiBLL bll=new ClientiBLL();
			Clienti aux=new Clienti(Integer.parseInt(my_view.getTextField_idClienti()),my_view.getTextField_numeClienti(),my_view.getTextField_prenumeClienti(),my_view.getTextField_emailClienti(),my_view.getTextField_telefonClienti(),my_view.getTextField_adresaClienti());
			Rezultate(bll.update(aux));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
}