<%-- 
    Document   : form_editar_dependente
    Created on : 23/05/2015, 20:22:28
    Author     : Rael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="header.html"/>
        
        <script src="js/array-equals.js"></script>
        <script src="js/easteregg.js"></script>
    <c:if test="${dependente.nome eq 'Illuminati' and dependente.sobrenome eq 'Illuminati'}">
        <script type="text/javascript">
            do_easteregg = true;
        </script>
    </c:if>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar dependente de ${pessoa.nome}</title>
    </head>
    <body>
        <div class="container">
            <form id="form" role="form" method="post" action="Servlet">
                <div class="form-group"> 
                    <label for="nome">Nome </label>
                    <input class="form-control" type="text" name="nome" placeholder="Nome" id="nome" value="${dependente.nome}"><br>
                </div>
                <div class="form-group"> 
                    <label for="sobrenome">Sobrenome </label>
                    <input class="form-control" type="text" name="sobrenome" placeholder="Sobrenome"
                           id="sobrenome" value="${dependente.sobrenome}"><br>
                </div>
                <input type="hidden" name="action" value="editarDependente">
                <input type="hidden" name="dependenteid" value="${dependente.id}">
                <input type="hidden" name="pessoaid" value="${pessoa.id}">
                <button type="submit" class="btn btn-default">Enviar</button>
            </form>
            <a href="Servlet?action=listarDependentes&pessoaid=${pessoa.id}">
                <button class="btn btn-success" type="submit" >
                    <span class="glyphicon glyphicon-backward" title="Voltar"/>
                    <span>Voltar</span>
                </button>

            </a>
            <br>
            <span class="hidden" id="easteregg">
                <img src="assets/illuminati.jpg"/>
                <br><audio controls id="audio">
  			<source src="assets/The X-Files Theme.mp3" type="audio/mp3">
			Your browser does not support the audio element.
		</audio>
            </span>
        </div>
    
    </body>
    <script type="text/javascript" src="js/valida.js"></script>
</html>
