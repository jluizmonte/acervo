package br.com.acervo.model;

import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class VendasClientesModel {

	private VendasModel modelVendas;
	private ClienteModel modelCliente;
	private ArrayList<VendasClientesModel> listaModelVendasClientes;

	/**
	 * @return the modelVendas
	 */
	public VendasModel getModelVendas() {
		return modelVendas;
	}

	/**
	 * @param modelVendas the modelVendas to set
	 */
	public void setModelVendas(VendasModel modelVendas) {
		this.modelVendas = modelVendas;
	}

	/**
	 * @return the modelCliente
	 */
	public ClienteModel getModelCliente() {
		return modelCliente;
	}

	/**
	 * @param modelCliente the modelCliente to set
	 */
	public void setModelCliente(ClienteModel modelCliente) {
		this.modelCliente = modelCliente;
	}

	/**
	 * @return the listaModelVendasClientes
	 */
	public ArrayList<VendasClientesModel> getListaModelVendasClientes() {
		return listaModelVendasClientes;
	}

	/**
	 * @param listaModelVendasClientes the listaModelVendasClientes to set
	 */
	public void setListaModelVendasClientes(ArrayList<VendasClientesModel> listaModelVendasClientes) {
		this.listaModelVendasClientes = listaModelVendasClientes;
	}

}
