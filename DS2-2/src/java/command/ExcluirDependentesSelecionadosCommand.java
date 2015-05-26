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
import persistencia.DependenteDao;
import servlet.HttpUtil;

/**
 *
 * @author Rael
 */
public class ExcluirDependentesSelecionadosCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long[] idsDosDependentes
                = HttpUtil.getLongParameterValuesOrRedirectToIndex(request, response,
                        "dependenteSelecionado");
        if(idsDosDependentes != null){
            DependenteDao dependenteDao = new DependenteDao();
            for (long id : idsDosDependentes) {
                dependenteDao.delete(id);
            }
            new ListarDependentesCommand().executa(request, response);
        }
    }

}
