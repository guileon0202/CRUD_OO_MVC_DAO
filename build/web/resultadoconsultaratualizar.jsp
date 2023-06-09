<%-- 
    Document   : resultadoconsultaratualizar
    Created on : 03/06/2023, 15:52:42
    Author     : leong
--%>

<%@page import="model.Vendas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="./Style/style_consultaratualizar.css">
        
        <title>Resultado Consultar By ID</title>
    </head>
    <body>
        <h1>Resultado Consultar By ID</h1>
        <%
            Vendas v = (Vendas) request.getAttribute("v");
        %>
        <%if (v.getCliente() != null) {%>

        <form name="f1" action="controle_vendas" method="GET">
            ID: <%out.print(  v.getId());%> <input type="hidden" name="txtid" value="<%out.print(v.getId());%>"> <BR>
            DATA VENDA: <input type="text" name="txtdata_venda" value="<%out.print(v.getData_venda());%>">  <BR>
            VALOR VENDA: <input type="text" name="txtvalor_venda" value="<%out.print(v.getValor_venda());%>">  <BR>
            CLIENTE: <input type="text" name="txtcliente" value="<%out.print(v.getCliente());%>">  <BR>
            PRODUTO: <input type="text" name="txtproduto" value="<%out.print(v.getProduto());%>">  <BR>
            QUANTIDADE: <input type="text" name="txtquantidade" value="<%out.print(v.getQuantidade());%>">  <BR>
            FORMA PAGAMENTO: <input type="text" name="txtforma_pagamento" value="<%out.print(v.getForma_pagamento());%>">  <BR>
            STATUS VENDA: <input type="text" name="txtstatus_venda" value="<%out.print(v.getStatus_venda());%>">  <BR>
            VENDEDOR: <input type="text" name="txtvendedor" value="<%out.print(v.getVendedor());%>">  <BR>
            CANAL VENDAS: <input type="text" name="txtcanal_vendas" value="<%out.print(v.getCanal_vendas());%>">  <BR>
            <input type="submit" name="op" value="EFETIVAR ATUALIZAÇÃO">
        </form>
        <%} else {%>
        <h2>Produto não encontrado.</h2>
        <%}%>
    </body>
</html>

