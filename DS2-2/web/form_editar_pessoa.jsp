<%-- 
    Document   : form_editar_pessoa
    Created on : 22/05/2015, 19:59:39
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar pessoa</title>
    </head>
    <body>
        <form method="post" action="Servlet">
            <label for="nome">Nome </label>
            <input type="text" name="nome" placeholder="Nome" id="nome" value="${nome}"><br>
            <label for="sobrenome">Sobrenome </label>
            <input type="text" name="sobrenome" placeholder="Sobrenome"
                   id="sobrenome" value="${sobrenome}"><br>
            
            <input type="hidden" name="action" value="editarPessoa">
            <input type="submit">
        </form>
    </body>
</html>
