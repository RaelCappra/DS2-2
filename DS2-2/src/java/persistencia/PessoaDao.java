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

public class PessoaDao implements Dao<Pessoa, Long> {

    private static ConexaoPostgreSQL conexao;

    @Override
    public void save(Pessoa entity) {
        String query = "insert into pessoa (nome, sobrenome) values (?, ?)";
        try {
            if (conexao == null) {
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
            if (conexao == null) {
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
        String query = "select * from dependente";
        List<Pessoa> result = new ArrayList<>();
        try {
            if (conexao == null) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(rs.getLong("id"));
                    pessoa.setNome(rs.getString("nome"));
                    pessoa.setSobrenome(rs.getString("sobrenome"));
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
        String query = "select * from dependente where id = ?";
        try {
            if (conexao == null) {
                conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            }
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setLong(1, pk);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    result = new Pessoa();
                    result.setId(id);
                    result.setNome(nome);
                    result.setSobrenome(sobrenome);
                } else{
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

}
