<%-- 
    Document   : adicionar_dependente
    Created on : 22/05/2015, 17:35:56
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar dependente</title>
    </head>
    <body>
        <form method="post" action="Servlet?action=adicionar_dependente">
            <label for="nome">Nome </label>
            <input type="text" name="nome" placeholder="Nome" id="nome"><br>
            <label for="sobrenome">Sobrenome </label>
            <input type="text" name="nome" placeholder="Sobrenome" id="sobrenome"><br>
            
            <input type="hidden" name="action" value="adicionar_dependente">
            <input type="submit">
        </form>
    </body>
</html>
