//TODO: Parar de usar get com os redirects, usar request.setAttr instead
//TODO: Adicionar botao de voltar nas paginas
package servlet;

import command.AdicionarDependenteCommand;
import command.AdicionarPessoaCommand;
import command.EditarDependenteCommand;
import command.EditarPessoaCommand;
import command.ExcluirDependenteCommand;
import command.ExcluirDependentesSelecionadosCommand;
import command.ExcluirPessoaCommand;
import command.ExcluirTodosDependentesCommand;
import command.FormEditarDependenteCommand;
import command.FormEditarPessoaCommand;
import command.ListarDependentesCommand;
import command.ListarPessoasCommand;
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
        if(action == null){
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            return;
        }
        switch (action) {
            case ("listarPessoas"): {
                new ListarPessoasCommand().executa(request, response);
                break;
            }
            case ("listarDependentes"): {
                new ListarDependentesCommand().executa(request, response);
                break;
            }

            case ("adicionarDependente"): {
                new AdicionarDependenteCommand().executa(request, response);
                break;
            }

            case ("adicionarPessoa"): {
                new AdicionarPessoaCommand().executa(request, response);
                break;
            }
            case ("excluirPessoa"): {
                new ExcluirPessoaCommand().executa(request, response);
                break;
            }

            case ("excluirDependente"): {
                new ExcluirDependenteCommand().executa(request, response);
                break;
            }
            
            case ("excluirDependentesSelecionados"): {
                new ExcluirDependentesSelecionadosCommand().executa(request, response);
                break;
            }
            
            case ("excluirTodosDependentes"): {
                new ExcluirTodosDependentesCommand().executa(request, response);
                break;
            }

            case ("formEditarPessoa"): {
                new FormEditarPessoaCommand().executa(request, response);
                break;
            }
            case ("editarPessoa"): {
                new EditarPessoaCommand().executa(request, response);
                break;
            }

            case ("formEditarDependente"): {
                new FormEditarDependenteCommand().executa(request, response);
                break;
            }

            case ("editarDependente"): {
                new EditarDependenteCommand().executa(request, response);
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
