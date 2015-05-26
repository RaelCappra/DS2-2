<%-- 
    Document   : form_editar_dependente
    Created on : 23/05/2015, 20:22:28
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!--Fonte Google Ubuntu-->
        <link href='http://fonts.googleapis.com/css?family=Ubuntu:700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/default.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar dependente de ${pessoa.nome}</title>
    </head>
    <body>
        <form method="post" action="Servlet">
            <label for="nome">Nome </label>
            <input type="text" name="nome" placeholder="Nome" id="nome" value="${dependente.nome}"><br>
            <label for="sobrenome">Sobrenome </label>
            <input type="text" name="sobrenome" placeholder="Sobrenome"
                   id="sobrenome" value="${dependente.sobrenome}"><br>
            
            <input type="hidden" name="action" value="editarDependente">
            <input type="hidden" name="dependenteid" value="${dependente.id}">
            <input type="hidden" name="pessoaid" value="${pessoa.id}">
            <input type="submit">
        </form>
    </body>
</html>
