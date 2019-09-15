package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.ClienteModel;
import br.com.acervo.model.dao.ClienteDao;

/**
 *
 * @author jluiz
 */
public class ClienteService {

    ClienteDao clienteDao = new ClienteDao();

    public int salvarClienteDAO(ClienteModel pClienteModel) {
        return clienteDao.salvarClienteDAO(pClienteModel);
    }

    public ClienteModel getClienteDAO(int pIdCliente) {

        return clienteDao.getClienteDAO(pIdCliente);
    }

    public ClienteModel getClienteDAO(String pNomeCliente) {

        return clienteDao.getClienteDAO(pNomeCliente);
    }

    public ArrayList<ClienteModel> getListaClienteDAO() {

        return clienteDao.getListaClienteDAO();
    }

    public boolean atualizarClienteDAO(ClienteModel pClienteModel) {

        return clienteDao.atualizarClienteDAO(pClienteModel);
    }

    public boolean excluirClienteDAO(int pIdCliente) {

        return clienteDao.excluirClienteDAO(pIdCliente);
    }

    public ClienteModel getQuantidadeCliente() {
        return clienteDao.getQuantidadeCliente();
    }
}
