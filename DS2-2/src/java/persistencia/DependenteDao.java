/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            if(conexao == null){
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
        //TODO: implementar delete
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dependente> listAll() {
        //TODO: implementar listAll
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dependente getById(Long pk) {
        //TODO: implementar getById
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}