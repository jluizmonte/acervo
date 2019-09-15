package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.LivroModel;
import br.com.acervo.model.LivrosVendasLivrosModel;
import br.com.acervo.model.VendasLivroModel;

/**
 *
 * @author Jose Luiz
 */
public class LivrosVendasLivrosDao extends AcervoConnectionMySql implements ILivrosVendasLivrosDao {

	/**
	 *
	 * @param pCodigoVenda
	 * @return
	 */
	@Override
	public ArrayList<LivrosVendasLivrosModel> getListaLivrosVendasLivrosDAO(int pCodigoVenda) {
		ArrayList<LivrosVendasLivrosModel> listaLivrosVendasLivrosModel = new ArrayList<>();
		LivrosVendasLivrosModel livrosVendasLivrosModel = new LivrosVendasLivrosModel();
		LivroModel livroModel = new LivroModel();
		VendasLivroModel vendaLivrosModel = new VendasLivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "tbl_livro.pk_id_livro," + "tbl_livro.livro_titulo," + "tbl_livro.livro_autor,"
					+ "tbl_livro.livro_ano," + "tbl_livro.livro_categoria," + "tbl_livro.livro_obs,"
					+ "tbl_livro.livro_data," + "tbl_livro.livro_tipo," + "tbl_livro.livro_quantidade,"
					+ "tbl_livro.livro_preco," + " tbl_vendas_livro.fk_livro," + " tbl_vendas_livro.fk_vendas,"
					+ " tbl_vendas_livro.pk_id_venda_livro," + " tbl_vendas_livro.ven_livro_quantidade,"
					+ " tbl_vendas_livro.ven_livro_valor " + " FROM tbl_vendas_livro "
					+ " INNER JOIN tbl_livro ON tbl_livro.pk_id_livro = " + " tbl_vendas_livro.fk_livro "
					+ " WHERE tbl_vendas_livro.fk_vendas = '" + pCodigoVenda + "';");

			while (this.getResultSet().next()) {
				livrosVendasLivrosModel = new LivrosVendasLivrosModel();
				livroModel = new LivroModel();
				vendaLivrosModel = new VendasLivroModel();

				livroModel.setIdLivro(this.getResultSet().getInt(1));
				livroModel.setTitulo(this.getResultSet().getString(2));
				livroModel.setAutor(this.getResultSet().getString(3));
				livroModel.setAno(this.getResultSet().getInt(4));
				livroModel.setCategoria(this.getResultSet().getString(5));
				livroModel.setObservacao((this.getResultSet().getString(6)));
				livroModel.setDataCadastro(this.getResultSet().getString(7));
				livroModel.setTipoLivro(this.getResultSet().getString(8));
				livroModel.setQuantidadeLivro(this.getResultSet().getInt(9));
				livroModel.setLivroValorUnitario(this.getResultSet().getDouble(10));

				vendaLivrosModel.setLivro(this.getResultSet().getInt(11));
				vendaLivrosModel.setVendas(this.getResultSet().getInt(12));
				vendaLivrosModel.setIdVendaLivro(this.getResultSet().getInt(13));
				vendaLivrosModel.setVenLivroQuantidade(this.getResultSet().getInt(14));
				vendaLivrosModel.setVendasLivroValor(this.getResultSet().getDouble(15));

				livrosVendasLivrosModel.setLivroModel(livroModel);

				livrosVendasLivrosModel.setModelVendasLivros(vendaLivrosModel);

				listaLivrosVendasLivrosModel.add(livrosVendasLivrosModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaLivrosVendasLivrosModel;
	}

}
