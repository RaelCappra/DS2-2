<%-- 
    Document   : listagem_dependentes
    Created on : 22/05/2015, 17:07:36
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de dependentes</title>
    </head>
    <body>
        <h2>Dependentes de ${pessoa.nome}</h2>
        <table>
            <c:forEach items="${dependentes}" var="dependente">
               <tr>
                    <td>${dependente.nome}</td> 
                    <td>${dependente.sobrenome}</td> 
                    <td>${dependente.id}</td> 
               </tr>
            </c:forEach>
        </table>
    </body>
</html>
