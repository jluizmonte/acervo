package br.com.acervo.model.dao;

import br.com.acervo.model.TemaModel;

public interface ITemaDao {

    public boolean atualizarTemaDAO(TemaModel pTemaModel);

    public TemaModel getTemaDAO();

    public TemaModel getNomeBiblioteca();

}
