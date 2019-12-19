package br.com.acervo.model.dao;

import br.com.acervo.connection.AcervoConnectionSqLite;
import br.com.acervo.model.TemaModel;

public class TemaDao extends AcervoConnectionSqLite implements ITemaDao {

    @Override
    public TemaModel getTemaDAO() {
        TemaModel temaModel = new TemaModel();
        try {
            this.connect();
            this.executeSQL("SELECT * FROM tbl_tema");
            while (this.getResultSet().next()) {
                temaModel.setTema(this.getResultSet().getString("tema_nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConection();
        }
        return temaModel;
    }

    @Override
    public boolean atualizarTemaDAO(TemaModel pTemaModel) {
        try {
            this.connect();
            this.executeUpdateDeleSQL("UPDATE tbl_tema SET tema_nome = ?");
            this.getPreparedStatement().setString(1, pTemaModel.getTema());
            this.getPreparedStatement().executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public TemaModel getNomeBiblioteca() {
        TemaModel temaModel = new TemaModel();
        try {
            this.connect();
            this.executeSQL("SELECT * FROM tbl_biblioteca");
            while (this.getResultSet().next()) {
                temaModel.setNomeLivraria(this.getResultSet().getString("biblioteca_nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConection();
        }
        return temaModel;
    }
}
