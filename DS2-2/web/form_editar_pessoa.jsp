<%-- 
    Document   : form_editar_pessoa
    Created on : 22/05/2015, 19:59:39
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="header.html"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar pessoa</title>
    </head>
    <body>
        <div class="container">
            <form id="form" role="form" method="post" action="Servlet">
                <div class="form-group"> 
                    <label for="nome">Nome </label>
                    <input class="form-control" type="text" name="nome" placeholder="Nome" id="nome" value="${nome}"><br>
                </div>
                <div class="form-group"> 
                    <label for="sobrenome">Sobrenome </label>
                    <input class="form-control" type="text" name="sobrenome" placeholder="Sobrenome"
                           id="sobrenome" value="${sobrenome}"><br>
                </div>
                <input type="hidden" name="action" value="editarPessoa">
                <input type="hidden" name="pessoaid" value="${id}">
                <button type="submit" class="btn btn-default">Enviar</button>
            </form>
            <a href="Servlet?action=listarPessoas">
                <button class="btn btn-success" type="submit" >
                    <span class="glyphicon glyphicon-backward" title="Voltar"/>
                    <span>Voltar</span>
                </button>

            </a>
        </div>
    </body>
    <script type="text/javascript" src="js/valida.js"></script>
</html>
