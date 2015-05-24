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
import persistencia.PessoaDao;
import static servlet.HttpUtil.getLongParameterOrRedirectToIndex;

/**
 *
 * @author Rael
 */
public class ListarDependentesCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");

        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoa = pessoaDao.getById(pessoaId);
        List<Dependente> dependentes = pessoa.getDependentes();
        request.setAttribute("pessoa", pessoa);
        request.setAttribute("dependentes", dependentes);
        RequestDispatcher rd = request.getRequestDispatcher("listagem_dependentes.jsp");
        rd.forward(request, response);
    }

}
