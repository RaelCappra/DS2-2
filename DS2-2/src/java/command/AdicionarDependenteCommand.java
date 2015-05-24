/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dependente;
import persistencia.DependenteDao;
import servlet.HttpUtil;

/**
 *
 * @author Rael
 */
public class AdicionarDependenteCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pessoaId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "pessoaid");

        DependenteDao dependenteDao = new DependenteDao();
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        Dependente novoDependente = new Dependente(0, nome, sobrenome, pessoaId);
        dependenteDao.save(novoDependente);
        new ListarDependentesCommand().executa(request, response);
    }

}
