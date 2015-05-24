//TODO: Parar de usar get com os redirects, usar request.setAttr instead
//TODO: Adicionar botao de voltar nas paginas
package servlet;

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
        }
        switch (action) {
            case ("listarPessoas"): {
                new ListarPessoasCommand().executa(request, response);
                break;
            }
            case ("listarDependentes"): {
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");

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
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");

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
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");
                PessoaDao pessoaDao = new PessoaDao();
                pessoaDao.delete(pessoaId);
                RequestDispatcher rd = request.getRequestDispatcher("Servlet?action=listarPessoas");
                rd.forward(request, response);
                break;
            }

            case ("excluirDependente"): {
                long dependenteId = getLongParameterOrRedirectToIndex(request, response, "dependenteid");

                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");

                DependenteDao dependenteDao = new DependenteDao();
                dependenteDao.delete(dependenteId);
                //request.setAttribute("action", "listarDependentes");
                //request.setAttribute("pessoaid", pessoaId);
                RequestDispatcher rd = request.getRequestDispatcher("Servlet?action=listarDependentes&pessiaId=" + pessoaId);
                rd.forward(request, response);
                break;
            }
            case ("excluirTodosDependentes"): {
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");

                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.getById(pessoaId);
                List<Dependente> dependentes = pessoa.getDependentes();
                DependenteDao dependenteDao = new DependenteDao();
                for (Dependente dependente : dependentes) {
                    dependenteDao.delete(dependente.getId());
                }
                //request.setAttribute("action", "listarDependentes");
                //request.setAttribute("pessoaid", pessoaId);
                RequestDispatcher rd = request.getRequestDispatcher("Servlet?action=listarPessoas");
                rd.forward(request, response);
                break;
            }

            case ("formEditarPessoa"): {
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.getById(pessoaId);
                request.setAttribute("nome", pessoa.getNome());
                request.setAttribute("sobrenome", pessoa.getSobrenome());
                request.setAttribute("id", pessoa.getId());
                RequestDispatcher rd = request.getRequestDispatcher("form_editar_pessoa.jsp");
                rd.forward(request, response);
                break;
            }
            case ("editarPessoa"): {
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");
                PessoaDao pessoaDao = new PessoaDao();
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");

                pessoaDao.edit(pessoaId, nome, sobrenome);
                //TODO:Separar trechos de codigo como este em commands(esta copiado lá de cima)
                List<Pessoa> pessoas = pessoaDao.listAll();
                request.setAttribute("pessoas", pessoas);
                RequestDispatcher rd = request.getRequestDispatcher("listagem.jsp");
                rd.forward(request, response);
                break;
            }

            case ("formEditarDependente"): {
                long dependenteId = getLongParameterOrRedirectToIndex(request, response, "dependenteid");
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");

                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.getById(pessoaId);

                DependenteDao dependenteDao = new DependenteDao();
                Dependente dependente = dependenteDao.getById(dependenteId);
                request.setAttribute("pessoa", pessoa);
                request.setAttribute("dependente", dependente);
                RequestDispatcher rd = request.getRequestDispatcher("form_editar_dependente.jsp");
                rd.forward(request, response);
                break;
            }

            case ("editarDependente"): {
                long dependenteId = getLongParameterOrRedirectToIndex(request, response, "dependenteid");
                long pessoaId = getLongParameterOrRedirectToIndex(request, response, "pessoaid");
                DependenteDao dependenteDao = new DependenteDao();

                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");

                dependenteDao.edit(dependenteId, nome, sobrenome);
                //TODO:Separar trechos de codigo como este em commands(esta copiado lá de cima)
                RequestDispatcher rd = request.getRequestDispatcher("Servlet?action="
                        + "listarDependentes&pessoaid=" + pessoaId);
                rd.forward(request, response);
                break;
            }
        }
    }

    private long getLongParameterOrRedirectToIndex(HttpServletRequest request, HttpServletResponse response, String param) throws IOException, ServletException {
        String paramValue = request.getParameter(param);
        long pessoaId = 0;
        try {
            pessoaId = Long.parseLong(paramValue);
        } catch (NumberFormatException e) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        return pessoaId;
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
