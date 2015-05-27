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
        <c:import url="header.html"/>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de pessoas</title>
    </head>
    <body>
        <div class="container-fluid">
            <c:choose>
                <c:when test="${!empty pessoas}">
                    <table class="table-condensed table-hover">
                        <thead>

                            <tr class="active">
                                <th>Nome</th>
                                <th>Sobrenome</th>
                                <th>Dependentes</th>
                                <th class="warning">Excluir pessoa</th>
                                <th>Excluir todos os depedentes</th>
                                <th>Editar</th>
                            </tr>
                        </thead>

                        <c:forEach items="${pessoas}" var="pessoa">
                            <tr>
                                <td align="center">
                                    <p>${pessoa.nome}</p>
                                </td>
                                <td align="center">
                                    <p>${pessoa.sobrenome}</p>
                                </td>
                                <td align="center">
                                    <a href="Servlet?action=listarDependentes&pessoaid=${pessoa.id}">
                                        <p>dependentes</p>
                                    </a>
                                </td>
                                <td align="center" class="warning"><a href="Servlet?action=excluirPessoa&pessoaid=${pessoa.id}">
                                        <span class="glyphicon glyphicon-trash" title="Excluir"/></a>
                                </td>
                                <td align="center">
                                    <a href="Servlet?action=excluirTodosDependentes&pessoaid=${pessoa.id}">
                                        <span class="glyphicon glyphicon-trash" title="Excluir todos os dependentes"/>
                                    </a></td>
                                <td align="center">
                                    <a href="Servlet?action=formEditarPessoa&pessoaid=${pessoa.id}">
                                        <span class="glyphicon glyphicon-pencil" title="Editar"/></a>
                                </td>
                            </tr>
                        </c:forEach>


                    </table>
                    <br>
                </c:when>
                <c:otherwise>
                    <h3>Você não cadastrou pessoas</h3>
                </c:otherwise>
            </c:choose>
            <a href="adicionar_pessoa.jsp?">
                <button class="btn btn-success" type="submit" >
                    <span class="glyphicon glyphicon-plus" title="Adicionar"/>
                    <span>Adicionar pessoa</span>
                </button>
            </a>
        </div>
    </body>
</html>
