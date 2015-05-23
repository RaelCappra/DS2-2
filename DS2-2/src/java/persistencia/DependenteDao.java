/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dependente;

/**
 *
 * @author Rael
 */
public class DependenteDao implements Dao<Dependente, Long> {

    private static ConexaoPostgreSQL conexao;

    @Override
    public void save(Dependente entity) {
        String query = "insert into dependente (nome, sobrenome, pessoa) values (?, ?, ?)";
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, entity.getNome());
                ps.setString(2, entity.getSobrenome());
                ps.setLong(3, entity.getIdPessoa());
                ps.execute();
            } catch (SQLException e) {
                //TODO: ERRO: nao foi adicionado o dependente
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        String query = "delete from dependente where id = ?";
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setLong(1, id);
                ps.execute();
            } catch (SQLException e) {
                //TODO: ERRO: nao foi deletado o dependente
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Dependente> listAll() {
        String query = "select * from dependente";
        List<Dependente> result = new ArrayList<>();
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Dependente dependente = new Dependente();
                    dependente.setId(rs.getLong("id"));
                    dependente.setIdPessoa(rs.getLong("pessoa"));
                    dependente.setNome(rs.getString("nome"));
                    dependente.setSobrenome(rs.getString("sobrenome"));
                    result.add(dependente);
                }
            } catch (SQLException e) {
                //TODO: ERRO: nao foram listados os dependentes
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public Dependente getById(Long pk) {
        Dependente result = null;
        String query = "select * from dependente where id = ?";
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setLong(1, pk);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    long id = rs.getLong("id");
                    long idPessoa = rs.getLong("pessoa");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    result = new Dependente(id, nome, sobrenome, idPessoa);
                } else {
                    //TODO: ERRO: não ha dependente com este id
                }
            } catch (SQLException e) {
                //TODO: ERRO: nao foi buscado o dependente
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Dependente> listByPessoa(long idPessoa) {
        String query = "select * from dependente where pessoa = ?";
        List<Dependente> result = new ArrayList<>();
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setLong(1, idPessoa);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Dependente dependente = new Dependente();
                    dependente.setId(rs.getLong("id"));
                    dependente.setIdPessoa(rs.getLong("pessoa"));
                    dependente.setNome(rs.getString("nome"));
                    dependente.setSobrenome(rs.getString("sobrenome"));
                    result.add(dependente);
                }
            } catch (SQLException e) {
                //TODO: ERRO: nao foram listados os dependentes
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    public void edit(long id, String nome, String sobrenome){
        String query = "update dependente set nome = ?, sobrenome = ? where id = ?;";
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setLong(3, id);
                ps.setString(1, nome);
                ps.setString(2, sobrenome);
                ps.execute();
            } catch (SQLException e) {
                //TODO: ERRO: nao foi alterada a pessoa
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
