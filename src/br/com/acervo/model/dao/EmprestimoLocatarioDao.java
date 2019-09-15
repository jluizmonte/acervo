package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.EmprestimoLocatarioModel;
import br.com.acervo.model.EmprestimoModel;
import br.com.acervo.model.LivroModel;
import br.com.acervo.model.LocadorModel;
import br.com.acervo.model.LocatarioModel;

/**
 *
 * @author joseluiz
 */
public class EmprestimoLocatarioDao extends AcervoConnectionMySql implements IEmprestimoLocatarioDao {

	@Override
	public ArrayList<EmprestimoLocatarioModel> getListaEmprestimosLocatarioDAO() {

		ArrayList<EmprestimoLocatarioModel> listaEmprestimoLocatarioModel = new ArrayList<>();
		EmprestimoModel emprestimoModel = new EmprestimoModel();
		LocatarioModel locatarioModel = new LocatarioModel();
		LocadorModel locadorModel = new LocadorModel();
		LivroModel livroModel = new LivroModel();
		EmprestimoLocatarioModel emprestimoLocatarioModel = new EmprestimoLocatarioModel();

		try {
			this.conectar();
			this.executarSQL("SELECT * FROM tbl_emprestimo "
					+ "INNER JOIN tbl_locatario ON tbl_locatario.pk_id_locatario = tbl_emprestimo.fk_locatario "
					+ "INNER JOIN tbl_locador ON tbl_locador.pk_id_locador = tbl_emprestimo.fk_locador "
					+ "INNER JOIN tbl_livro ON tbl_livro.pk_id_livro = tbl_emprestimo.fk_livro;");
			while (this.getResultSet().next()) {
				emprestimoModel = new EmprestimoModel();
				locatarioModel = new LocatarioModel();
				locadorModel = new LocadorModel();
				livroModel = new LivroModel();
				emprestimoLocatarioModel = new EmprestimoLocatarioModel();

				// emprestimo
				emprestimoModel = new EmprestimoModel();
				emprestimoModel.setIdEmprestimo(this.getResultSet().getInt(1));
				emprestimoModel.setIdLocador(this.getResultSet().getInt(2));
				emprestimoModel.setIdLocatario(this.getResultSet().getInt(3));
				emprestimoModel.setIdLivro(this.getResultSet().getInt(4));
				emprestimoModel.setDataEmprestimo(this.getResultSet().getString(5));
				emprestimoModel.setDataDevolucao(this.getResultSet().getString(6));
				emprestimoModel.setStatus(this.getResultSet().getString(7));

				// locatário
				locatarioModel = new LocatarioModel();
				locatarioModel.setIdLocatario(this.getResultSet().getInt(8));
				locatarioModel.setNome(this.getResultSet().getString(9));
				locatarioModel.setRua(this.getResultSet().getString(10));
				locatarioModel.setNumero(this.getResultSet().getString(11));
				locatarioModel.setBairro(this.getResultSet().getString(12));
				locatarioModel.setCidade(this.getResultSet().getString(13));
				locatarioModel.setUf(this.getResultSet().getString(14));
				locatarioModel.setCep(this.getResultSet().getString(15));
				locatarioModel.setTelefone(this.getResultSet().getString(16));
				locatarioModel.setEmail(this.getResultSet().getString(17));
				locatarioModel.setStatus(this.getResultSet().getString(18));

				// locador
				locadorModel.setIdLocador(this.getResultSet().getInt(19));
				locadorModel.setNome(this.getResultSet().getString(20));
				locadorModel.setRua(this.getResultSet().getString(21));
				locadorModel.setNumero(this.getResultSet().getString(22));
				locadorModel.setBairro(this.getResultSet().getString(23));
				locadorModel.setCidade(this.getResultSet().getString(24));
				locadorModel.setUf(this.getResultSet().getString(25));
				locadorModel.setCep(this.getResultSet().getString(26));
				locadorModel.setTelefone(this.getResultSet().getString(27));
				locadorModel.setEmail(this.getResultSet().getString(28));

				// livro
				livroModel.setIdLivro(this.getResultSet().getInt(29));
				livroModel.setTitulo(this.getResultSet().getString(30));
				livroModel.setAutor(this.getResultSet().getString(31));
				livroModel.setAno(this.getResultSet().getInt(32));
				livroModel.setCategoria(this.getResultSet().getString(33));
				livroModel.setObservacao((this.getResultSet().getString(34)));
				livroModel.setDataCadastro(this.getResultSet().getString(35));
				livroModel.setTipoLivro(this.getResultSet().getString(36));
				livroModel.setQuantidadeLivro(this.getResultSet().getInt(37));
				livroModel.setLivroValorUnitario(this.getResultSet().getDouble(38));

				emprestimoLocatarioModel.setEmprestimoModel(emprestimoModel);
				emprestimoLocatarioModel.setLocatarioModel(locatarioModel);
				emprestimoLocatarioModel.setLocadorModel(locadorModel);
				emprestimoLocatarioModel.setLivroModel(livroModel);
				listaEmprestimoLocatarioModel.add(emprestimoLocatarioModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaEmprestimoLocatarioModel;

	}

}
