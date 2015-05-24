<%-- 
    Document   : adicionarDependente
    Created on : 22/05/2015, 17:35:56
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/meyer css-reset.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar dependente</title>
    </head>
    <body>
        <form method="post" action="Servlet">
            <label for="nome">Nome </label>
            <input type="text" name="nome" placeholder="Nome" id="nome"><br>
            <label for="sobrenome">Sobrenome </label>
            <input type="text" name="sobrenome" placeholder="Sobrenome" id="sobrenome"><br>
            
            <input type="hidden" name="action" value="adicionarDependente">
            <input type="hidden" name="pessoaid" value="${param.pessoaid}">
            <input type="submit">
        </form>
    </body>
</html>
