<%-- 
    Document   : listagem
    Created on : 22/05/2015, 16:26:35
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/meyer css-reset.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de pessoas</title>
    </head>
    <body>
        <div class="container-fluid">
            <table class="table-condensed table-hover">
                <tr>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Dependentes</th>
                    <th class="warning">Excluir pessoa</th>
                    <th>Excluir todos os depedentes</th>
                    <th>Editar</th>
                </tr>
                <c:forEach items="${pessoas}" var="pessoa">
                    <tr>
                        <p>
                        <td>
                            <p>${pessoa.nome}</p>
                        </td>
                        <td>
                            <p>${pessoa.sobrenome}</p>
                        </td>
                        <td>
                            <a href="Servlet?action=listarDependentes&pessoaid=${pessoa.id}">
                                <p>dependentes</p>
                            </a>
                        </td>
                        <td class="warning"><a class="btn" href="Servlet?action=excluirPessoa&pessoaid=${pessoa.id}">
                                <span class="glyphicon glyphicon-trash" title="Excluir"/></a>
                        </td>
                        <td>
                            <a href="Servlet?action=excluirTodosDependentes&pessoaid=${pessoa.id}">
                                <span class="glyphicon glyphicon-trash" title="Excluir todos os dependentes"/>
                            </a></td>
                        <td>
                            <a href="Servlet?action=formEditarPessoa&pessoaid=${pessoa.id}">
                                <span class="glyphicon glyphicon-pencil" title="Editar"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
          <a href="adicionar_pessoa.jsp?">Adicionar pessoa</a>  
        </div>
    </body>
</html>
