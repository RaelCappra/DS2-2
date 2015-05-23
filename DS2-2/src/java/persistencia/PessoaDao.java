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
import model.Pessoa;
//TODO:Adicionar a lista de dependentes à pessoa quando possivel

public class PessoaDao implements Dao<Pessoa, Long> {

    private static ConexaoPostgreSQL conexao;

    @Override
    public void save(Pessoa entity) {
        String query = "insert into pessoa (nome, sobrenome) values (?, ?)";
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, entity.getNome());
                ps.setString(2, entity.getSobrenome());
                ps.execute();
            } catch (SQLException e) {
                //TODO: ERRO: nao foi adicionada a pessoa
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Long id) {
        String query = "delete from pessoa where id = ?";
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
    public List<Pessoa> listAll() {
        String query = "select * from pessoa";
        List<Pessoa> result = new ArrayList<>();
        try {
            if (conexao == null || conexao.getConnection().isClosed()) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Pessoa pessoa = new Pessoa();
                    long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    pessoa.setId(id);
                    pessoa.setNome(nome);
                    pessoa.setSobrenome(sobrenome);

                    DependenteDao dependenteDao = new DependenteDao();
                    List<Dependente> dependentes = dependenteDao.listByPessoa(id);
                    pessoa.setDependentes(dependentes);

                    result.add(pessoa);
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
    public Pessoa getById(Long pk) {
        Pessoa result = null;
        String query = "select * from pessoa where id = ?";
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
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    result = new Pessoa();
                    result.setId(id);
                    result.setNome(nome);
                    result.setSobrenome(sobrenome);

                    DependenteDao dependenteDao = new DependenteDao();
                    List<Dependente> dependentes = dependenteDao.listByPessoa(id);
                    result.setDependentes(dependentes);

                } else {
                    //TODO: ERRO: não ha dependente com este id
                }
            } catch (SQLException e) {
                int i = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public void edit(long id, String nome, String sobrenome){
        String query = "update pessoa set nome = ?, sobrenome = ? where id = ?;";
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
