//TODO:Validacao em js, java e sql
package servlet;

import command.AdicionarDependenteCommand;
import command.AdicionarPessoaCommand;
import command.Command;
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
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Map<String, Command> actions = new HashMap<String, Command>();
        actions.put("listarPessoas", new ListarPessoasCommand());
        actions.put("listarDependentes", new ListarDependentesCommand());
        actions.put("adicionarPessoa", new AdicionarPessoaCommand());
        actions.put("adicionarDependente", new AdicionarDependenteCommand());
        actions.put("excluirPessoa", new ExcluirPessoaCommand());
        actions.put("excluirDependente", new ExcluirDependenteCommand());
        actions.put("excluirDependentesSelecionados", new ExcluirDependentesSelecionadosCommand());
        actions.put("excluirTodosDependentes", new ExcluirTodosDependentesCommand());
        actions.put("editarPessoa", new EditarPessoaCommand());
        actions.put("editarDependente", new EditarDependenteCommand());
        actions.put("formEditarPessoa", new FormEditarPessoaCommand());
        actions.put("formEditarDependente", new FormEditarDependenteCommand());
        
        if(action == null){
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            return;
        }
        
        actions.get(action).executa(request, response);
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
