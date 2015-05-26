<%-- 
    Document   : listagem_dependentes
    Created on : 22/05/2015, 17:07:36
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!--Fonte Google Ubuntu-->
        <link href='http://fonts.googleapis.com/css?family=Ubuntu:700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/default.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de dependentes</title>
    </head>
    <body>
        <div class="container-fluid">
            <h3>Dependentes de ${pessoa.nome}</h3>
            <form method="POST" action="Servlet">
                <table class="table-condensed table-hover">
                    <c:forEach items="${dependentes}" var="dependente">
                        <tr>
                            <td>${dependente.nome}</td> 
                            <td>${dependente.sobrenome}</td> 
                            <td><a href="Servlet?action=excluirDependente&dependenteid=${dependente.id}&pessoaid=${pessoa.id}">Excluir</a></td>
                            <td><a href="Servlet?action=formEditarDependente&dependenteid=${dependente.id}&pessoaid=${pessoa.id}">Editar</a></td>
                            <td><input type="checkbox" name="dependenteSelecionado" value="${dependente.id}"></td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="action" value="excluirDependentesSelecionados">
                <input type="hidden" name="pessoaid" value="${pessoa.id}"><!--TODO:Isto é necessário?-->
                <input type="submit" value="Excluir selecionados">
            </form>
            <a href="adicionar_dependente.jsp?pessoaid=${pessoa.id}">Adicionar dependente</a>
        </div>
    </body>

</html>
