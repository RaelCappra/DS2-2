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
public class ExcluirDependenteCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long dependenteId = HttpUtil.getLongParameterOrRedirectToIndex(request, response, "dependenteid");
        if (dependenteId != null) {
            DependenteDao dependenteDao = new DependenteDao();
            dependenteDao.delete(dependenteId);
            new ListarDependentesCommand().executa(request, response);
        }
    }

}
