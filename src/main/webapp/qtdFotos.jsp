<%-- 
    Document   : qtdFotos
    Created on : Dec 27, 2020, 8:24:15 PM
    Author     : killuminatti08
--%>

<%@page import="com.ember.fotos_festa.model.foto.tbFotos"%>
<%@page import="com.ember.fotos_festa.dao.foto.ListFotosDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form>
    <fieldset class="text-muted">
        <legend>Novas Fotos 
            <%
// Set refresh, autoload time as 1 seconds
                HttpSession sessao = request.getSession();

                // Get current time
                int currentQtd = (Integer) sessao.getAttribute("qtd");

                ListFotosDAO list = new ListFotosDAO();

                List<tbFotos> fotos = list.List();

                //if (fotos.size() != currentQtd) {
                response.setIntHeader("Refresh", 10);

                // }
                out.println(" <span class='badge badge-secondary'>" + currentQtd + "</span></legend>");

            %>
    </fieldset>
</form>
