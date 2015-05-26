/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dependente;
import model.Pessoa;
import persistencia.DependenteDao;
import persistencia.PessoaDao;
import servlet.HttpUtil;

/**
 *
 * @author Rael
 */
public class ExcluirTodosDependentesCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long pessoaId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "pessoaid");

        if (pessoaId != null) {
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoa = pessoaDao.getById(pessoaId);
            List<Dependente> dependentes = pessoa.getDependentes();
            DependenteDao dependenteDao = new DependenteDao();
            for (Dependente dependente : dependentes) {
                dependenteDao.delete(dependente.getId());
            }
            new ListarPessoasCommand().executa(request, response);
        }
    }

}
