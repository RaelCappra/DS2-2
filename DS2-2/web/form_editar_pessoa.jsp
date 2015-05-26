<%-- 
    Document   : form_editar_pessoa
    Created on : 22/05/2015, 19:59:39
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/default.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar pessoa</title>
    </head>
    <body>
        <form method="post" action="Servlet">
            <label for="nome">Nome </label>
            <input type="text" name="nome" placeholder="Nome" id="nome" value="${param.nome}"><br>
            <label for="sobrenome">Sobrenome </label>
            <input type="text" name="sobrenome" placeholder="Sobrenome"
                   id="sobrenome" value="${param.sobrenome}"><br>
            
            <input type="hidden" name="action" value="editarPessoa">
            <input type="hidden" name="pessoaid" value="${param.id}">
            <input type="submit">
        </form>
    </body>
</html>
