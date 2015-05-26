/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rael
 */
public class HttpUtil {

    public static long getLongParameterOrRedirectToIndex(HttpServletRequest request, HttpServletResponse response, String param) throws IOException, ServletException {
        String paramValue = request.getParameter(param);
        long result = 0;
        try {
            result = Long.parseLong(paramValue);
        } catch (NumberFormatException e) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        return result;
    }

    public static long[] getLongParameterValuesOrRedirectToIndex(HttpServletRequest request, HttpServletResponse response, String param) throws IOException, ServletException {
        String[] paramValues = request.getParameterValues(param);
        if (paramValues == null || paramValues.length == 0) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return null;
        }
        long[] result = new long[paramValues.length];
        try {
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                result[i] = Long.parseLong(paramValue);
            }
        } catch (NumberFormatException e) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        return result;
    }

}
