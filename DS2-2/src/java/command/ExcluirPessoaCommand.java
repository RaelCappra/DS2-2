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
import persistencia.PessoaDao;
import servlet.HttpUtil;

/**
 *
 * @author Rael
 */
public class ExcluirPessoaCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long pessoaId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "pessoaid");
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.delete(pessoaId);
        new ListarPessoasCommand().executa(request, response);
    }

}
