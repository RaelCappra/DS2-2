package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

public class PessoaDao implements Dao<Pessoa, Long> {

    private static ConexaoPostgreSQL conexao;

    @Override
    public void save(Pessoa entity) {
        String query = "insert into pessoa (nome, sobrenome) values (?, ?)";
        try {
            conexao = new ConexaoPostgreSQL("localhost", "postgres", "postgres", "postgres");
            try (Connection connection = conexao.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, entity.getNome());
                ps.setString(2, entity.getSobrenome());
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Long id) {
        //TODO: implementar delete
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> listAll() {
        //TODO: implementar listAll
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa getById(Long pk) {
        //TODO: implementar getById
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
