<%-- 
    Document   : resultadoconsultarbyid
    Created on : 03/06/2023, 15:58:19
    Author     : leong
--%>

<%@page import="model.Vendas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="./Style/style_consultarbyid.css">
        
        <title>Resultado Consultar By ID</title>
    </head>
    <body>
    <h1>Resultado Consultar By ID</h1>
    <table>
        <tbody>
            <%
            Vendas v = (Vendas) request.getAttribute("v");
            %>
            <% if (v.getCliente() != null) { %>
            <tr>
                <td class="label">ID:</td>
                <td><% out.print(v.getId()); %></td>
            </tr>
            <tr>
                <td class="label">DATA VENDA:</td>
                <td><% out.print(v.getData_venda()); %></td>
            </tr>
            <tr>
                <td class="label">VALOR VENDA:</td>
                <td><% out.print(v.getValor_venda()); %></td>
            </tr>
            <tr>
                <td class="label">CLIENTE:</td>
                <td><% out.print(v.getCliente()); %></td>
            </tr>
            <tr>
                <td class="label">PRODUTO:</td>
                <td><% out.print(v.getProduto()); %></td>
            </tr>
            <tr>
                <td class="label">QUANTIDADE:</td>
                <td><% out.print(v.getQuantidade()); %></td>
            </tr>
            <tr>
                <td class="label">FORMA PAGAMENTO:</td>
                <td><% out.print(v.getForma_pagamento()); %></td>
            </tr>
            <tr>
                <td class="label">STATUS VENDA:</td>
                <td><% out.print(v.getStatus_venda()); %></td>
            </tr>
            <tr>
                <td class="label">VENDEDOR:</td>
                <td><% out.print(v.getVendedor()); %></td>
            </tr>
            <tr>
                <td class="label">CANAL DE VENDAS:</td>
                <td><% out.print(v.getCanal_vendas()); %></td>
            </tr>
            <% } else { %>
            <tr>
                <td colspan="2">
                    <h2>Produto não encontrado.</h2>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    </p>
</body>
</html>

