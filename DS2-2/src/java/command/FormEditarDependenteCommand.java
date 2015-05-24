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
import model.Pessoa;
import persistencia.DependenteDao;
import persistencia.PessoaDao;
import servlet.HttpUtil;

/**
 *
 * @author Rael
 */
public class FormEditarDependenteCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long dependenteId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "dependenteid");
        long pessoaId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "pessoaid");

        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoa = pessoaDao.getById(pessoaId);

        DependenteDao dependenteDao = new DependenteDao();
        Dependente dependente = dependenteDao.getById(dependenteId);
        request.setAttribute("pessoa", pessoa);
        request.setAttribute("dependente", dependente);
        RequestDispatcher rd = request.getRequestDispatcher("form_editar_dependente.jsp");
        rd.forward(request, response);  
    }

}
