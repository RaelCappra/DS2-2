/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.PessoaDao;
import servlet.HttpUtil;

/**
 *
 * @author Rael
 */
public class EditarPessoaCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long pessoaId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "pessoaid");
        if (pessoaId != null) {
            PessoaDao pessoaDao = new PessoaDao();
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");

            pessoaDao.edit(pessoaId, nome, sobrenome);
            new ListarPessoasCommand().executa(request, response);
        }
    }

}
