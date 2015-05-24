/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dependente;
import model.Pessoa;
import persistencia.PessoaDao;

/**
 *
 * @author Rael
 */
public class AdicionarPessoaCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PessoaDao pessoaDao = new PessoaDao();
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        Pessoa novaPessoa = new Pessoa(0, nome, sobrenome, new ArrayList<Dependente>());
        pessoaDao.save(novaPessoa);
        RequestDispatcher rd = request.getRequestDispatcher("Servlet?action=listarPessoas");
        rd.forward(request, response);
    }

}
