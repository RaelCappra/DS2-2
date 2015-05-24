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
import model.Pessoa;
import persistencia.PessoaDao;

/**
 *
 * @author Rael
 */
public class ListarPessoasCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PessoaDao pessoaDao = new PessoaDao();
        List<Pessoa> pessoas = pessoaDao.listAll();
        request.setAttribute("pessoas", pessoas);
        RequestDispatcher rd = request.getRequestDispatcher("listagem.jsp");
        rd.forward(request, response);
    }

}
