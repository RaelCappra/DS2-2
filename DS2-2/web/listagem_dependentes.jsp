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
        <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de dependentes</title>
    </head>
    <body>
        <div class="container-fluid">
            <h3>Dependentes de ${pessoa.nome}</h3>
<c:if test="${!(empty dependentes)}">
            <form id="form" method="POST" action="Servlet">
</c:if>
                <table class="table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Sobrenome</th>
                            <th>Excluir</th>
                            <th>Editar</th>
                            <th><span class="glyphicon glyphicon-check"/></th>
                        </tr>
                    </thead>
                    <c:forEach items="${dependentes}" var="dependente">
                        <tr>
                            <td>${dependente.nome}</td> 
                            <td>${dependente.sobrenome}</td> 
                            <td align="center"><a href="Servlet?action=excluirDependente&dependenteid=${dependente.id}&pessoaid=${pessoa.id}">
                                    <span class="glyphicon glyphicon-trash" title="Excluir"/></a></a></td>
                            <td align="center"><a href="Servlet?action=formEditarDependente&dependenteid=${dependente.id}&pessoaid=${pessoa.id}">
                                    <span class="glyphicon glyphicon-pencil" title="Editar"/></a></td>
                            <td><input type="checkbox" name="dependenteSelecionado" value="${dependente.id}"></td>
                        </tr>
                    </c:forEach>
                </table>
<c:if test="${!(empty dependentes)}">
                <input type="hidden" name="action" value="excluirDependentesSelecionados">
                <input type="hidden" name="pessoaid" value="${pessoa.id}">
                <button class="btn btn-danger" type="submit" >
                    <span class="glyphicon glyphicon-trash" title="Excluir"/>
                    <span>Excluir selecionados</span>
                </button>
            </form>
            
                <script type="text/javascript">
                    $('#form').validate({
                        rules: {
                            dependenteSelecionado:{
                                required: true
                            }
                        }
                    });
                </script>
</c:if>

            <a href="adicionar_dependente.jsp?pessoaid=${pessoa.id}">
                <button class="btn btn-success" type="submit" >
                    <span class="glyphicon glyphicon-plus" title="Adicionar"/>
                    <span>Adicionar dependente</span>
                </button>

            </a>
            
            <a href="Servlet?action=listarPessoas">
                <button class="btn btn-success" type="submit" >
                    <span class="glyphicon glyphicon-backward" title="Voltar"/>
                    <span>Voltar</span>
                </button>

            </a>
        </div>
    </body>

</html>
