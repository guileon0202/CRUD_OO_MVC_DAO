<%-- 
    Document   : resultadoconsultartodos
    Created on : 03/06/2023, 15:45:38
    Author     : leong
--%>

<%@page import="java.util.List"%>
<%@page import="model.Vendas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="./Style/style_consultartodos.css">

        <title>Resultado Consultar Todos</title>
    </head>
    <body>
    <h1>Todos os Produtos</h1>
    <%
        List<Vendas> lvend = (List<Vendas>) request.getAttribute("lvend");
    %>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Data Venda</th>
            <th>Valor Venda</th>
            <th>Cliente</th>
            <th>Produto</th>
            <th>Quantidade</th>
            <th>Forma Pagamento</th>
            <th>Status Venda</th>
            <th>Vendedor</th>
            <th>Canal Vendas</th>
            <th>Remover</th>
            <th>Editar</th>
        </tr>

        <%for (Vendas v : lvend) {%>
        <tr>
            <td><%out.print(v.getId());%></td>
            <td><%out.print(v.getData_venda());%></td>
            <td><%out.print(v.getValor_venda());%></td>
            <td><%out.print(v.getCliente());%></td>
            <td><%out.print(v.getProduto());%></td>
            <td><%out.print(v.getQuantidade());%></td>
            <td><%out.print(v.getForma_pagamento());%></td>
            <td><%out.print(v.getStatus_venda());%></td>
            <td><%out.print(v.getVendedor());%></td>
            <td><%out.print(v.getCanal_vendas());%></td>
            <td align="center">
                <div class="icon-container">
                    <a href="http://localhost:8080/Proj_Vendas/controle_vendas?op=DELETAR&txtid=<%out.print(v.getId());%>">
                        <img src="Imagens/lixeira01.png" alt="Remover">
                    </a>
                </div>
            </td>
            <td align="center">
                <div class="icon-container">
                    <a href="http://localhost:8080/Proj_Vendas/controle_vendas?op=ATUALIZAR&txtid=<%out.print(v.getId());%>&txtdata_venda=<%out.print(v.getData_venda());%>&txtvalor_venda=<%out.print(v.getValor_venda());%>&txtcliente=<%out.print(v.getCliente());%>&txtproduto=<%out.print(v.getProduto());%>&txtquantidade=<%out.print(v.getQuantidade());%>&txtforma_pagamento=<%out.print(v.getForma_pagamento());%>&txtstatus_venda=<%out.print(v.getStatus_venda());%>&txtvendedor=<%out.print(v.getVendedor());%>&txtcanal_vendas=<%out.print(v.getCanal_vendas());%>&op=ATUALIZAR">
                        <img src="Imagens/editar01.png" alt="Editar">
                    </a>
                </div>
            </td>
        </tr>
        <%}%>
    </table>
</body>
</html>
