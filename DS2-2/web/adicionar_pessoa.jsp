<%-- 
    Document   : adicionar_pessoa
    Created on : 22/05/2015, 18:52:23
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

        <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Pessoa</title>
    </head>
    <body>
        <div class="container">
            <form role="form" method="post" action="Servlet" id="form">
                <div class="form-group">                
                    <label for="nome">Nome </label>
                    <input class="form-control" type="text" name="nome" placeholder="Nome" id="nome" minlength="2" required><br>
                </div>                
                <div class="form-group">
                    <label for="sobrenome">Sobrenome </label>
                    <input class="form-control" type="text" name="sobrenome" placeholder="Sobrenome" id="sobrenome" required><br>
                </div>
                <input class="form-control" type="hidden" name="action" value="adicionarPessoa">
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
