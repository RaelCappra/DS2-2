<%-- 
    Document   : listagem
    Created on : 22/05/2015, 16:26:35
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de pessoas</title>
    </head>
    <body>
        <table>
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <td>${pessoa.nome}</td>
                    <td>${pessoa.sobrenome}</td>
                    <td><a href="Servlet?action=listarDependentes&pessoaid=${pessoa.id}">dependentes</a></td>
                    <td><a href="Servlet?action=excluirPessoa&pessoaid=${pessoa.id}">Excluir</a></td>
                    <td><a href="Servlet?action=excluirTodosDependentes&pessoaid=${pessoa.id}">Excluir todos os dependentes</a></td>
                    <td><a href="Servlet?action=formEditarPessoa&pessoaid=${pessoa.id}">Editar</a></td>
                
                </tr>
            </c:forEach>
        </table>
        <a href="adicionar_pessoa.jsp?">Adicionar pessoa</a>
    </body>
</html>
