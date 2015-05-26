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
import model.Pessoa;
import persistencia.PessoaDao;
import servlet.HttpUtil;

/**
 *
 * @author Rael
 */
public class FormEditarPessoaCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long pessoaId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "pessoaid");
        if (pessoaId != null) {
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoa = pessoaDao.getById(pessoaId);
            request.setAttribute("nome", pessoa.getNome());
            request.setAttribute("sobrenome", pessoa.getSobrenome());
            request.setAttribute("id", pessoa.getId());
            RequestDispatcher rd = request.getRequestDispatcher("form_editar_pessoa.jsp");
            rd.forward(request, response);
        }
    }

}
