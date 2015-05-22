/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dependente;
import model.Pessoa;
import persistencia.DependenteDao;
import persistencia.PessoaDao;

/**
 *
 * @author Rael
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        switch (action) {
            case ("listarPessoas"): {
                PessoaDao pessoaDao = new PessoaDao();
                List<Pessoa> pessoas = pessoaDao.listAll();
                request.setAttribute("pessoas", pessoas);
                RequestDispatcher rd = request.getRequestDispatcher("listagem.jsp");
                rd.forward(request, response);
                break;
            }
            case ("listarDependentes"): {
                String paramPessoaId = request.getParameter("pessoaid");
                long pessoaId = 0;
                try {
                    pessoaId = Long.parseLong(paramPessoaId);
                } catch (NumberFormatException e) {
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }

                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.getById(pessoaId);
                List<Dependente> dependentes = pessoa.getDependentes();
                request.setAttribute("pessoa", pessoa);
                request.setAttribute("dependentes", dependentes);
                RequestDispatcher rd = request.getRequestDispatcher("listagem_dependentes.jsp");
                rd.forward(request, response);
                break;
            }

            case ("adicionarDependente"): {
                String paramPessoaId = request.getParameter("pessoaid");
                long pessoaId;
                try {
                    pessoaId = Long.parseLong(paramPessoaId);
                } catch (NumberFormatException e) {
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    break;
                }

                DependenteDao dependenteDao = new DependenteDao();
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                Dependente novoDependente = new Dependente(0, nome, sobrenome, pessoaId);
                dependenteDao.save(novoDependente);
                RequestDispatcher rd = request.getRequestDispatcher("Servlet?action=listarDependentes&pessoaid=" + pessoaId);
                rd.forward(request, response);
                break;
            }

            case ("adicionarPessoa"): {

                PessoaDao pessoaDao = new PessoaDao();
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                Pessoa novaPessoa = new Pessoa(0, nome, sobrenome, new ArrayList<Dependente>());
                pessoaDao.save(novaPessoa);
                RequestDispatcher rd = request.getRequestDispatcher("Servlet?action=listarPessoas");
                rd.forward(request, response);
                break;
            }
            case ("excluirPessoa"): {
                String paramPessoaId = request.getParameter("pessoaid");
                long pessoaId;
                try {
                    pessoaId = Long.parseLong(paramPessoaId);
                } catch (NumberFormatException e) {
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    break;
                }
                PessoaDao pessoaDao = new PessoaDao();
                pessoaDao.delete(pessoaId);
                RequestDispatcher rd = request.getRequestDispatcher("Servlet?action=listarPessoas");
                rd.forward(request, response);
                break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
