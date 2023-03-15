package view;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import model.Estado;

public class EstadoComboBoxModel extends AbstractListModel implements ComboBoxModel{

	private ArrayList<Estado> estados;
	private Estado estadoSelecionado;
	 
	public EstadoComboBoxModel(ArrayList<Estado> estados) {
		this.estados = estados;
	}
	
	@Override
	public int getSize() {
		return estados.size();
	}

	@Override
	public Object getElementAt(int index) {
		return estados.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
estadoSelecionado = (Estado) anItem;		
//super.setSelectedItem(anItem);

	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return estadoSelecionado;
	}

}
