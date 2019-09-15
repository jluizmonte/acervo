package br.com.acervo.connection;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.acervo.util.CarregarFrame;
import br.com.acervo.util.ObterInfoSistema;

public class AcervoConnectionSqLite {

    ObterInfoSistema info = new ObterInfoSistema();
    static String diretorioUsuario;
    static String diretorioPadrao = System.getProperty("user.home");
    private final String nomeSistema = System.getProperty("os.name");
    File arquivo;
    ResultSet resultSet;
    String url;
    Connection conn;
    Statement stmt;
    PreparedStatement preparedStatement;

    public void createNewDatabase() throws IOException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        if (nomeSistema.equals("Linux")) {
            diretorioUsuario = diretorioPadrao + "/.acervo";
            this.setUrl("jdbc:sqlite:" + diretorioUsuario + "/acervo.db");
            arquivo = new File(diretorioUsuario + "/acervo.db");
        } else {
            diretorioUsuario = diretorioPadrao + "\\acervo";
            this.setUrl("jdbc:sqlite:" + diretorioUsuario + "\\acervo.db");
            arquivo = new File(diretorioUsuario + "\\acervo.db");
        }

        File diretorio = new File(diretorioUsuario);
        if (!diretorio.exists()) {
            try {
                diretorio.mkdir();
                arquivo.createNewFile();
                new CarregarFrame().setFrameTime();
            } catch (Exception e) {
                System.out.println("Erro: " + e);
            }
        }
    }

    public void createNewTable(String sql) {

        if (nomeSistema.equals("Linux")) {
            diretorioUsuario = diretorioPadrao + "/.acervo";
            this.setUrl("jdbc:sqlite:" + diretorioUsuario + "/acervo.db");

        } else {
            diretorioUsuario = diretorioPadrao + "\\acervo";
            this.setUrl("jdbc:sqlite:" + diretorioUsuario + "\\acervo.db");
        }

        // criação das tabelas
        String tema = "CREATE TABLE IF NOT EXISTS \"tbl_tema\" (\n"
                + "	\"pk_id_tema\"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" + "	\"tema_nome\"	TEXT\n" + ");";

        String nomeBiblioteca = "CREATE TABLE IF NOT EXISTS \"tbl_biblioteca\" (\n"
                + "	\"pk_id_tema\"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" + "	\"biblioteca_nome\"	TEXT\n"
                + ");";

        // inserção de dados nas tabelas
        String insert_tema = "INSERT INTO \"tbl_tema\" VALUES (1,'de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel');";
        String insert_nome_biblioteca = "INSERT INTO \"tbl_biblioteca\" VALUES (1,'" + sql + "');";

        try (Connection conn = DriverManager.getConnection(this.getUrl()); Statement stmt = conn.createStatement()) {
            // create a new table

            stmt.execute(tema);
            stmt.execute(nomeBiblioteca);
            /**/
            PreparedStatement pstmt = conn.prepareStatement(insert_tema);
            PreparedStatement pstmt2 = conn.prepareStatement(insert_nome_biblioteca);
            pstmt.executeUpdate();
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
        }
    }

    public Connection connect() {

        if (info.getNomeSistema().equals("Linux")) {
            diretorioUsuario = diretorioPadrao + "/.acervo";
            this.setUrl("jdbc:sqlite:" + diretorioUsuario + "/acervo.db");

        } else {
            diretorioUsuario = diretorioPadrao + "\\acervo";
            this.setUrl("jdbc:sqlite:" + diretorioUsuario + "\\acervo.db");
        }
        this.setConn(null);
        try {
            this.setConn(DriverManager.getConnection(this.getUrl()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this.getConn();
    }

    public boolean executeSQL(String pSQL) throws SQLException {
        this.setConn(DriverManager.getConnection(this.getUrl()));
        this.setStmt(this.getConn().createStatement());
        try {
            this.setResultSet(this.getStmt().executeQuery(pSQL));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean executeUpdateDeleSQL(String pSQL) throws SQLException {
        this.setConn(DriverManager.getConnection(this.getUrl()));
        this.setStmt(this.getConn().createStatement());
        try {
            this.setPreparedStatement(this.getConn().prepareStatement(pSQL));
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean closeConection() {
        try {
            if ((this.getResultSet() != null) && (this.stmt != null)) {
                this.getResultSet().close();
                this.stmt.close();
            }
            this.getConn().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

}
